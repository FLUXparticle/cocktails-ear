package com.example.cocktails.cocktail.ejb.dao;

import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import jakarta.persistence.*;

import java.util.*;

@Stateless
public class IngredientDAO {

    @PersistenceContext(unitName = "CocktailPU")
    private EntityManager em;

    public Collection<Ingredient> findAll() {
        TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i ORDER BY i.name", Ingredient.class);
        return query.getResultList();
    }

    public Collection<Ingredient> findByNameContains(String queryStr) {
        TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.name LIKE :query ORDER BY i.name", Ingredient.class);
        query.setParameter("query", "%" + queryStr + "%");
        return query.getResultList();
    }

    public Ingredient findById(Long id) {
        return em.find(Ingredient.class, id);
    }

    public void save(Ingredient ingredient) {
        em.persist(ingredient);
    }

    public void update(Ingredient ingredient) {
        em.merge(ingredient);
    }

    public void delete(Long id) {
        Ingredient ingredient = findById(id);
        if (ingredient != null) {
            em.remove(ingredient);
        }
    }

}
