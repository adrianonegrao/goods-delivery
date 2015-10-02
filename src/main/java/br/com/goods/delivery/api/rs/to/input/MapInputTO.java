package br.com.goods.delivery.api.rs.to.input;

import java.util.Set;

import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.api.rs.to.RouteTO;
import br.com.goods.delivery.api.rs.to.TransferObject;

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
public class MapInputTO implements TransferObject{
	private static final long serialVersionUID = 7936926986022175328L;
	
	@ApiModelProperty(value = "Map name", required=true)
	private String mapName;
	
	@ApiModelProperty(value = "Routes", required=true)
	private Set<RouteTO> routes;

	public MapInputTO() {
		super();
	}

	public MapInputTO(String mapName, Set<RouteTO> routes, Set<CityTO> cities) {
		super();
		this.mapName = mapName;
		this.routes = routes;
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
	
}