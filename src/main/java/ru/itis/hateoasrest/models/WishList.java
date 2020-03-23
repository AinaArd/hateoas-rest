package ru.itis.hateoasrest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class WishList {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String state;

    @JsonIgnore
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "author")
    private User author;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "wishList", cascade = CascadeType.ALL)
    private List<Item> items;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "collection")
    private Collection collection;

    public WishList(String title, String state, User author, List<Item> items) {
        this.title = title;
        this.state = state;
        this.author = author;
        this.items = items;
    }

    public WishList(Long id, String title, String state) {
        this.id = id;
        this.title = title;
        this.state = state;
    }

    public static WishList getDefault() {
        WishList defaultWishList = new WishList(null, "Null wish list", "Draft");
        defaultWishList.setAuthor(User.getDefaultUser());
        defaultWishList.setItems(null);
        return defaultWishList;
    }

    public void publish() {
        if (this.state.equals("Draft")) {
            this.state = "Published";
        } else if (this.state.equals("Deleted")) {
            throw new IllegalStateException();
        }
    }
}
