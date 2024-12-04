package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.api.service.*;
import com.example.cocktails.cocktail.ejb.service.CocktailService;
import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import jakarta.enterprise.context.*;
import jakarta.inject.*;

import java.io.*;
import java.util.*;

@Named
@RequestScoped
public class IngredientBean implements Serializable {

    @EJB
    private CocktailService cocktailService;

    private Collection<Ingredient> ingredients;

    public Collection<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = cocktailService.getAllIngredients();
        }
        return ingredients;
    }

}
