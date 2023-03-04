package com.example.foodcost.repo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.foodcost.entity.Recipe;
import com.example.foodcost.service.RecipeService;
@Repository

public interface RecipeRepo	extends CrudRepository<Recipe, String>{



}
