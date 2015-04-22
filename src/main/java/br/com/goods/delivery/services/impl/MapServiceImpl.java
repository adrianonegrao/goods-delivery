/**
 * 
 */
package br.com.goods.delivery.services.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.api.rs.to.MapTO;
import br.com.goods.delivery.api.rs.to.RouteTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.model.Route;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.MapService;
import br.com.goods.delivery.services.RouteService;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MapServiceImpl implements MapService {
	private static final Logger logger = LoggerFactory.getLogger(MapServiceImpl.class);
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private RouteService routeService;
	
	@Override
	public Set<Route> saveMap(MapTO mapTO){

		for (RouteTO routeTO : mapTO.getRoutes()) {
			City origin = cityService.saveCity(new City(routeTO.getOrigin(), mapTO.getMapName()));
			City destination = cityService.saveCity(new City(routeTO.getDestination(), mapTO.getMapName()));
			Route route = routeService.saveRoute(new Route(origin, destination, routeTO.getDistance()));
			origin.getRoutes().add(route);
			cityService.saveCity(origin);
		}
		
		return null;
	}

	@Override
	public Set<City> findByName(String name){
		return cityService.findByMapName(name);
	}

}