package ru.itis.hateoasrest.services;

import ru.itis.hateoasrest.models.WishList;

import java.util.Optional;

public interface WishListService {
    WishList finish(Long listId);

    Optional<WishList> findWishListById(Long listId);
}
