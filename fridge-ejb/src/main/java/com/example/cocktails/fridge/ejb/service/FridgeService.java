package com.example.cocktails.fridge.ejb.service;

import com.example.cocktails.cocktail.ejb.service.*;
import com.example.cocktails.fridge.api.model.*;
import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;

import java.util.*;
import java.util.stream.*;

@Stateful
public class FridgeService {

    private final Set<Ingredient> fridgeIngredients = new HashSet<>();

    @EJB
    private CocktailService cocktailService;

    public Set<Ingredient> getFridgeIngredients() {
        return fridgeIngredients;
    }

    public void addIngredient(Long ingredientId) {
        Ingredient ingredient = cocktailService.getIngredient(ingredientId);
        if (ingredient != null) {
            fridgeIngredients.add(ingredient);
        }
    }

    public void removeIngredient(Long ingredientId) {
        Ingredient ingredient = cocktailService.getIngredient(ingredientId);
        if (ingredient != null) {
            fridgeIngredients.remove(ingredient);
        }
    }

    public List<Ingredient> getIngredientsNotInFridge() {
        Set<Ingredient> currentFridge = getFridgeIngredients();
        return cocktailService.getAllIngredients().stream()
                .filter(ingredient -> !currentFridge.contains(ingredient))
                .collect(Collectors.toList());
    }

    public List<Cocktail> getPossibleCocktails() {
        Set<Ingredient> fridgeIngredients = getFridgeIngredients();
        List<Cocktail> possibleCocktails = new ArrayList<>();
        for (Cocktail cocktail : cocktailService.getAllCocktails()) {
            boolean allIngredientsPresent = true;
            for (Instruction instruction : cocktail.getInstructions()) {
                if (!fridgeIngredients.contains(instruction.getIngredient())) {
                    allIngredientsPresent = false;
                    break;
                }
            }
            if (allIngredientsPresent) {
                possibleCocktails.add(cocktail);
            }
        }
        return possibleCocktails;
    }

    public List<ShoppingModel> getCocktailsWithMissingIngredients() {
        Set<Ingredient> currentFridge = getFridgeIngredients();
        List<ShoppingModel> shoppingList = new ArrayList<>();

        for (Cocktail cocktail : cocktailService.getAllCocktails()) {
            List<String> present = new ArrayList<>();
            List<String> missing = new ArrayList<>();

            for (Instruction instruction : cocktail.getInstructions()) {
                Ingredient ingredient = instruction.getIngredient();
                if (currentFridge.contains(ingredient)) {
                    present.add(ingredient.getName());
                } else {
                    missing.add(ingredient.getName());
                }
            }

            if (!missing.isEmpty()) {
                shoppingList.add(new ShoppingModel(cocktail.getName(), present, missing));
            }
        }

        // Sortieren nach Anzahl der fehlenden Zutaten
        shoppingList.sort(Comparator.comparingInt(m -> m.getMissingIngredients().size()));

        return shoppingList;
    }

}