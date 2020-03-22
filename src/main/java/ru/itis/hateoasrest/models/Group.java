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
@Table(name = "\"group\"")
public class Group {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<Item> items;

    public Group(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }
}
