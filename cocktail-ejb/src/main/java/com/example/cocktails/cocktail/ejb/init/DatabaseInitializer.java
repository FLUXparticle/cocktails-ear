package com.example.cocktails.cocktail.ejb.init;

import com.example.cocktails.model.entity.*;
import jakarta.annotation.*;
import jakarta.ejb.*;
import jakarta.persistence.*;
import jakarta.transaction.*;
import jakarta.xml.bind.*;

import java.net.*;

@Startup
@Singleton
public class DatabaseInitializer {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    @Transactional
    public void initDatabase() {
        try {
            // JAXB-Kontext initialisieren
            JAXBContext context = JAXBContext.newInstance(Database.class, Cocktail.class, Instruction.class, Ingredient.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Test-XML-Datei laden
            URL url = Database.class.getResource("/cocktails.xml");
            Database database = (Database) unmarshaller.unmarshal(url);

            // Daten in die Datenbank speichern
            for (Cocktail cocktail : database.getCocktails()) {
                System.err.println(cocktail);
                for (Instruction instruction : cocktail.getInstructions()) {
                    Long cocktailId = cocktail.getId();
                    Ingredient ingredient = instruction.getIngredient();
                    Long ingredientId = ingredient.getId();
                    InstructionKey instructionKey = new InstructionKey(cocktailId, ingredientId);
                    instruction.setKey(instructionKey);
                }
                em.persist(cocktail);
            }
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
