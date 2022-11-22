/**
 * 
 */
package com.justeat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.justeat.entity.Cocktails;


/**
 * @author Hemal.Prajapati
 *
 */

public interface CocktailsService {
	
	public List<Cocktails> getCocktails();
	
	public List<Cocktails> saveAllCocktails(List<Cocktails> cocktails);

}
