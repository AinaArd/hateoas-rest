package ru.itis.hateoasrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.hateoasrest.models.WishList;
import ru.itis.hateoasrest.repositories.WishListRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {

    private WishListRepository wishListRepository;

    @Autowired
    public WishListServiceImpl(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    @Override
    public WishList publish(Long listId) {
        WishList wishList = wishListRepository.findById(listId).orElseThrow(NoSuchElementException::new);
        wishList.publish();
        wishListRepository.save(wishList);
        return wishList;
    }

    @Override
    public Optional<WishList> findWishListById(Long listId) {
        return wishListRepository.findById(listId);
    }
}
