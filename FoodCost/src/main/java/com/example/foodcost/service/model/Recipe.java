package com.example.foodcost.service.model;

import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipe {
    private String name;

    @OneToMany
    private List<Ingredient> ingredients = new ArrayList<>();
}
