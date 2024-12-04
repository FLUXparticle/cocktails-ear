package com.example.cocktails.web.controller;

import com.example.cocktails.fridge.api.model.ShoppingModel;
import com.example.cocktails.fridge.api.service.FridgeServiceRemote;
import com.example.cocktails.model.entity.Cocktail;
import com.example.cocktails.model.entity.Ingredient;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Named
@SessionScoped
public class FridgeBean implements Serializable {

    @EJB
    private FridgeServiceRemote fridgeService;

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
