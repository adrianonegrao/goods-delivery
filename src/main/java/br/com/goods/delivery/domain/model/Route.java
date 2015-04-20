package br.com.goods.delivery.domain.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Entity representing a Route
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@NodeEntity
public class Route {

	@StartNode  @Fetch
	private City from;
	
	@EndNode  @Fetch  
	private City to;
	
	private Double distance;

	/**
	 * @return the from
	 */
	public City getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(City from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public City getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(City to) {
		this.to = to;
	}

	/**
	 * @return the distance
	 */
	public Double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		Route other = (Route) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Route [from=" + from + ", to=" + to + ", distance=" + distance
				+ "]";
	}
	
}
