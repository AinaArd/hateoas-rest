package ru.itis.hateoasrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.hateoasrest.services.WishListService;

@RepositoryRestController
public class CustomWishListsController {

    private WishListService wishListService;

    @Autowired
    public CustomWishListsController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @RequestMapping(value = "/wishLists/{listId}/finish", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> publish(@PathVariable("listId") Long listId) {
        return ResponseEntity.ok(new EntityModel<>(wishListService.finish(listId)));
    }

}
