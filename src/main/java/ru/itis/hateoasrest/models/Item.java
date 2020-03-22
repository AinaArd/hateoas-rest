package ru.itis.hateoasrest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private String link;
    private String description;

    @ManyToOne
    @JoinColumn(name = "wishList")
    private WishList wishList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_group",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;

    public Item(String name, int price, String link, String description, WishList wishList) {
        this.name = name;
        this.price = price;
        this.link = link;
        this.description = description;
        this.wishList = wishList;
    }
}
