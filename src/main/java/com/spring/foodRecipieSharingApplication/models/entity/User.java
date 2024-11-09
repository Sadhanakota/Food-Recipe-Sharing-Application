package com.spring.foodRecipieSharingApplication.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="userinfo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String userEmail;
    private String userPlace;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Recipe> recipeList;
}