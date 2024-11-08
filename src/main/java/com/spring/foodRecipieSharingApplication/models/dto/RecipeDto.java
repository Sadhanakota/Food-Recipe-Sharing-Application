package com.spring.foodRecipieSharingApplication.models.dto;

import lombok.Data;

import java.util.Date;
@Data
public class RecipeDto {

    private String title;
    private String description;
    private Date createDate;
}
