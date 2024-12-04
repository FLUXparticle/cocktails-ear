package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.api.service.*;
import com.example.cocktails.cocktail.ejb.service.CocktailService;
import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import jakarta.enterprise.context.*;
import jakarta.inject.*;

import java.io.*;

@Named
@RequestScoped
public class CocktailDetailBean implements Serializable {

    @EJB
    private CocktailService cocktailService;

    private Long id;
    private Cocktail cocktail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cocktail getCocktail() {
        return cocktail;
    }

    public void loadCocktail() {
        if (id != null) {
            cocktail = cocktailService.getCocktail(id);
        }
    }

}
