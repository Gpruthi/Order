package com.nineleaps.project.order.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.nineleaps.project.order.config.exceptions.OrderNotExistException;
import com.nineleaps.project.order.entities.Order;
import com.nineleaps.project.order.services.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	private final OrderService service;

	@Autowired
	public OrderController(OrderService service) {
		this.service = service;
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return service.getAllOrders();
	}

	@GetMapping("/orders/{id}")
	public Optional<Order> getOrder(@PathVariable("id") UUID id) {
		try {
			return service.getOrder(id);
		} catch (OrderNotExistException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@PostMapping("/orders")
	public Order addOrder(@RequestBody Order order) {
		return service.addOrder(order);

	}

}
