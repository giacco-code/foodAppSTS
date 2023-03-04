package com.example.foodcost.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Ingredient {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Integer qty;
}
