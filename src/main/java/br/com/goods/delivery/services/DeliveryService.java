package br.com.goods.delivery.services;

import br.com.goods.delivery.api.rs.to.output.DeliveryTO;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;


/**
 * Services that provides the core business rules about delivery, cost and routes. 
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface DeliveryService {

	/**
	 * Method that provides the less expensive cost of a delivery and its path, 
	 * based on inputs parameters using the Dijkstra algorithm.
	 * 
	 * @param mapName
	 * @param originName
	 * @param destinationName
	 * @param price
	 * @param autonomy
	 * @return
	 * @throws NotFoundException 
	 * @throws FieldNotNullException 
	 */
	DeliveryTO findLessExpensiveCostDelivery(String mapName, String originName,
			String destinationName, Double price, Double autonomy) throws NotFoundException, FieldNotNullException;

}
