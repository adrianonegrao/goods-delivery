package br.com.goods.delivery.services;

import java.util.Set;

import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.services.exception.NotFoundException;

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
	Set<CityTO> findByName(String name);

	/**
	 * @param id
	 * @return
	 * @throws NotFoundException 
	 */
	CityTO findById(Long id) throws NotFoundException;

	/**
	 * @param city
	 * @return
	 */
	City saveCity(City city);

	/**
	 * @param mapName
	 * @return
	 * @throws NotFoundException 
	 */
	Set<CityTO> findByMapName(String mapName) throws NotFoundException;

	/**
	 * @param city
	 * @return
	 */
	City updateCity(City city);

	/**
	 * @param mapName
	 * @param name
	 */
	void deleteByMapNameAndName(String mapName, String name);

	/**
	 * @param mapName
	 * @param name
	 * @return
	 * @throws NotFoundException
	 */
	CityTO findByMapNameAndName(String mapName, String name)
			throws NotFoundException;

}
