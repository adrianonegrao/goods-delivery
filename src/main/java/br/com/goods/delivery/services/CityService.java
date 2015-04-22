package br.com.goods.delivery.services;

import java.util.Set;

import br.com.goods.delivery.domain.model.City;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface CityService {

	/**
	 * @param name
	 * @return
	 */
	City findByName(String name);

	/**
	 * @param id
	 * @return
	 */
	City findById(Long id);

	/**
	 * @param city
	 * @return
	 */
	City saveCity(City city);

	/**
	 * @param mapName
	 * @return
	 */
	Set<City> findByMapName(String mapName);

}
