package ru.itis.hateoasrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.hateoasrest.models.Item;
import ru.itis.hateoasrest.models.User;
import ru.itis.hateoasrest.models.WishList;
import ru.itis.hateoasrest.repositories.ItemsRepository;
import ru.itis.hateoasrest.repositories.UsersRepository;
import ru.itis.hateoasrest.repositories.WishListRepository;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;

@SpringBootApplication
public class HateoasRestApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasRestApplication.class, args);

        ItemsRepository itemsRepository = context.getBean(ItemsRepository.class);
        WishListRepository wishListRepository = context.getBean(WishListRepository.class);
        UsersRepository usersRepository = context.getBean(UsersRepository.class);

        User user = new User("aina", "aina", new ArrayList<>());
        WishList wishList = new WishList("Aina's birthday", "Draft", user, new ArrayList<>());
        Item item = new Item("iphone", 100000, "https://www.apple.com/ru/iphone-11-pro/", "the best phone ever", wishList);
        Item item2 = new Item("android", 5000, "https://www.android.com", "not the best phone ever", wishList);

        wishList.setItems(asList(item, item2));
        user.setWishLists(Collections.singletonList(wishList));

        usersRepository.save(user);
        itemsRepository.saveAll(asList(item, item2));
        wishListRepository.save(wishList);
    }
}
