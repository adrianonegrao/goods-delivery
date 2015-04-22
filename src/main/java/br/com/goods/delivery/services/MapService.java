package br.com.goods.delivery.services;

import java.util.Set;

import br.com.goods.delivery.api.rs.to.MapTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.model.Route;


/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface MapService {

	/**
	 * @param mapTO
	 * @return
	 */
	Set<Route> saveMap(MapTO mapTO);

	/**
	 * @param name
	 * @return
	 */
	Set<City> findByName(String name);

}
