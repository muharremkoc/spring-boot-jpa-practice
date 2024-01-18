package org.springbootjpapractice.service.order;

import org.springbootjpapractice.domain.Customer;
import org.springbootjpapractice.domain.Item;
import org.springbootjpapractice.domain.Order;
import org.springbootjpapractice.exceptions.BadRequestException;
import org.springbootjpapractice.model.response.order.OrderDto;
import org.springbootjpapractice.model.request.OrderRequestDto;
import org.springbootjpapractice.repository.CustomerRepository;
import org.springbootjpapractice.repository.ItemRepository;
import org.springbootjpapractice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    private final CustomerRepository customerRepository;
    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Order createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        Customer customer = customerRepository.findByCustomerID(orderRequestDto.getCustomerID(), Customer.class);
        orderRequestDto.getItemRequestDtoList().stream().forEach(itemRequestDto -> {
            Item item = itemRepository.findByItemName(itemRequestDto.getItemName(),Item.class);
            order.addItem(item);

        });
        if (customer==null) throw new BadRequestException(String.format("Customer Not Found With ID:%S",orderRequestDto.getCustomerID()));
        order.setCustomer(customer);
        customer.addOrder(Arrays.asList(order));


        return orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getOrders() {
        return orderRepository.findAllBy();
    }
}
