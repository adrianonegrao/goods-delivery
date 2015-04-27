package br.com.goods.delivery.api.rs;

import javax.ws.rs.core.Response;

/**
 * Rest API contract that receive a mapName, origin, destination, price and autonomy 
 * and provides the less expensive delivery cost and its route.
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface DeliveryRestAPI {

	/**
	 * Operation method that receive a mapName, origin, destination, price and autonomy
	 * and returns the less expensive delivery cost and its route.
	 * 
	 * @param mapName
	 * @param originName
	 * @param destinationName
	 * @param price
	 * @param autonomy
	 * @return {@link Response} less expensive delivery cost and its route.
	 */
	Response lessExpensiveCostDelivery(String mapName, String originName,
			String destinationName, Double price, Double autonomy);

}
