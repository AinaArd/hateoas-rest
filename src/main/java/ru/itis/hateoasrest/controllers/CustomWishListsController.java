package ru.itis.hateoasrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.itis.hateoasrest.models.WishList;
import ru.itis.hateoasrest.repositories.WishListRepository;

@RepositoryRestController
public class CustomWishListsController {

    private WishListRepository wishListRepository;

    @Autowired
    public CustomWishListsController(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @PutMapping("/lists/{listId}/publish")
    public ResponseEntity<?> publish(@PathVariable("listId") Long listId) {
        WishList wishList = wishListRepository.getOne(listId);
        wishList.publish();
        wishListRepository.save(wishList);
        return ResponseEntity.ok().build();
    }
}
