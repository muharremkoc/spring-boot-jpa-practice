package org.springbootjpapractice.controller;

import org.springbootjpapractice.domain.Order;
import org.springbootjpapractice.model.request.CustomerRequestDto;
import org.springbootjpapractice.model.request.OrderRequestDto;
import org.springbootjpapractice.model.response.Response;
import org.springbootjpapractice.model.response.SuccessDataResponse;
import org.springbootjpapractice.service.order.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("")
    public SuccessDataResponse createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return new SuccessDataResponse<>("Order saved.", orderService.createOrder(orderRequestDto));
    }

    @GetMapping("")
    public Response getOrders(){
        return new SuccessDataResponse<>("Order Takes Successfully",orderService.getOrders());
    }
}
