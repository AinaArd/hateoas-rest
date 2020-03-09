package ru.itis.hateoasrest.services;

import ru.itis.hateoasrest.models.WishList;

public interface WishListService {
    WishList publish(Long listId);
}
