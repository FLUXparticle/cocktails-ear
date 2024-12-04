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
public class IngredientDetailBean implements Serializable {

    @EJB
    private CocktailService cocktailService;

    private Long id;
    private Ingredient ingredient;
    private Collection<Cocktail> cocktails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Collection<Cocktail> getCocktails() {
        return cocktails;
    }

    public void loadIngredient() {
        if (id != null) {
            ingredient = cocktailService.getIngredient(id);
            // Finden Sie alle Cocktails, die diese Zutat beinhalten
            cocktails = cocktailService.getAllCocktailsWithIngredient(id);
        }
    }

}
