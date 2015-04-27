package br.com.goods.delivery.api.rs;

import javax.ws.rs.core.Response;

import br.com.goods.delivery.api.rs.to.MapTO;

/**
 * Rest API contract that contains the map operation like get, delete or update a map and cities. 
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface MapRestAPI {

	/**
	 * Operation method that creates or update a Map.
	 * 
	 * @param input
	 * @return @link {@link Response}
	 */
	Response createOrUpdateMap(MapTO input);

	/**
	 * Operation method that delete a map.
	 * 
	 * @param id
	 * @return @link {@link Response}
	 */
	Response deleteMap(String mapName);

	/**
	 * Operation method that creates or update a Map.
	 * 
	 * @param input
	 * @return @link {@link Response}
	 */
	Response createMap(MapTO input);

	/**
	 * Operation method that find all map's routes.
	 * 
	 * @param mapName
	 * @return @link {@link Response}
	 */
	Response findRoutesByMapName(String mapName);

	/**
	 * Operation method that find a city in all registered maps 
	 * 
	 * @param mapName
	 * @return @link {@link Response}
	 */
	Response findCityByName(String mapName);

	/**
	 * Operation method that find a city by its id.
	 * 
	 * @param cityId
	 * @return @link {@link Response}
	 */
	Response findCityById(Long cityId);

}
