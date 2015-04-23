package br.com.goods.delivery.api.rs;

import javax.ws.rs.core.Response;

import br.com.goods.delivery.api.rs.to.input.DeliveryInputTO;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface DeliveryRestAPI {

	/**
	 * @param mapName
	 * @param sourceName
	 * @param destinationName
	 * @param price
	 * @param autonomy
	 * @return
	 */
	Response lessExpensiveCostDelivery(DeliveryInputTO deliveryTO);

}
