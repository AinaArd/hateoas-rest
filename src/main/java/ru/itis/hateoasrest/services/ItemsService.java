package ru.itis.hateoasrest.services;

import ru.itis.hateoasrest.models.Item;
import ru.itis.hateoasrest.models.WishList;

import java.util.Optional;

public interface ItemsService {
    void removeByName(String itemName);
    WishList getWishList(Long listId);
    Optional<Item> findItemByName(String name);
}
