package ru.itis.hateoasrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoasrest.models.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
