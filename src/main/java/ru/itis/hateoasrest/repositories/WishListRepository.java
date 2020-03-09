package ru.itis.hateoasrest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoasrest.models.WishList;

import java.util.List;

public interface WishListRepository extends PagingAndSortingRepository<WishList, Long> {

    @RestResource(path = "published", rel = "findAllPublished")
    @Query("from WishList wishList where wishList.state = 'Published'")
    Page<WishList> findAllPublished(Pageable pageable);

    List<WishList> findAllByTitle(String title);

}
