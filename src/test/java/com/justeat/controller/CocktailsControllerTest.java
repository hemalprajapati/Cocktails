/**
 * 
 */
package com.justeat.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.justeat.entity.Cocktails;
import com.justeat.service.CocktailsService;

/**
 * @author Hemal.Prajapati
 *
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
@EnableSpringDataWebSupport
@SpringBootTest(classes={ CocktailsController.class }) 
public class CocktailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CocktailsService cocktailsService;

	@org.junit.Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@org.junit.Test
	public void testCocktails() throws Exception {

		mockMvc.perform(get("/api/cocktails").contentType(MediaType.APPLICATION_JSON));
	}
	
	@org.junit.Test
	public void testCocktail() throws Exception {
		given(cocktailsService.getCocktailDetails(Mockito.anyLong())).willReturn(new Cocktails());
		mockMvc.perform(get("/api/cocktails/1").contentType(MediaType.APPLICATION_JSON));
	}


}
