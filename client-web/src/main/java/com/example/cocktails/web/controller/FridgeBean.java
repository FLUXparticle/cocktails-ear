package com.example.cocktails.web.controller;

import com.example.cocktails.fridge.api.model.*;
import com.example.cocktails.fridge.api.service.*;
import com.example.cocktails.fridge.ejb.service.FridgeService;
import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import jakarta.enterprise.context.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@SessionScoped
public class FridgeBean implements Serializable {

    @EJB
    private FridgeService fridgeService;

    // Hinzufügen einer Zutat zum Kühlschrank
    public void addIngredient(Long ingredientId) {
        fridgeService.addIngredient(ingredientId);
    }

    // Entfernen einer Zutat aus dem Kühlschrank
    public void removeIngredient(Long ingredientId) {
        fridgeService.removeIngredient(ingredientId);
    }

    // Getter für die Zutaten im Kühlschrank
    public Set<Ingredient> getFridgeIngredients() {
        return fridgeService.getFridgeIngredients();
    }

    // Getter für die Zutaten, die nicht im Kühlschrank sind
    public List<Ingredient> getIngredientsNotInFridge() {
        return fridgeService.getIngredientsNotInFridge();
    }

    // Getter für mögliche Cocktails
    public List<Cocktail> getPossibleCocktails() {
        return fridgeService.getPossibleCocktails();
    }

    // Getter für Cocktails mit fehlenden Zutaten
    public List<ShoppingModel> getCocktailsWithMissingIngredients() {
        return fridgeService.getCocktailsWithMissingIngredients();
    }

}
