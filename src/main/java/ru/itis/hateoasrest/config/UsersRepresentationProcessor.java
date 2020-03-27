package ru.itis.hateoasrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.hateoasrest.controllers.UserInfoController;
import ru.itis.hateoasrest.models.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UsersRepresentationProcessor implements RepresentationModelProcessor<EntityModel<User>> {

    private RepositoryEntityLinks links;

    @Autowired
    public UsersRepresentationProcessor(RepositoryEntityLinks links) {
        this.links = links;
    }

    @Override
    public EntityModel<User> process(EntityModel<User> model) {
        User user = model.getContent();
        if (user != null) {
            switch (user.getState()) {
                case "Active":
                    model.add(linkTo(methodOn(UserInfoController.class).banUser(user.getId())).withRel("ban"));
                    break;
                case "Banned":
                    model.add(linkTo(methodOn(UserInfoController.class).sleep(user.getId())).withRel("sleep"));
                    break;
            }
        }
        return model;
    }
}
