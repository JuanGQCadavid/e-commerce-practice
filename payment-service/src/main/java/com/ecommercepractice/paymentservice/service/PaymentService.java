package com.ecommercepractice.paymentservice.service;

import com.ecommercepractice.paymentservice.exceptions.BillNotFoundException;
import com.ecommercepractice.paymentservice.exceptions.CardServiceException;
import com.ecommercepractice.paymentservice.exceptions.ErrorMessage;
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
import org.springframework.context.PayloadApplicationEvent;
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

    public Bill performCardPayment(String amount, PaymentTypeInfo paymentTypeInfo) {
        PaymentMessage paymentMessage = new PaymentMessage(paymentTypeInfo,new PaymentInfo(LocalDate.now().toString(),amount));

        try {
            return executePayment(paymentMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Bill executePayment(PaymentMessage paymentMessage) throws IOException {
        Response<CardResponse> responseCall = cardService.cardWithdraw(paymentMessage).execute();

        if(!responseCall.isSuccessful()){
            CardFail errorMessage = generateErrorMessage(responseCall);
            throw new CardServiceException(errorMessage);
        }

        return savePayment(paymentMessage,responseCall.body());
    }
    private CardFail generateErrorMessage( Response responseCall) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseCall.errorBody().string(), CardFail.class);
    }

    private Bill savePayment(PaymentMessage paymentMessage, CardResponse bill) {
        Payment payment = paymentRepository.save(new Payment(paymentMessage,bill));
        return new Bill(payment);
    }

    public Bill fetchPaymentByBillNumber(String billNumber) {
        // Missing this exception.
        Payment payment = paymentRepository.findByBillNumber(billNumber)
                .orElseThrow( () -> new BillNotFoundException(billNumber));
        return new Bill(payment);
    }

    public List<Bill> fetchAllBills() {
        List<Bill> bills = paymentRepository.findAll()
                .stream()
                .map(Bill::new)
                .collect(Collectors.toList());
        return bills;
    }


}
