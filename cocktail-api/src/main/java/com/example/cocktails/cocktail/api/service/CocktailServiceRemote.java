package com.example.cocktails.cocktail.api.service;

import com.example.cocktails.model.entity.*;

import java.util.*;

public interface CocktailServiceRemote {

    Collection<Cocktail> getAllCocktailsWithIngredient(Long ingredientId);

    Collection<Ingredient> getAllIngredients();

    Collection<Cocktail> getAllCocktails();

    Cocktail getCocktail(Long id);

    Ingredient getIngredient(Long id);

    Collection<Cocktail> search(String query);

}
