package org.springbootjpapractice.service.customer;

import org.springbootjpapractice.domain.Customer;
import org.springbootjpapractice.model.response.customer.CustomerDto;
import org.springbootjpapractice.model.request.CustomerRequestDto;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(CustomerRequestDto customerRequestDto);

    CustomerDto getCustomer(String customerID);

    List<CustomerDto> getCustomersWithoutOrder();

}
