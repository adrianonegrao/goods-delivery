package br.com.goods.delivery.test.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.api.rs.to.RouteTO;
import br.com.goods.delivery.api.rs.to.input.MapInputTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.model.Route;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class TestMockHelper {
	public static final String MAP_NAME = "TEST_MAP";
	public static final String ORIGIN_NAME = "a";
	public static final String DESTINATION_NAME = "d";
	public static final Double PRICE = new Double(2.5);
	public static final Double AUTONOMY = new Double(10);
	
	private static Map<String, City> map = new HashMap<String, City>(); 
	private static List<City> cities = new ArrayList<City>();
	private static Set<City> setCities = new HashSet<City>();
	
	static{
		City cityA = new City("a", MAP_NAME);
		City cityB = new City("b", MAP_NAME);
		City cityC = new City("c", MAP_NAME);
		City cityD = new City("d", MAP_NAME);
		City cityE = new City("e", MAP_NAME);
		cityA.getRoutes().add(new Route(cityA, cityB, 10.0));
		cityA.getRoutes().add(new Route(cityA, cityC, 20.0));
		cityB.getRoutes().add(new Route(cityB, cityD, 15.0));
		cityB.getRoutes().add(new Route(cityB, cityE, 50.0));
		cityC.getRoutes().add(new Route(cityC, cityD, 30.0));
		cityD.getRoutes().add(new Route(cityD, cityE, 30.0));
		map.put("a", cityA);
		map.put("b", cityB);
		map.put("c", cityC);
		map.put("d", cityD);
		cities.add(cityA);
		cities.add(cityB);
		cities.add(cityC);
		cities.add(cityD);
		setCities.add(cityA);
		setCities.add(cityB);
		setCities.add(cityC);
		setCities.add(cityD);
	}

	public static List<City> getCities(){
		return cities;
	}

	public static Set<City> getSetCities(){
		return setCities;
	}
	
	public static Map<String, City> getMap(){
		return map;
	}
	
	public static City getCity(String cityName){
		return map.get(cityName);
	}

	public static MapInputTO createMapInputTO() {
		MapInputTO mapTO = new MapInputTO();
		mapTO.setMapName(MAP_NAME);
		Set<RouteTO> routesTO = new HashSet<RouteTO>();
		
		for (City city : cities) {
			Set<Route> routes = city.getRoutes();
			for (Route route : routes) {
				routesTO.add(new RouteTO(route.getOrigin().getName(), route.getDestination().getName(), route.getDistance()));
			}
		}
		mapTO.setRoutes(routesTO);
		
		return mapTO;
	}
	
	public static Set<CityTO> getSetCityTO() {
		Set<CityTO> citiesTO = new HashSet<CityTO>();
		for (City city : cities) {
			Set<RouteTO> routesTO = new HashSet<RouteTO>();
			for (Route route : city.getRoutes()) {
				routesTO.add(new RouteTO(route.getOrigin().getName(), route
						.getDestination().getName(), route.getDistance()));
			}
			citiesTO.add(new CityTO(city.getName(), routesTO, city.getId()));
		}
		return citiesTO;
	}
	
	public static CityTO getCityTO(String cityName) {
		City city = map.get(cityName);
		Set<RouteTO> routes = new HashSet<RouteTO>();
		for (Route route : city.getRoutes()) {
			routes.add(new RouteTO(route.getOrigin().getName(), route
					.getDestination().getName(), route.getDistance()));
		}
		return new CityTO(city.getName(), routes, city.getId());
	}
	
}
