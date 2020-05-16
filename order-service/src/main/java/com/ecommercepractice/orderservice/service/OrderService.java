package com.ecommercepractice.orderservice.service;

import com.ecommercepractice.orderservice.exception.OrderByIdNotFoundException;
import com.ecommercepractice.orderservice.model.Orders;
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

    /**
     * Transform an Order object to a OderDTO object
     * @param orders
     * @return
     */
    public OrderDTO orderToDTO(Orders orders){
        return new OrderDTO(orders,orderProductsListService.getProducts(orders.getOrderProductListUniqueId()));
    }

    /**
     * Transform a list of Orders objects to a List of OrderDTO's
     * @param ordersList
     * @return
     */
    public List<OrderDTO> orderListToDTOList(List<Orders> ordersList){
        List<OrderDTO> orderDTOS = ordersList
                .stream()
                .map(orders -> orderToDTO(orders))
                .collect(Collectors.toList());
        return orderDTOS;
    }

    /**
     * Find all orders.
     * @return
     */

    public List<OrderDTO> fetchAll() {
        return orderListToDTOList(orderRepository.findAll());
    }

    /**
     * Fetch the Order which orderId
     * @param orderId
     * @return
     */
    public OrderDTO fetchByOrderId(Integer orderId) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderByIdNotFoundException(orderId));
        return orderToDTO(orders);
    }

    /**
     * Fetch all the orders that a given user by its id made.
     * @param userId
     * @return
     */
    public List<OrderDTO> fetchByUserId(Integer userId) {
        return orderListToDTOList(orderRepository.findAllByUserId(userId));

    }

    /**
     * Create a new Confirmation order to a given user.
     * @param userId
     * @param confirmModel
     * @return
     */
    public Orders confirm(Integer userId, ConfirmationModel confirmModel) {
        Integer uniqueID = orderProductsListService.createListProducts(confirmModel.getProductList());

        Orders orders =  Orders.builder()
                .orderProductListUniqueId(uniqueID)
                .amount(confirmModel.getAmount())
                .date(LocalDate.now())
                .paymentBill(confirmModel.getPaymentBill())
                .userId(userId)
                .build();

        orderRepository.save(orders);

        return orders;
    }
}

