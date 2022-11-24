package com.justeat.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.justeat.entity.Cocktails;
import com.justeat.repository.CocktailsRepository;
import com.justeat.service.impl.CocktailsServiceImpl;

/**
 * The Class CocktailsServiceTest.
 */
public class CocktailsServiceTest {

	/** The cocktails repository. */
	@Mock
	private CocktailsRepository cocktailsRepository;

	/** The userservice. */
	@InjectMocks
	private CocktailsServiceImpl cocktailsService;

	/** The cocktails list. */
	List<Cocktails> cocktailsList = new ArrayList<>();

	/** The cocktail. */
	Cocktails cocktail = new Cocktails();

	/** The optional cocktail. */
	Optional<Cocktails> optionalCocktail = Optional.of(new Cocktails());

	/**
	 * Setup.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		cocktailsList.add(cocktail);
	}

	/**
	 * This method covers scenario to test cocktails list
	 */
	@Test
	public void testCocktailsList() {

		given(cocktailsRepository.findAll()).willReturn(cocktailsList);
		List<Cocktails> result = cocktailsService.getCocktails();
		assertTrue(result.size() > 0);

	}

	/**
	 * This method covers scenario to save cocktail list
	 */
	@Test
	public void testCocktailsListSave() {

		given(cocktailsRepository.saveAll(Mockito.anyIterable())).willReturn(cocktailsList);
		List<Cocktails> result = cocktailsService.saveAllCocktails(cocktailsList);
		assertTrue(result.size() > 0);

	}

	/**
	 * This method covers scenario to get cocktail details
	 */
	@Test
	public void testCocktail() {

		given(cocktailsRepository.findById(Mockito.anyLong())).willReturn(optionalCocktail);
		Cocktails result = cocktailsService.getCocktailDetails(1L);
		assertNotNull(result);

	}

	/**
	 * This method covers scenario to get invalid cocktail details
	 */
	@Test
	public void testCocktailWithoutResult() {

		given(cocktailsRepository.findById(Mockito.anyLong())).willReturn(Optional.empty());
		Cocktails result = cocktailsService.getCocktailDetails(1L);
		assertNull(result);

	}
}
