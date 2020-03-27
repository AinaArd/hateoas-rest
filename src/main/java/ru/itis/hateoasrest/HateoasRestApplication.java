package ru.itis.hateoasrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.hateoasrest.models.*;
import ru.itis.hateoasrest.repositories.*;

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
        GroupsRepository groupsRepository = context.getBean(GroupsRepository.class);
        CollectionsRepository collectionsRepository = context.getBean(CollectionsRepository.class);

        User user = new User("aina", "aina", new ArrayList<>(), "Active");

        WishList wishList = new WishList("Aina's birthday", "Draft", user, new ArrayList<>());
        WishList wishList2 = new WishList("8th March in ACI", "Deleted", user, new ArrayList<>());

        Item item = new Item("iphone", 100000, "https://www.apple.com/ru/iphone-11-pro/",
                "the best phone ever", wishList);
        Item item2 = new Item("android", 5000, "https://www.android.com",
                "not the best phone ever", wishList);
        wishList.setItems(asList(item, item2));
        user.setWishLists(asList(wishList, wishList2));

        Group group = new Group("phones", asList(item, item2));
        item.setGroups(Collections.singletonList(group));
        item2.setGroups(Collections.singletonList(group));

        Collection collection = new Collection("For girls", 2);
        collection.setWishLists(asList(wishList, wishList2));
        wishList.setCollection(collection);
        wishList2.setCollection(collection);

        usersRepository.save(user);
        itemsRepository.saveAll(asList(item, item2));
        wishListRepository.save(wishList);
        groupsRepository.save(group);
        collectionsRepository.save(collection);
    }
}
