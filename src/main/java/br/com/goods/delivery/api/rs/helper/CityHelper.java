package br.com.goods.delivery.api.rs.helper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.api.rs.to.RouteTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.model.Route;

/**
 * Utility class to helps transform city entitys into to.
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Component
public class CityHelper {

	/**
	 * Transform {@link City} into {@link CityTO}.
	 * 
	 * @param city
	 *            City
	 * @return TransferObject
	 */
	public CityTO fromCityToTO(City city) {

		Set<RouteTO> routes = new HashSet<RouteTO>();
		for (Route route : city.getRoutes()) {
			routes.add(new RouteTO(route.getOrigin().getName(), route
					.getDestination().getName(), route.getDistance()));
		}

		return new CityTO(city.getName(), routes, city.getId());
	}

	/**
	 * Transform {@link Set<City>} into {@link Set<CityTO>}.
	 * 
	 * @param city
	 *            City
	 * @return TransferObject
	 */
	public Set<CityTO> fromCitySetToTOSet(Set<City> cities) {
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
}
