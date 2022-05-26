package com.example.myapplication.service;

import com.example.myapplication.model.Order;
import com.example.myapplication.model.Product;
import com.example.myapplication.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void addOrder(Order order){
        Optional<Order>orderOptional = orderRepository.findById(order.getId());
        if (orderOptional.isPresent()){
            throw new IllegalArgumentException("order already exist");
        }

        orderRepository.save(order);
    }

    public Optional<Order> getOrderById(int id){
        return orderRepository.findById(id);
    }

    public Order updateOrder(Order order){
        this.getOrderById(order.getId());
        return orderRepository.save(order);
    }

    public void deleteOrder(int id){
        this.getOrderById(id);
        orderRepository.deleteById(id);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
}
