package ru.itis.hateoasrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import ru.itis.hateoasrest.models.User;
import ru.itis.hateoasrest.services.UsersService;

@RestController
public class UserInfoController {

    private UsersService userService;

    @Autowired
    public UserInfoController(UsersService usersService) {
        this.userService = usersService;
    }
//
//    @RequestMapping(path = "/profile/{userId}", method = RequestMethod.PUT)
//    public @ResponseBody
//    EntityModel<User> getProfilePage(@PathVariable("userId") Long id) {
//        Optional<User> userCandidate = userService.findUserById(id);
//        if (userCandidate.isPresent()) {
//            return new EntityModel<>(userCandidate.get());
//        } else {
//            throw new NoSuchElementException("Can not find user with such id");
//        }
//    }

    @RequestMapping(path = "/users/{userId}/ban", method = RequestMethod.PUT)
    public @ResponseBody
    EntityModel<User> banUser(@PathVariable("userId") Long id) {
        return new EntityModel<>(userService.ban(id));

    }

    @RequestMapping(path = "/users/{userId}/sleep", method = RequestMethod.PUT)
    public @ResponseBody
    EntityModel<User> sleep(@PathVariable("userId") Long id) {
        return new EntityModel<>(userService.ban(id));

    }

}
