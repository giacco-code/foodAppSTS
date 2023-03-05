package com.example.foodcost.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IngredientEntity {
    @Id
    private String id;
    @NonNull
    private String name;
    private String description;
    @NonNull
    private Integer qty; // gr?
}
