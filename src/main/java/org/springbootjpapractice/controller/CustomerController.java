package org.springbootjpapractice.controller;


import org.springbootjpapractice.model.request.CustomerRequestDto;
import org.springbootjpapractice.model.response.Response;
import org.springbootjpapractice.model.response.SuccessDataResponse;
import org.springbootjpapractice.service.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("")
    public SuccessDataResponse createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return new SuccessDataResponse<>("Customer saved.", customerService.createCustomer(customerRequestDto));

    }

    @GetMapping("")
    public Response getCustomers(){
        return new SuccessDataResponse<>("Customer Takes Successfully",customerService.getCustomersWithoutOrder());

    }

    @GetMapping("/{id}")
    public Response getCustomer(@PathVariable("id")String customerId){
        return new SuccessDataResponse<>("Customer Records Retrieved Successfully",customerService.getCustomer(customerId));

    }
}
