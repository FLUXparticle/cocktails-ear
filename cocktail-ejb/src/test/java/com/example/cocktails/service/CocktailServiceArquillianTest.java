package com.example.cocktails.service;

import com.example.cocktails.cocktail.api.service.*;
import com.example.cocktails.model.entity.*;
import jakarta.ejb.*;
import org.jboss.arquillian.container.test.api.*;
import org.jboss.arquillian.junit5.*;
import org.jboss.shrinkwrap.api.*;
import org.jboss.shrinkwrap.api.spec.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import java.net.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ArquillianExtension.class)
public class CocktailServiceArquillianTest {

    @EJB
    private CocktailServiceRemote cocktailService;

    @Deployment
    public static JavaArchive createDeployment() {
        URL url = Database.class.getResource("/cocktails.xml");

        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true,
                        "com.example.cocktails.cocktail.ejb",
                        "com.example.cocktails.cocktail.api",
                        "com.example.cocktails.model")
                .addAsResource(url, "cocktails.xml")
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
    }

    @Test
    public void testFindAllCocktails() {
        assertNotNull(cocktailService);

        Collection<Cocktail> cocktails = cocktailService.getAllCocktails();

        assertNotNull(cocktails);
        assertFalse(cocktails.isEmpty(), "Cocktails list should not be empty");
        assertEquals(69, cocktails.size());
    }

}
