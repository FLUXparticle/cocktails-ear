package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.model.entity.Ingredient;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class IngredientBean implements Serializable {

    @EJB
    private CocktailServiceRemote cocktailService;

    private Collection<Ingredient> ingredients;

    public Collection<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = cocktailService.getAllIngredients();
        }
        return ingredients;
    }

}
