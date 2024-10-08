package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")

public class ItemController {


    @Autowired
    ItemService itemService;


    @PostMapping(value = "/create")
    @CrossOrigin
    public Long createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @CrossOrigin
    @GetMapping(value = "/get/{itemId}")
    public Item getItemById(@PathVariable Long itemId) {
        return itemService.getItemById(itemId);
    }

    @CrossOrigin
    @GetMapping(value = "/get/price/{itemId}")
    public Double getItemPriceById(@PathVariable Long itemId) {
        return itemService.getItemPriceById(itemId);
    }

    @CrossOrigin
    @DeleteMapping(value = "/delete/{itemId}")
    private void deleteItemById(@PathVariable("itemId") Long itemId) {
        itemService.deleteItemById(itemId);
    }


    @CrossOrigin
    @PutMapping(value = "/update/{itemId}")
    private void updateItem(@PathVariable Long itemId, @RequestBody Item item) {
        itemService.updateItem(item, itemId);
    }

    @CrossOrigin
    @PutMapping(value = "/update/quantity/{itemId}")
    private void updateItemQuantity(@PathVariable Long itemId) {
        itemService.updateItemQuantity(itemId);
    }

//    @CrossOrigin
//    @PutMapping(value = "/update/quantity/{itemId}")
//    private void returnItemQuantity(@PathVariable Long itemId ,@RequestBody Item item)
//    {
//        itemService.updateItem(item, itemId);
//    }

//    @CrossOrigin
//    @PutMapping(value = "/update")
//    private void updateItem(@RequestBody Item[] itemsarr)
//    {
//        int x=5;
//            itemService.updateItem(itemsarr );
//    }


    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

}

