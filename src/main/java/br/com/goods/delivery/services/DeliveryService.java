package br.com.goods.delivery.services;

import br.com.goods.delivery.api.rs.to.output.DeliveryOutputTO;


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
	 */
	DeliveryOutputTO findLessExpensiveCostDelivery(String mapName, String originName,
			String destinationName, Double price, Double autonomy);

}
