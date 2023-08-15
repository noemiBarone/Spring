package com.example.Esercizi.Spring2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Esercizio2 {

    private List<Meal> listaConPrezziFiltrati = new ArrayList<>();
    private List<Meal> lista = Arrays.asList(
            new Meal ("Pollo", "Pollo", 4.99),
            new Meal("Orecchiette e cime di rapa", "Orecchiette e cime di rapa", 6.89),
            new Meal("Lasagna", "Lasagna", 5.99),
            new Meal("Tacchino", "TACCHINO", 4.99)
    );



    /*Exercise 1: Create a GetMapping that returns a list of meals

1 - Annotate a new class with the @RestController annotation.
2 - Create a new endpoint "/meals" using the @GetMapping annotation.
3 - In the method, return a list of Meal objects.*/
    @GetMapping ("/meal")
    public List<Meal> listaMeal(){
        List<Meal> meals = new ArrayList<>();
        return meals;
    };




    /* Exercise 2: Create a GetMapping that returns a meal by name

1 - Annotate a new class with the @RestController annotation.
2 - Create a new endpoint "/meal/{name}" using the @GetMapping annotation.
3 - In the method, add a query parameter "name" using the @PathVariable annotation.
4 - Return a Meal object with the corresponding name.*/
   @GetMapping ("/meal/{name}")
    public ResponseEntity<Meal> mealName(@PathVariable("nameMeal") int nameMeal){
           return ResponseEntity.ok(lista.get(nameMeal));
   }



    /* Exercise 3: Create a GetMapping that returns a meal by any word of description

1 - Annotate a new class with the @RestController annotation.
2 - Create a new endpoint "/meal/description-match/{phrase}" using the @GetMapping annotation.
3 - In the method, add a query parameter "description" using the @PathVariable annotation.
4 - Return a Meal object with the corresponding description.*/
   @GetMapping ("/meal/description-match/{phrase}")
   public ResponseEntity<Meal> mealDescription(@PathVariable("descriptionMeal") int descriptionMeal){
       return ResponseEntity.ok(lista.get(descriptionMeal));
   }



    /*Exercise 4: Create a GetMapping that returns a meal by price range

1 - Annotate a new class with the @RestController annotation.
2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation.
4 - Return a list of Meal objects with prices within the specified range.*/
    @GetMapping ("/meal/price")
    public ResponseEntity<?> mealPrices (
            @RequestParam("mealPrice") double mealPrice,
            @RequestParam("massimo") double max,
            @RequestParam ("minimo") double  min) {
        if (mealPrice < min || mealPrice > max) {
            return ResponseEntity.badRequest().body("Non ci sono prezzi compresi tra i valori inseriti");
        } else {
            return ResponseEntity.ok(listaConPrezziFiltrati.get(listaConPrezziFiltrati.indexOf(mealPrice)));
        }
    }


}
