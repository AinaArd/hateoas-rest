package ru.itis.hateoasrest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
public class Collection {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int number;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<WishList> wishLists;

    public Collection(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
