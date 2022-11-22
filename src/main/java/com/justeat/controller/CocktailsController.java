/**
 * 
 */
package com.justeat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justeat.entity.Cocktails;
import com.justeat.repository.CocktailsRepository;
import com.justeat.service.CocktailsService;

/**
 * @author Hemal Prajapati
 *
 */
@RestController
@RequestMapping("/api")
public class CocktailsController {

	@Autowired
	private CocktailsService cocktailsService;

	@GetMapping(value = "/cocktails-create")
	public List<Cocktails> createDummyData() {
		List<Cocktails> cocktails = new ArrayList<>();
		Cocktails c;
		for (int i = 0; i < 10; i++) {
			c = new Cocktails();
			c.setDescription("Cocktail " + i);
			c.setName("Cocktail Name " + i);
			c.setImage("Image" + i + ".jpeg");
			c.setIngredients("Cocktail Ingredients " + i);
			c.setCategory("Cocktail Category " + i);
			c.setGlass("Cocktail Glass " + i);
			c.setReviews(i+100);
			c.setRatings(i>5?(i-5):i);
			cocktails.add(c);
		}

		return cocktailsService.saveAllCocktails(cocktails);
	}

	@GetMapping(value = "/cocktails")
	public List<Cocktails> getCocktails() {
		return cocktailsService.getCocktails();
	}
}
