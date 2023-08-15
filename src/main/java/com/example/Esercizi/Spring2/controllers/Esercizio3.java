package com.example.Esercizi.Spring2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

public class Esercizio3 {
    private List<Meal> lista = new ArrayList<>();

    @PutMapping(value = "/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        this.lista.add(meal);
        return ResponseEntity.ok("Meal added");
    }



    /*Exercise 2: Create a PostMapping to update a meal by name

1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
3 - Update the meal with the corresponding name using the information from the RequestBody*/
    @PutMapping(value = "/meal/{name}")
    public ResponseEntity<String> putNameMeal (@PathVariable String mealName, @RequestBody Meal meal) {
        meal.setNameMeal(mealName);
        this.lista.add(meal);
        return  ResponseEntity.ok("Meal added");
    }

            /*Exercise 3: Create a DeleteMapping to delete a meal by name
            1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
            2 - In the method, add a PathVariable for the name.
            3 - Delete the meal with the corresponding name.
             */

    @DeleteMapping (value = "/meal/{name}")
    public ResponseEntity <String> deleteMeal(@PathVariable String mealName){
        this.lista.removeIf(meal -> meal.getNameMeal().equals(mealName));
        return ResponseEntity.ok("Meal deleted");
    }


           /* Exercise 4: Create a DeleteMapping to delete all meals above a certain price

1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
2 - In the method, add a PathVariable for the price.
3 - Delete all meals with a price above the price from the PathVariable.*/

    @DeleteMapping (value = "/meal/{name}")
    public ResponseEntity <String> deleteMealPrice (@PathVariable double price){
        this.lista.removeIf(priceMeal -> priceMeal.getPrice() >= price);
        return ResponseEntity.ok("Meal deleted");
    }


    /*Exercise 5: Create a PutMapping to update the price of a meal by name

1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
 2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
 3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
*/

    @PostMapping (value = "/meal/{name}/price")
    public ResponseEntity <String> postMeal (@PathVariable String mealName,@PathVariable String description, @RequestBody double price){
        this.lista.removeIf(meal -> meal.getNameMeal().equals(mealName));
        Meal meal = new Meal(mealName, description, price);
        this.lista.add(meal);
        return  ResponseEntity.ok("Meal Updeted!");
    }
}
