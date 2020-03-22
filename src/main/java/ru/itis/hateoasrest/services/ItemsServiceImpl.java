package ru.itis.hateoasrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.hateoasrest.models.Item;
import ru.itis.hateoasrest.models.WishList;
import ru.itis.hateoasrest.repositories.ItemsRepository;

import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {

    private ItemsRepository itemsRepository;
    private WishListService wishListService;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository, WishListService wishListService) {
        this.itemsRepository = itemsRepository;
        this.wishListService = wishListService;
    }

    @Override
    public void removeByName(String itemName) {
        Optional<Item> itemCandidate = itemsRepository.findByName(itemName);
        if (itemCandidate.isPresent()) {
            itemsRepository.deleteById(itemCandidate.get().getId());
        } else {
            throw new IllegalArgumentException("Can not find such item");
        }
    }

    @Override
    public WishList getWishList(Long listId) {
        return wishListService
                .findWishListById(listId)
                .orElseThrow(() -> new IllegalArgumentException("Can not find such wish list"));
    }

    @Override
    public Optional<Item> findItemByName(String name) {
        return itemsRepository.findByName(name);
    }
}
