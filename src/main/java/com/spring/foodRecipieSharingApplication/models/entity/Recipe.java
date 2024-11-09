package com.spring.foodRecipieSharingApplication.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.ClientInfoStatus;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String steps;
    private Date createDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "recipe",cascade = CascadeType.REMOVE)
    private List<Ratings> ratings;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private List<Ingrediants> ingrediants;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name="recipe_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    private List<Category> categoryList;
}
