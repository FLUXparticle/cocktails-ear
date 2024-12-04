package com.example.cocktails.web.controller;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.model.entity.Cocktail;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class CocktailSearchBean implements Serializable {

    @EJB
    private CocktailServiceRemote cocktailService;

    private String query;
    private Collection<Cocktail> results;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Collection<Cocktail> getResults() {
        return results;
    }

    public void search() {
        if (query != null && !query.trim().isEmpty()) {
            results = cocktailService.search(query);
        }
    }

}
