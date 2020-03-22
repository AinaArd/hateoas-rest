package ru.itis.hateoasrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ru.itis.hateoasrest.controllers.CustomWishListsController;
import ru.itis.hateoasrest.models.WishList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class WishListsRepresentationProcessor implements RepresentationModelProcessor<EntityModel<WishList>> {

    @Autowired
    private RepositoryEntityLinks links;

    @Autowired
    public WishListsRepresentationProcessor(RepositoryEntityLinks links) {
        this.links = links;
    }

    @Override
    public EntityModel<WishList> process(EntityModel<WishList> model) {
        WishList wishList = model.getContent();
        if (wishList != null) {
            switch (wishList.getState()) {
                case "Draft":
                    model.add(linkTo(methodOn(CustomWishListsController.class).publish(wishList.getId())).withRel("publish"));
                case "Published":
                    model.add(links.linkToItemResource(WishList.class, wishList.getId()).withRel("delete"));
            }
        }
        return model;
    }
}
