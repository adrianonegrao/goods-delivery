package br.com.goods.delivery.domain.model;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import br.com.goods.delivery.api.rs.to.RouteTO;

/**
 * Entity representing a Map
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@NodeEntity
public class Map {
	
	private String name;
	
	@Fetch @RelatedToVia(type = "DISTANCE",direction=Direction.BOTH)
	private Set<RouteTO> routes;

	public Map() {
		super();
	}

	/**
	 * @return the mapName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param mapName the mapName to set
	 */
	public void setName(String mapName) {
		this.name = mapName;
	}

	/**
	 * @return the routes
	 */
	public Set<RouteTO> getRoutes() {
		return routes;
	}

	/**
	 * @param routes the routes to set
	 */
	public void setRoutes(Set<RouteTO> routes) {
		this.routes = routes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((routes == null) ? 0 : routes.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Map other = (Map) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (routes == null) {
			if (other.routes != null)
				return false;
		} else if (!routes.equals(other.routes))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Map [mapName=" + name + ", routes="
				+ routes + "]";
	}
	
}
