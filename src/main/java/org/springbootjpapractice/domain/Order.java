package org.springbootjpapractice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "order_id")
    private String orderID;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JsonIgnore
    @JoinTable(name = "order_items",
            joinColumns = {
                    @JoinColumn(name = "order_id", referencedColumnName = "order_id",
                            nullable = true, updatable = true)},
            inverseJoinColumns = {
                    @JoinColumn(name = "item_id", referencedColumnName = "item_id",
                            nullable = true, updatable = true)})
    private List<Item> orderItems=new ArrayList<>();

    public Order() {
    }

    public Order(String orderID) {
        this.orderID = orderID;
    }

    public Order(String orderID, Customer customer) {
        this.orderID = orderID;
        this.customer = customer;
    }

    public Order(String orderID, Customer customer, List<Item> orderItems) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public void addItem(Item item) {
        this.orderItems.add(item);
        this.getOrderItems().stream().forEach(item1 -> item1.setOrders(Arrays.asList(this)));
    }
}
