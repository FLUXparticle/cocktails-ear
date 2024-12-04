package com.example.cocktails.fridge.ejb.service;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.model.entity.Cocktail;
import com.example.cocktails.model.entity.Ingredient;
import com.example.cocktails.model.entity.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FridgeServiceMockitoTest {

    @Mock
    private CocktailServiceRemote cocktailService;

    @InjectMocks
    private FridgeService fridgeService;

    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    private Cocktail cocktail1;
    private Cocktail cocktail2;
    private Cocktail cocktail3;

    @BeforeEach
    public void setUp() {
        ingredient1 = new Ingredient(1L, "Rum");
        ingredient2 = new Ingredient(2L, "Mint");
        ingredient3 = new Ingredient(3L, "Lime Juice");

        cocktail1 = new Cocktail(1L, "Mojito", List.of(
                new Instruction(null, 50, ingredient1),
                new Instruction(null, 10, ingredient2),
                new Instruction(null, 20, ingredient3)
        ));

        cocktail2 = new Cocktail(2L, "Mint Julep", List.of(
                new Instruction(null, 30, ingredient2),
                new Instruction(null, 20, ingredient1)
        ));

        cocktail3 = new Cocktail(3L, "Lime Cooler", List.of(
                new Instruction(null, 25, ingredient3)
        ));
    }

    @Test
    public void testAddIngredient() {
        // Arrange
        when(cocktailService.getIngredient(1L)).thenReturn(ingredient1);

        // Act
        fridgeService.addIngredient(1L);

        // Assert
        Set<Ingredient> fridge = fridgeService.getFridgeIngredients();
        assertEquals(1, fridge.size(), "There should be 1 ingredient in fridge");
        assertTrue(fridge.contains(ingredient1), "Fridge should contain Rum");
        verify(cocktailService, times(1)).getIngredient(1L);
    }

    @Test
    public void testRemoveIngredient() {
        // TODO
    }

    @Test
    public void testGetIngredientsNotInFridge() {
        // TODO
    }

    @Test
    public void testGetPossibleCocktails() {
        // TODO
    }

    @Test
    public void testGetPossibleCocktailsWithMissingIngredients() {
        // TODO
    }

    @Test
    public void testAddDuplicateIngredient() {
        // TODO
    }

    @Test
    public void testRemoveNonExistentIngredient() {
        // TODO
    }

}
