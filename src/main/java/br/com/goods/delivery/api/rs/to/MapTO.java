package br.com.goods.delivery.api.rs.to;

import java.util.List;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class MapTO {

	private String mapName;
	private List<Route> routes;

	public String getMapName() {
		return mapName;
	}
	
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	
	public List<Route> getRoutes() {
		return routes;
	}
	
	public void setRoutes(List<Route> routes) {
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
		MapTO other = (MapTO) obj;
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