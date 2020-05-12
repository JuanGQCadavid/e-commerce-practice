package com.ecommercepractice.orderservice.service;

import com.ecommercepractice.orderservice.model.Order;
import com.ecommercepractice.orderservice.model.OrderDTO;
import com.ecommercepractice.orderservice.model.confirm.ConfirmationModel;
import com.ecommercepractice.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductsListService orderProductsListService;

    public List<OrderDTO> fetchAll() {
        List<OrderDTO> orderDTOS = orderRepository.findAll()
                .stream()
                .map(order -> new OrderDTO(order,orderProductsListService.getProducts(order.getOrderProductListUniqueId())))
                .collect(Collectors.toList());

        return orderDTOS;
    }

    /*
    public Order fetchByOrderId(Integer orderId) {
    }

    public List<Order> fetchByUserId(Integer userId) {
    }

     */

    public Order confirm(Integer userId, ConfirmationModel confirmModel) {
        Integer uniqueID = orderProductsListService.createListProducts(confirmModel.getProductList());

        Order order =  Order.builder()
                .orderProductListUniqueId(uniqueID)
                .amount(confirmModel.getAmount())
                .date(LocalDate.now())
                .paymentBill(confirmModel.getPaymentBill())
                .build();

        orderRepository.save(order);

        return order;
    }

}

