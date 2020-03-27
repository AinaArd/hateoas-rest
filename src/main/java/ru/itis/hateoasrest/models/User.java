package ru.itis.hateoasrest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
@ToString(exclude = "wishLists")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String state;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<WishList> wishLists;

    public User(String login, String password, List<WishList> wishLists, String state) {
        this.login = login;
        this.password = password;
        this.wishLists = wishLists;
        this.state = state;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static User getDefaultUser() {
        User defaultUser = new User("Null login", "Null password");
        defaultUser.setWishLists(null);
        return defaultUser;
    }

    public void ban() {
        if (this.state.equals("Active")) {
            this.state = "Banned";
        } else if (this.state.equals("Banned")) {
            this.state = "Sleeping";
        }
    }
}
