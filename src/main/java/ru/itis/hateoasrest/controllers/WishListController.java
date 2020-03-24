package ru.itis.hateoasrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.hateoasrest.dto.ItemDto;
import ru.itis.hateoasrest.models.WishList;
import ru.itis.hateoasrest.services.ItemsService;
import ru.itis.hateoasrest.services.WishListService;

@RestController
public class WishListController {

    private ItemsService itemsService;
    private WishListService wishListService;

    @Autowired
    public WishListController(ItemsService itemsService, WishListService wishListService) {
        this.itemsService = itemsService;
        this.wishListService = wishListService;
    }

    @CrossOrigin
    @RequestMapping(path = "/wishLists/{listId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWishList(@PathVariable Long listId) {
        WishList defaultWishList = WishList.getDefault();
        return ResponseEntity.ok(wishListService.findWishListById(listId).orElse(defaultWishList));
    }

    @CrossOrigin
    @RequestMapping(path = "/wishLists/{listId}", method = RequestMethod.POST)
    public void addNewItem(@PathVariable Long listId, ItemDto itemDto) {
        itemsService.addNewItem(itemDto, listId);
    }

    @CrossOrigin
    @DeleteMapping("/wishLists/{listId}")
    public void deleteItem(@PathVariable Long listId, @RequestParam("title") String itemName) {
        itemsService.removeByName(itemName);
    }
}
