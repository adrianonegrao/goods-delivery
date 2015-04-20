package br.com.goods.delivery.domain.repository.impl;

import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.goods.delivery.domain.model.City;

/**
 * @City entity repository
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface CityRepository extends GraphRepository<City> {
	
	public City findByName(String name);
}