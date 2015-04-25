package br.com.goods.delivery.services;

import br.com.goods.delivery.api.rs.to.output.DeliveryOutputTO;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;


/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface DeliveryService {

	/**
	 * @param mapName
	 * @param originName
	 * @param destinationName
	 * @param price
	 * @param autonomy
	 * @return
	 * @throws NotFoundException 
	 * @throws FieldNotNullException 
	 */
	DeliveryOutputTO findLessExpensiveCostDelivery(String mapName, String originName,
			String destinationName, Double price, Double autonomy) throws NotFoundException, FieldNotNullException;

}
