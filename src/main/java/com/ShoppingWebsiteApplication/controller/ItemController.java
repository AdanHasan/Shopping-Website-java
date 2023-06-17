package com.ShoppingWebsiteApplication.controller;


import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.model.Order;
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
        public Long createItem(@RequestBody Item item){
            return itemService.createItem(item);
        }

       @CrossOrigin
        @GetMapping(value = "/get/{itemId}")
        public Item getItemById(@PathVariable Long itemId){
            return itemService.getItemById(itemId);
        }


        @CrossOrigin
        @DeleteMapping(value="/delete/{itemId}")
        private void deleteItemById(@PathVariable("itemId") Long itemId)
        {
            itemService.deleteItemById(itemId);
        }

//       @CrossOrigin
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin
@PutMapping(value = "/update/{itemId}")
        private void updateItem(@PathVariable Long itemId ,@RequestBody Item item)
        {
            itemService.updateItem(item, itemId);
        }



//    @CrossOrigin
//    @PutMapping(value = "/update")
//    private void updateItem(@RequestBody Item[] itemsarr)
//    {
//        int x=5;
//            itemService.updateItem(itemsarr );
//    }


    @CrossOrigin
    @GetMapping(value = "/getAll")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }


    }

