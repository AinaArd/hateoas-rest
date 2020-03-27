package ru.itis.hateoasrest.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.hateoasrest.models.User;

import java.util.Optional;

public interface UsersRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @RestResource(path = "banned", rel = "banned")
    @Query("from User user where user.state = 'Banned'")
    Page<User> findAllBanned(Pageable pageable);
}

