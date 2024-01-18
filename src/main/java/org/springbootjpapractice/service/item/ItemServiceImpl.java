package org.springbootjpapractice.service.item;

import org.springbootjpapractice.domain.Item;
import org.springbootjpapractice.exceptions.BadRequestException;
import org.springbootjpapractice.model.response.item.ItemDto;
import org.springbootjpapractice.model.request.ItemRequestDto;
import org.springbootjpapractice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(ItemRequestDto itemRequestDto) {
        Item item = new Item();
        item.setItemName(itemRequestDto.getItemName());
        return itemRepository.save(item);
    }

    @Override
    public ItemDto getItem(String itemID) {
        ItemDto itemDto = itemRepository.findByItemID(itemID, ItemDto.class);
        if (itemDto==null) throw new BadRequestException(String.format("Item Not Found With ID:%S",itemID));
        else return itemDto;
    }


    @Override
    public List<ItemDto> getItemWithoutOrders() {
        return itemRepository.findAllBy();
    }
}
