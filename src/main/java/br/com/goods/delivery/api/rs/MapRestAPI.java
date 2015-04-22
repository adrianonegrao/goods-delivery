package br.com.goods.delivery.api.rs;

import javax.ws.rs.core.Response;

import br.com.goods.delivery.api.rs.to.MapTO;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface MapRestAPI {

	/**
	 * @param input
	 * @return
	 */
	Response createOrUpdateMap(MapTO input);

	/**
	 * @param id
	 * @return
	 */
	Response deleteMap(String mapName);

	/**
	 * @param input
	 * @return
	 */
	Response createMap(MapTO input);

}
