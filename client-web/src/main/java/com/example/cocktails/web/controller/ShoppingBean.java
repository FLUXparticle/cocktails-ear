package com.example.cocktails.web.controller;

import jakarta.faces.view.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@ViewScoped
public class ShoppingBean implements Serializable {

    // Einkaufsliste als Set, um Duplikate zu vermeiden und die Reihenfolge zu erhalten
    private final Set<String> shoppingList = new LinkedHashSet<>();

    // Getter für die Einkaufsliste
    public Set<String> getShoppingList() {
        return shoppingList;
    }

    // Methode zum Hinzufügen von Zutaten zur Einkaufsliste
    public void addIngredients(List<String> ingredients) {
        if (ingredients != null && !ingredients.isEmpty()) {
            shoppingList.addAll(ingredients);
        }
    }

    // Methode zum Entfernen einer Zutat aus der Einkaufsliste
    public void removeIngredient(String ingredient) {
        shoppingList.remove(ingredient);
    }

    // Methode zum Leeren der gesamten Einkaufsliste (optional)
    public void clearShoppingList() {
        shoppingList.clear();
    }

}