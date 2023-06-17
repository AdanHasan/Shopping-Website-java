package com.ShoppingWebsiteApplication.service;
import com.ShoppingWebsiteApplication.model.Item;

import java.util.List;

public interface ItemService {
    Long createItem(Item item );

    Item getItemById( Long itemId);

    void deleteItemById(Long itemId);

//    void updateItem( Item[] itemsarr );

     void updateItem(Item item, Long itemId);
    List<Item> getAllItems();


}
