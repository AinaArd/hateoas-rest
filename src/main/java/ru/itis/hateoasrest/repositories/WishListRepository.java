package ru.itis.hateoasrest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoasrest.models.WishList;

import java.util.List;

@RepositoryRestResource
public interface WishListRepository extends PagingAndSortingRepository<WishList, Long> {

    @RestResource(path = "finished", rel = "finished")
    @Query("from WishList wishList where wishList.state = 'Finished'")
    Page<WishList> findAllPublished(Pageable pageable);

    List<WishList> findAllByTitle(String title);

}
