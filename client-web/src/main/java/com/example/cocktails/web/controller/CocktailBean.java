package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.ejb.service.*;
import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import jakarta.enterprise.context.*;
import jakarta.inject.*;

import java.util.*;

@Named
@RequestScoped
public class CocktailBean {

    @EJB
    private CocktailService cocktailService;

    private Collection<Cocktail> cocktails;

    public Collection<Cocktail> getCocktails() {
        if (cocktails == null) {
            cocktails = cocktailService.getAllCocktails();
        }
        return cocktails;
    }

}
