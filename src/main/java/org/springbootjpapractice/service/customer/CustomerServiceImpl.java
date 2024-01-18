package org.springbootjpapractice.service.customer;

import org.springbootjpapractice.domain.Customer;
import org.springbootjpapractice.exceptions.BadRequestException;
import org.springbootjpapractice.model.response.customer.CustomerDto;
import org.springbootjpapractice.model.request.CustomerRequestDto;
import org.springbootjpapractice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = new Customer();
        customer.setCustomerName(customerRequestDto.getCustomerName());

        return  customerRepository.save(customer);
    }

    @Override
    public CustomerDto getCustomer(String customerID) {
        CustomerDto customerDto = customerRepository.findByCustomerID(customerID, CustomerDto.class);
        if (customerDto==null) throw new BadRequestException(String.format("Customer Not Found With ID:%S",customerID));
        else return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomersWithoutOrder() {
        return customerRepository.findAllBy();
    }
}
