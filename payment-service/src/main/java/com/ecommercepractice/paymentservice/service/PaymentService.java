package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.exceptions.BillNotFoundException;
import com.ecommercepractice.paymentservice.exceptions.CardServiceException;
import com.ecommercepractice.paymentservice.models.Bill;
import com.ecommercepractice.paymentservice.models.CardMessage.PaymentMessage;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentInfo;
import com.ecommercepractice.paymentservice.models.CardMessage.body.PaymentTypeInfo;
import com.ecommercepractice.paymentservice.models.Payment;
import com.ecommercepractice.paymentservice.models.responses.CardFail;
import com.ecommercepractice.paymentservice.models.responses.CardResponse;
import com.ecommercepractice.paymentservice.repository.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class PaymentService {
    @Autowired
    CardService cardService;

    @Autowired
    PaymentRepository paymentRepository;

    /**
     * This method builds and send the information needed to use
     * card's service withdraw.
     * @param paymentTypeInfo
     * @return
     */
    public Bill performCardPayment(PaymentTypeInfo paymentTypeInfo) {
        PaymentMessage paymentMessage = new PaymentMessage(paymentTypeInfo,new PaymentInfo(LocalDate.now().toString(),paymentTypeInfo.getAmount()));
        try {
            CardResponse cardResponse =  executePayment(paymentMessage);
            return savePayment(paymentMessage,cardResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Perform the Card's service call and return its response, if cards fail to process
     * the request then throws an exception.
     * @param paymentMessage
     * @return
     * @throws IOException
     */
    private CardResponse executePayment(PaymentMessage paymentMessage) throws IOException {
        Response<CardResponse> responseCall = cardService.cardWithdraw(paymentMessage).execute();
        if(!responseCall.isSuccessful()){
            CardFail errorMessage = generateErrorMessage(responseCall);
            throw new CardServiceException(errorMessage);
        }
        return responseCall.body();
    }

    /**
     * Maps Card error to CardServiceException.
     * @param responseCall
     * @return
     * @throws IOException
     */
    private CardFail generateErrorMessage( Response responseCall) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseCall.errorBody().string(), CardFail.class);
    }

    /**
     * Save the payment onto the server and return the bill of the payment.
     * @param paymentMessage
     * @param bill
     * @return
     */
    private Bill savePayment(PaymentMessage paymentMessage, CardResponse bill) {
        Payment payment = paymentRepository.save(new Payment(paymentMessage,bill));
        return new Bill(payment);
    }

    /**
     * Fetch a bill by its identifier.
     * @param billNumber
     * @return
     */
    public Bill fetchPaymentByBillNumber(String billNumber) {
        Payment payment = paymentRepository.findByBillNumber(billNumber)
                .orElseThrow( () -> new BillNotFoundException(billNumber));
        return new Bill(payment);
    }

    /**
     * Fetches all bills.
     * @return
     */
    public List<Bill> fetchAllBills() {
        List<Bill> bills = paymentRepository.findAll()
                .stream()
                .map(Bill::new)
                .collect(Collectors.toList());
        return bills;
    }


}
