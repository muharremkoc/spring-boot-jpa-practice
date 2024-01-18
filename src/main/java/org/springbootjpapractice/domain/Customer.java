package org.springbootjpapractice.domain;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.UUID;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "customer_id")
    private String customerID;

    private String customerName;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="customer")
    private List<Order> orders=new ArrayList<>();

    public Customer() {
    }

    public Customer(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public Customer(String customerID, String customerName, List<Order> orders) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.orders = orders;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(List<Order> orderList){

        orderList.stream().forEach(order -> {
            order.setCustomer(this);
        });
        this.orders=orderList;
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }


}
