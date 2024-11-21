// cocktail-model/src/main/java/com/example/cocktails/entity/Database.java
package com.example.cocktails.model.entity;

import jakarta.xml.bind.annotation.*;

import java.util.*;

@XmlRootElement(name = "cocktails")
public class Database {

    @XmlElement(name = "ingredient")
    private List<Ingredient> ingredients;

    @XmlElement(name = "cocktail")
    private List<Cocktail> cocktails;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Cocktail> getCocktails() {
        return cocktails;
    }

}
