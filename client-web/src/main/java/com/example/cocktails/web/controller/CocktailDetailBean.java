package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.model.entity.Cocktail;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class CocktailDetailBean implements Serializable {

    @EJB
    private CocktailServiceRemote cocktailService;

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
