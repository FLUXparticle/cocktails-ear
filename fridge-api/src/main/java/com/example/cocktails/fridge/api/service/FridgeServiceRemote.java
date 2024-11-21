package com.example.cocktails.fridge.api.service;

import com.example.cocktails.fridge.api.model.*;
import com.example.cocktails.model.entity.*;

import java.util.*;

public interface FridgeServiceRemote {

    Set<Ingredient> getFridgeIngredients();

    void addIngredient(Long ingredientId);

    void removeIngredient(Long ingredientId);

    List<Ingredient> getIngredientsNotInFridge();

    List<Cocktail> getPossibleCocktails();

    List<ShoppingModel> getCocktailsWithMissingIngredients();

}
