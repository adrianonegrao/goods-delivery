package br.com.goods.delivery.services;

import br.com.goods.delivery.domain.model.Route;


/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface RouteService {

	/**
	 * @param origin
	 * @param destinatio
	 * @param distance
	 * @return
	 */
	Route saveRoute(Route route);
	
}
