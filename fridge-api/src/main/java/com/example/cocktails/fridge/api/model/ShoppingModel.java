package com.example.cocktails.fridge.api.model;

import java.util.*;

public class ShoppingModel {

    private String cocktailName;
    private List<String> presentIngredients;
    private List<String> missingIngredients;

    public ShoppingModel(String cocktailName, List<String> presentIngredients, List<String> missingIngredients) {
        this.cocktailName = cocktailName;
        this.presentIngredients = presentIngredients;
        this.missingIngredients = missingIngredients;
    }

    // Getter und Setter

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public List<String> getPresentIngredients() {
        return presentIngredients;
    }

    public void setPresentIngredients(List<String> presentIngredients) {
        this.presentIngredients = presentIngredients;
    }

    public List<String> getMissingIngredients() {
        return missingIngredients;
    }

    public void setMissingIngredients(List<String> missingIngredients) {
        this.missingIngredients = missingIngredients;
    }

}
