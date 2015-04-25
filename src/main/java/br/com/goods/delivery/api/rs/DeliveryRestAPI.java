package br.com.goods.delivery.api.rs;

import javax.ws.rs.core.Response;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface DeliveryRestAPI {

//	Response lessExpensiveCostDelivery(DeliveryInputTO deliveryTO);
	
	/**
	 * @param mapName
	 * @param sourceName
	 * @param destinationName
	 * @param price
	 * @param autonomy
	 * @return
	 */
	Response lessExpensiveCostDelivery(String mapName, String originName,
			String destinationName, Double price, Double autonomy);

}
