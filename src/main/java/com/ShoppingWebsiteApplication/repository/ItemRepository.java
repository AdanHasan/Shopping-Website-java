package com.ShoppingWebsiteApplication.repository;

import com.ShoppingWebsiteApplication.model.Item;

import java.util.List;

public interface ItemRepository {

    Long createItem(Item item);

    Item getItemById(Long itemId);

    Double getItemPriceById(Long itemId);

    Long getItemQuantityById(Long itemId);

    void deleteItemById(Long itemId);

    void updateItem(Item item, Long itemId);

    void updateItemQuantity(Long itemId);

    void incItemQuantitys(Long itemId, Long quantity);

    void decItemQuantity(Long itemId);

    void incItemQuantity(Long itemId);

    List<Item> getAllItems();

}
