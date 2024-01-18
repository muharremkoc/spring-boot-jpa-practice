package org.springbootjpapractice.model.request;

import java.util.List;

public class OrderRequestDto {

    private String customerID;

    private List<ItemRequestDto> itemRequestDtoList;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public List<ItemRequestDto> getItemRequestDtoList() {
        return itemRequestDtoList;
    }

    public void setItemRequestDtoList(List<ItemRequestDto> itemRequestDtoList) {
        this.itemRequestDtoList = itemRequestDtoList;
    }
}
