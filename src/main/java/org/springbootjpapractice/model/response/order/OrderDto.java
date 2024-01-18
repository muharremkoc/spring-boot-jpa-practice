package org.springbootjpapractice.model.response.order;

import org.springbootjpapractice.model.response.customer.CustomerDtoForOrder;
import org.springbootjpapractice.model.response.item.ItemDtoForOrder;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface OrderDto {

    String getOrderID();

    CustomerDtoForOrder getCustomer();
    List<ItemDtoForOrder> getOrderItems();
}
