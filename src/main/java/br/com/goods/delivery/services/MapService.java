package br.com.goods.delivery.services;

import br.com.goods.delivery.api.rs.to.MapTO;
import br.com.goods.delivery.api.rs.to.input.MapInputTO;
import br.com.goods.delivery.services.exception.NotFoundException;


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
	void saveMap(MapInputTO mapTO);

	/**
	 * @param name
	 * @return
	 * @throws NotFoundException 
	 */
	MapTO findByName(String name) throws NotFoundException;

	/**
	 * @param name
	 * @throws NotFoundException 
	 */
	void remove(String name) throws NotFoundException;

}
