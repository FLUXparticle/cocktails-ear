package com.example.cocktails.cocktail.ejb.service;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.cocktail.ejb.dao.CocktailDAO;
import com.example.cocktails.cocktail.ejb.dao.IngredientDAO;
import com.example.cocktails.model.entity.Cocktail;
import com.example.cocktails.model.entity.Ingredient;
import com.example.cocktails.model.entity.Instruction;
import jakarta.ejb.EJB;
import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

import java.util.*;

@Stateless
@Remote(CocktailServiceRemote.class)
public class CocktailService implements CocktailServiceRemote {

    @EJB
    private CocktailDAO cocktailDAO;

    @EJB
    private IngredientDAO ingredientDAO;

    public Collection<Cocktail> getAllCocktailsWithIngredient(Long ingredientId) {
        return getAllCocktailsWithIngredients(Collections.singleton(ingredientId));
    }

    public Collection<Ingredient> getAllIngredients() {
        return ingredientDAO.findAll();
    }

    public Collection<Cocktail> getAllCocktails() {
        return cocktailDAO.findAll();
    }

    public Cocktail getCocktail(Long id) {
        return cocktailDAO.findById(id);
    }

    public Ingredient getIngredient(Long id) {
        return ingredientDAO.findById(id);
    }

    public Collection<Cocktail> search(String query) {
        Collection<Cocktail> cocktailsWithName = cocktailDAO.findByNameContains(query);
        Collection<Ingredient> ingredientsWithName = ingredientDAO.findByNameContains(query);

        Set<Long> ingredientIDs = new HashSet<>();
        for (Ingredient ingredient : ingredientsWithName) {
            ingredientIDs.add(ingredient.getId());
        }

        SortedSet<Cocktail> result = getAllCocktailsWithIngredients(ingredientIDs);
        result.addAll(cocktailsWithName);

        return result;
    }

    private SortedSet<Cocktail> getAllCocktailsWithIngredients(Set<Long> ingredientIDs) {
        SortedSet<Cocktail> result = new TreeSet<>();

        for (Cocktail cocktail : getAllCocktails()) {
            for (Instruction instruction : cocktail.getInstructions()) {
                if (ingredientIDs.contains(instruction.getIngredient().getId())) {
                    result.add(cocktail);
                    break;
                }
            }
        }

        return result;
    }

}
