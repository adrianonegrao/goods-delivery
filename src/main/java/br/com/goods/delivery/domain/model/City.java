package br.com.goods.delivery.domain.model;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;

/**
 * Entity representing a city
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class City {
	
	@Indexed
	private String name;
	
	@Fetch @RelatedToVia(type = "DISTANCE",direction=Direction.BOTH)
    private Set<Route> routesToOtherCities;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the routesToOtherCities
	 */
	public Set<Route> getRoutesToOtherCities() {
		return routesToOtherCities;
	}

	/**
	 * @param routesToOtherCities the routesToOtherCities to set
	 */
	public void setRoutesToOtherCities(Set<Route> routesToOtherCities) {
		this.routesToOtherCities = routesToOtherCities;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((routesToOtherCities == null) ? 0 : routesToOtherCities
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		City other = (City) obj;
		if (routesToOtherCities == null) {
			if (other.routesToOtherCities != null)
				return false;
		} else if (!routesToOtherCities.equals(other.routesToOtherCities))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "City [name=" + name + ", citiesThatHavePaths="
				+ routesToOtherCities + "]";
	}
	
}
