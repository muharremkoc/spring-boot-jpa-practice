package org.springbootjpapractice.controller;

import org.springbootjpapractice.model.request.ItemRequestDto;
import org.springbootjpapractice.model.response.Response;
import org.springbootjpapractice.model.response.SuccessDataResponse;
import org.springbootjpapractice.service.item.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public SuccessDataResponse createItem(@RequestBody ItemRequestDto itemRequestDto){
        return new SuccessDataResponse<>("Item saved.", itemService.createItem(itemRequestDto));

    }

    @GetMapping("")
    public Response getItem(){
        return new SuccessDataResponse<>("Item Takes Successfully",itemService.getItemWithoutOrders());
    }

    @GetMapping("/{id}")
    public Response getItem(@PathVariable("id")String itemId){
        return new SuccessDataResponse<>("Item Records Retrieved Successfully",itemService.getItem(itemId));

    }

}
