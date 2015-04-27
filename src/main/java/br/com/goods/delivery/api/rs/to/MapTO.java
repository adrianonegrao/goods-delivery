package br.com.goods.delivery.api.rs.to;

import java.util.Set;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Transfer Object representing a map
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@ApiModel(value = "Map")
public class MapTO implements TransferObject{
	private static final long serialVersionUID = 7936926986022175328L;
	
	@ApiModelProperty(value = "Map name", required=true)
	private String mapName;
	
	@ApiModelProperty(value = "Routes", required=true)
	private Set<RouteTO> routes;
	
	@ApiModelProperty(value = "Cities", required=true)
	private Set<CityTO> cities;

	public MapTO() {
		super();
	}

	public MapTO(String mapName, Set<RouteTO> routes, Set<CityTO> cities) {
		super();
		this.mapName = mapName;
		this.routes = routes;
		this.cities = cities;
	}

	public String getMapName() {
		return mapName;
	}
	
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	
	public Set<RouteTO> getRoutes() {
		return routes;
	}
	
	public void setRoutes(Set<RouteTO> routes) {
		this.routes = routes;
	}
	
	public Set<CityTO> getCities() {
		return cities;
	}

	public void setCities(Set<CityTO> cities) {
		this.cities = cities;
	}
	
}