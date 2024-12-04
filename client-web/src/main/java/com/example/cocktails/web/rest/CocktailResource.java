package com.example.cocktails.web.rest;

import com.example.cocktails.cocktail.api.service.CocktailServiceRemote;
import com.example.cocktails.model.entity.Cocktail;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Collection;

@Path("/cocktails")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CocktailResource {

    @EJB
    private CocktailServiceRemote cocktailService;

    @GET
    public Collection<Cocktail> getAllCocktails() {
        return cocktailService.getAllCocktails();
    }

    @GET
    @Path("/{id}")
    public Cocktail getCocktail(@PathParam("id") Long id) {
        return cocktailService.getCocktail(id);
    }

    // Weitere Endpunkte...

}
