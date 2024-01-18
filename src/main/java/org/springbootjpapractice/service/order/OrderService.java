package org.springbootjpapractice.service.order;

import org.springbootjpapractice.domain.Order;
import org.springbootjpapractice.model.response.order.OrderDto;
import org.springbootjpapractice.model.request.OrderRequestDto;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderRequestDto orderRequestDto);

    List<OrderDto> getOrders();
}
