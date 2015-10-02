package br.com.goods.delivery.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.api.rs.to.MapTO;
import br.com.goods.delivery.api.rs.to.RouteTO;
import br.com.goods.delivery.api.rs.to.input.MapInputTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.model.Route;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.MapService;
import br.com.goods.delivery.services.RouteService;
import br.com.goods.delivery.services.exception.NotFoundException;

/**
 * Services that provides business rules about maps. 
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional
public class MapServiceImpl implements MapService {
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private CityHelper cityHelper;
	
	@Override
	public void saveMap(MapInputTO mapTO){
		for (RouteTO routeTO : mapTO.getRoutes()) {
			City origin = cityService.saveCity(new City(routeTO.getOrigin(), mapTO.getMapName()));
			City destination = cityService.saveCity(new City(routeTO.getDestination(), mapTO.getMapName()));
			Route route = routeService.saveRoute(new Route(origin, destination, routeTO.getDistance()));
			origin.getRoutes().add(route);
			cityService.updateCity(origin);
		}
	}

	@Override
	public MapTO findByName(String name) throws NotFoundException{
		Set<CityTO> citiesTO = cityService.findByMapName(name);
		Set<RouteTO> routesTO = new HashSet<RouteTO>(); 

		for(CityTO city : citiesTO ){
			routesTO.addAll(city.getRoutes());
		}
		
		return new MapTO(name, routesTO, citiesTO);
	}
	
	@Override
	public void remove(String name) throws NotFoundException{
		Set<CityTO> citiesTO = cityService.findByMapName(name);
		for(CityTO city : citiesTO ){
			cityService.deleteByMapNameAndName(name, city.getCityName());
		}
	}

}