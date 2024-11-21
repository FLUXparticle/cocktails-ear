package com.example.cocktails.service;

import com.example.cocktails.cocktail.ejb.dao.*;
import com.example.cocktails.cocktail.ejb.service.*;
import com.example.cocktails.model.entity.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CocktailServiceMockitoTest {

    @Mock
    private CocktailDAO cocktailDAO;

    @Mock
    private IngredientDAO ingredientDAO;

    @InjectMocks
    private CocktailService cocktailService;

    @Test
    public void testGetAllCocktailsWithIngredient() {
        // Arrange
        Ingredient ingredient = new Ingredient(1L, "Rum");
        Cocktail cocktail1 = new Cocktail(1L, "Mojito", List.of(new Instruction(null, 50, ingredient)));
        Cocktail cocktail2 = new Cocktail(2L, "Pina Colada", List.of(new Instruction(null, 60, ingredient)));

        when(cocktailDAO.findAll()).thenReturn(Arrays.asList(cocktail1, cocktail2));

        // Act
        Collection<Cocktail> result = cocktailService.getAllCocktailsWithIngredient(1L);

        // Assert
        assertNotNull(result, "Result should not be null");
        assertEquals(2, result.size(), "There should be 2 cocktails with the ingredient");
        assertTrue(result.stream().anyMatch(c -> "Mojito".equals(c.getName())), "Mojito should be in the result");
        assertTrue(result.stream().anyMatch(c -> "Pina Colada".equals(c.getName())), "Pina Colada should be in the result");
        verify(cocktailDAO, times(1)).findAll();
    }

    @Test
    public void testSearch() {
        // TODO
    }

}
