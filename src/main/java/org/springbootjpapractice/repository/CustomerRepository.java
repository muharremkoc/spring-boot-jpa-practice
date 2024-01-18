package org.springbootjpapractice.repository;

import org.springbootjpapractice.domain.Customer;
import org.springbootjpapractice.model.response.customer.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {


    List<CustomerDto> findAllBy();


    <T> T findByCustomerID(String customerId, Class<T> type);

}
