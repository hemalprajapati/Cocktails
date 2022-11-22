package com.justeat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justeat.entity.Cocktails;


@Repository
public interface CocktailsRepository  extends  CrudRepository<Cocktails, Long>{

}
