package com.example.cocktails.model.entity;

import jakarta.xml.bind.*;
import jakarta.xml.bind.helpers.*;
import org.junit.jupiter.api.*;

import java.net.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void testXmlDataImport() {
        try {
            // JAXB-Kontext initialisieren
            JAXBContext context = JAXBContext.newInstance(Database.class, Cocktail.class, Instruction.class, Ingredient.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            unmarshaller.setEventHandler(new DefaultValidationEventHandler() {
                @Override
                public boolean handleEvent(ValidationEvent event) {
                    System.out.println("Validation Event: " + event.getMessage());
                    return super.handleEvent(event);
                }
            });

            // Test-XML-Datei laden
            URL url = DatabaseTest.class.getResource("/cocktails.xml");
            Database database = (Database) unmarshaller.unmarshal(url);

            // Assertions prüfen
            assertNotNull(database, "Database object should not be null");
            assertNotNull(database.getIngredients(), "Ingredients list should not be null");
            assertNotNull(database.getCocktails(), "Cocktails list should not be null");

            assertEquals(54, database.getIngredients().size(), "There should be 62 ingredients");
            assertEquals(69, database.getCocktails().size(), "There should be 69 cocktail");

            Cocktail firstCocktail = database.getCocktails().get(0);
            assertEquals("Orange Velvet", firstCocktail.getName(), "First cocktail name should be 'Orange Velvet'");

            Collection<Instruction> instructions = firstCocktail.getInstructions();
            assertEquals(4, instructions.size());

            assertAll(instructions.stream().map(i -> () -> assertNotNull(i.getIngredient())));
        } catch (JAXBException e) {
            fail("JAXB Exception occurred: " + e.getMessage());
        }
    }

}
