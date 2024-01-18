package org.springbootjpapractice.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "item_id")
    private String itemID;

    @Column(unique = true)
    private String itemName;


    @ManyToMany(mappedBy = "orderItems", cascade = CascadeType.ALL)
    List<Order> orders=new ArrayList<>();


    public Item() {
    }

    public Item(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public Item(String itemID, String itemName, List<Order> orders) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.orders = orders;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        this.orders.add(order);
        this.getOrders().stream().forEach(order1 -> order1.setOrderItems(Arrays.asList(this)));
    }
}
