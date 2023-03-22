package com.example.foodcost.service.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Ingredient {
    private final String name;
    private final String description;
    private final Integer qty; // gr?
}
