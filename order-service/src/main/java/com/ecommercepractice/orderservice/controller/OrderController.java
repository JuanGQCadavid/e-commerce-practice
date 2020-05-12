package com.ecommercepractice.orderservice.controller;

import com.ecommercepractice.orderservice.model.Order;
import com.ecommercepractice.orderservice.model.OrderDTO;
import com.ecommercepractice.orderservice.model.confirm.ConfirmationModel;
import com.ecommercepractice.orderservice.service.OrderService;
import io.swagger.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(){
        log.info(String.format("ORDER | FETCH ALL "));
        return new ResponseEntity(orderService.fetchAll(),HttpStatus.CREATED);
    }

    /*
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable Integer orderId){
        log.info(String.format("ORDER | FETCH BY ORDER_ID | {%s}",orderId));
        return new ResponseEntity<Order>(orderService.fetchByOrderId(orderId),HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrderByUserId (@PathVariable Integer userId){
        log.info(String.format("ORDER | FETCH BY USER_ID | {%s}",userId));
        return new ResponseEntity<List<Order>>(orderService.fetchByUserId(userId),HttpStatus.CREATED);
    }

     */

    @PostMapping("/confirm/{userId}")
    public ResponseEntity<Order> confirmation(@PathVariable Integer userId, @RequestBody ConfirmationModel confirmModel){
        log.info(String.format("ORDER | CONFIRM | {%s} | {%s} ",userId,confirmModel));
        return new ResponseEntity<Order>(orderService.confirm(userId,confirmModel),HttpStatus.CREATED);
    }
}
