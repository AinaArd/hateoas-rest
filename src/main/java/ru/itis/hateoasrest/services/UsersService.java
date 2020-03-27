package ru.itis.hateoasrest.services;

import ru.itis.hateoasrest.dto.UserDto;
import ru.itis.hateoasrest.models.User;

import java.util.Optional;

public interface UsersService {
    void addUser(UserDto userDto);
    Optional<User> findUserByLogin(String login);
    Optional<User> findUserById(Long id);

    User ban(Long id);
}
