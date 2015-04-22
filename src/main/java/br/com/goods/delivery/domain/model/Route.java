package br.com.goods.delivery.domain.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Entity representing a Route
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RelationshipEntity(type="distance")
public class Route extends AbstractEntity {

	@StartNode  @Fetch
	private City origin;
	
	@EndNode  @Fetch  
	private City destination;
	
	private Double distance;

	public Route() {
		super();
	}

	/**
	 * @param origin
	 * @param destination
	 * @param distance
	 */
	public Route(City origin, City destination, Double distance) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	/**
	 * @return the origin
	 */
	public City getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(City origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public City getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(City destination) {
		this.destination = destination;
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
		int result = super.hashCode();
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result
				+ ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Route [origin=" + origin + ", destination=" + destination
				+ ", distance=" + distance + "]";
	}

}
