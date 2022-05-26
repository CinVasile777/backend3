package com.example.myapplication.controller;

import com.example.myapplication.model.Order;
import com.example.myapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }

    @PatchMapping("/updateOrder")
    public void updateOrder(@RequestBody Order order){
        orderService.updateOrder(order);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/order/{id}")
    public Optional<Order> getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/all")
    public List<Order>getAllOrder(){
        return orderService.getAllOrder();
    }
}
