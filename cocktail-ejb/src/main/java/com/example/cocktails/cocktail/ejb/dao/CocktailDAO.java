package com.example.cocktails.cocktail.ejb.dao;

import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import jakarta.persistence.*;

import java.util.*;

@Stateless
public class CocktailDAO {

    @PersistenceContext(unitName = "CocktailPU")
    private EntityManager em;

    public Collection<Cocktail> findAll() {
        TypedQuery<Cocktail> query = em.createQuery("SELECT c FROM Cocktail c ORDER BY c.name", Cocktail.class);
        return query.getResultList();
    }

    public Collection<Cocktail> findByNameContains(String queryStr) {
        TypedQuery<Cocktail> query = em.createQuery("SELECT c FROM Cocktail c WHERE c.name LIKE :query ORDER BY c.name", Cocktail.class);
        query.setParameter("query", "%" + queryStr + "%");
        return query.getResultList();
    }

    public Cocktail findById(Long id) {
        return em.find(Cocktail.class, id);
    }

    public void save(Cocktail cocktail) {
        em.persist(cocktail);
    }

    public void update(Cocktail cocktail) {
        em.merge(cocktail);
    }

    public void delete(Long id) {
        Cocktail cocktail = findById(id);
        if (cocktail != null) {
            em.remove(cocktail);
        }
    }

    void setEm(EntityManager em) {
        this.em = em;
    }

}
