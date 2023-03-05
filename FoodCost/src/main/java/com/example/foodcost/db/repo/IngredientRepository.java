package com.example.foodcost.db.repo;

import com.example.foodcost.db.entity.IngredientEntity;
import com.example.foodcost.db.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, String> {
}
