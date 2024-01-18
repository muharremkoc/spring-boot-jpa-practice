package org.springbootjpapractice.service.item;

import org.springbootjpapractice.domain.Item;
import org.springbootjpapractice.model.response.item.ItemDto;
import org.springbootjpapractice.model.request.ItemRequestDto;

import java.util.List;

public interface ItemService {

    Item createItem(ItemRequestDto itemRequestDto);

    ItemDto getItem(String itemID);

    List<ItemDto> getItemWithoutOrders();

}
