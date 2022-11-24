/**
 * 
 */
package com.justeat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.justeat.entity.Cocktails;
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

	Map<String, List<Integer>> favoriteList = new HashMap<>();

	List<Cocktails> cocktails = new ArrayList<>();

	@GetMapping(value = "/cocktails")
	public List<Cocktails> getCocktails() {

		if (cocktails.isEmpty()) {
			createDummyData();
		}
		return cocktailsService.getCocktails();
	}
	
	@GetMapping(value = "/cocktails/{id}")
	public Cocktails getCocktailDetails(@PathVariable Long id) {
		return cocktailsService.getCocktailDetails(id);
	}

	private List<Cocktails> createDummyData() {

		Cocktails c;
		for (int i = 0; i < 10; i++) {
			c = new Cocktails();
			c.setDescription("Cocktail " + i);
			c.setName("Cocktail Name " + i);
			c.setImage("/assets/Image" + i + ".jpeg");
			c.setIngredients("Cocktail Ingredients " + i);
			c.setCategory("Cocktail Category " + i);
			c.setGlass("Cocktail Glass " + i);
			c.setReviews(i + 100);
			c.setRatings(i > 5 ? (i - 5) : i);
			cocktails.add(c);
		}

		return cocktailsService.saveAllCocktails(cocktails);
	}
}
