package org.springbootjpapractice.repository;

import org.springbootjpapractice.domain.Order;
import org.springbootjpapractice.model.response.order.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {


    List<OrderDto> findAllBy();



}
