package com.ecommercepractice.orderservice.controller;

import com.ecommercepractice.orderservice.model.Orders;
import com.ecommercepractice.orderservice.model.OrderDTO;
import com.ecommercepractice.orderservice.model.confirm.ConfirmationModel;
import com.ecommercepractice.orderservice.service.OrderService;
import io.swagger.annotations.ApiOperation;
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

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation(value = "FETCH ALL", notes = "Fetch all Orders")
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(){
        log.info(String.format("ORDER | FETCH ALL "));
        return new ResponseEntity(orderService.fetchAll(),HttpStatus.CREATED);
    }

    @ApiOperation(value = "FETCH BY ORDER ID", notes = "Fetch the order that corresponds to the given orderId ")
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrderByOrderId(@PathVariable Integer orderId){
        log.info(String.format("ORDER | FETCH BY ORDER_ID | {%s}",orderId));
        return new ResponseEntity(orderService.fetchByOrderId(orderId),HttpStatus.CREATED);
    }

    @ApiOperation(value = "FETCH BY USER ID", notes = "Fetch all orders that where performed by a given userId")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getOrderByUserId (@PathVariable Integer userId){
        log.info(String.format("ORDER | FETCH BY USER_ID | {%s}",userId));
        return new ResponseEntity(orderService.fetchByUserId(userId),HttpStatus.CREATED);
    }

    @ApiOperation(value = "CONFIRM A ORDER", notes = "Create a new order")
    @PostMapping("/confirm/{userId}")
    public ResponseEntity<Orders> confirmation(@PathVariable Integer userId,@Valid @RequestBody ConfirmationModel confirmModel){
        log.info(String.format("ORDER | CONFIRM | {%s} | {%s} ",userId,confirmModel));
        return new ResponseEntity<Orders>(orderService.confirm(userId,confirmModel),HttpStatus.CREATED);
    }
}
