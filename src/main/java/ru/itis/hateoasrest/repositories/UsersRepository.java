package ru.itis.hateoasrest.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.hateoasrest.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}

