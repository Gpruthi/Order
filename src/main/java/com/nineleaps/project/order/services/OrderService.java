package com.nineleaps.project.order.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nineleaps.project.order.config.exceptions.OrderNotExistException;
import com.nineleaps.project.order.entities.Order;

@Service
public interface OrderService {

	List<Order> getAllOrders();

	Optional<Order> getOrder(UUID id) throws OrderNotExistException;

	Order addOrder(Order order);
}
