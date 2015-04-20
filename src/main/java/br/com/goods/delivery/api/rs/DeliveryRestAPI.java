package br.com.goods.delivery.api.rs;

import javax.ws.rs.core.Response;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface DeliveryRestAPI {

	/**
	 * 
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	Response lessExpensiveCostDelivery(String from, String to);

}
