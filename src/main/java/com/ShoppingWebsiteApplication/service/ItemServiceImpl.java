package com.ShoppingWebsiteApplication.service;

import com.ShoppingWebsiteApplication.model.Item;
import com.ShoppingWebsiteApplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    @Override
    public Long createItem(Item item) {
        return itemRepository.createItem(item);
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.getItemById(itemId);
    }


    @Override
    public void deleteItemById(Long itemId) {
         itemRepository.deleteItemById(itemId);
    }

//    @Override
//    public void updateItem(Item[] itemsarr ) {
//         itemRepository.updateItem(itemsarr );
//    }

    @Override
    public void updateItem(Item item, Long itemId) {itemRepository.updateItem(item , itemId);}

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }


        }


