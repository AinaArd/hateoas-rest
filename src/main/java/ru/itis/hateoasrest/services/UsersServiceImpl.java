package ru.itis.hateoasrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.hateoasrest.dto.UserDto;
import ru.itis.hateoasrest.models.User;
import ru.itis.hateoasrest.repositories.UsersRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void addUser(UserDto userDto) {
//        String hashPassword = passwordEncoder.encode(userDto.getPassword());
        User newUser = new User(userDto.getLogin(), userDto.getPassword());
        usersRepository.save(newUser);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public User ban(Long id) {
        Optional<User> user = usersRepository.findById(id);
        if (user.isPresent()) {
            user.get().ban();
            return usersRepository.save(user.get());
        } else {
            throw new NoSuchElementException("Can not find such user");
        }
    }
}
