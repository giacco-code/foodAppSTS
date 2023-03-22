package com.example.foodcost.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

//fixme there is not a key to avoid duplicate
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class IngredientEntity {
    @Id
    private String id;
    @NonNull
    private String name;
    private String description;
    @NonNull
    private Integer qty; // gr?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngredientEntity that = (IngredientEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
