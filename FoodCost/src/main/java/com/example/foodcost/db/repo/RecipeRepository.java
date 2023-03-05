package com.example.foodcost.db.repo;

import com.example.foodcost.db.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RecipeRepository extends JpaRepository<RecipeEntity, String> {

}
