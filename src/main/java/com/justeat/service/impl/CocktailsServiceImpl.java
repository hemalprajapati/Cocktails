/**
 * 
 */
package com.justeat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justeat.entity.Cocktails;
import com.justeat.repository.CocktailsRepository;
import com.justeat.service.CocktailsService;

/**
 * @author Hemal.Prajapati
 *
 */
@Service
public class CocktailsServiceImpl implements CocktailsService{

	
	@Autowired
    private CocktailsRepository cocktailsRepository;

	@Override
	public List<Cocktails> getCocktails() {
		return (List<Cocktails>) cocktailsRepository.findAll();
	}

	@Override
	public List<Cocktails> saveAllCocktails(List<Cocktails> cocktails) {
		return (List<Cocktails>) cocktailsRepository.saveAll(cocktails);
	}
	
	
}
