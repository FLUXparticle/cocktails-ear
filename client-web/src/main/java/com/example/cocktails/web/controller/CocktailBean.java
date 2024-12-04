package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.model.entity.Cocktail;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Collection;

@Named
@RequestScoped
public class CocktailBean {

    @EJB
    private CocktailServiceRemote cocktailService;

    private Collection<Cocktail> cocktails;

    public Collection<Cocktail> getCocktails() {
        if (cocktails == null) {
            cocktails = cocktailService.getAllCocktails();
        }
        return cocktails;
    }

}
