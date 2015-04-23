package br.com.goods.delivery.api.rs.to.input;

import java.util.Set;

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
@ApiModel(value = "A map is a...")
public class MapInputTO implements TransferObject{
	private static final long serialVersionUID = 7936926986022175328L;
	
	@ApiModelProperty(value = "Map name", required=true)
	private String mapName;
	
	@ApiModelProperty(value = "Rotas", required=true)
	private Set<RouteInputTO> routes;

	public String getMapName() {
		return mapName;
	}
	
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	
	public Set<RouteInputTO> getRoutes() {
		return routes;
	}
	
	public void setRoutes(Set<RouteInputTO> routes) {
		this.routes = routes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapName == null) ? 0 : mapName.hashCode());
		result = prime * result + ((routes == null) ? 0 : routes.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapInputTO other = (MapInputTO) obj;
		if (mapName == null) {
			if (other.mapName != null)
				return false;
		} else if (!mapName.equals(other.mapName))
			return false;
		if (routes == null) {
			if (other.routes != null)
				return false;
		} else if (!routes.equals(other.routes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MapTO [mapName=" + mapName + ", routes=" + routes + "]";
	}
	
}