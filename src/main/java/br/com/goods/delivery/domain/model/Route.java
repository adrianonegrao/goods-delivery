package br.com.goods.delivery.domain.model;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 * Entity representing a Route
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RelationshipEntity(type=Route.DISTANCE_RELATIONSHIP_TYPE)
public class Route implements Entity {
	public static final String DISTANCE_RELATIONSHIP_TYPE = "distance";
	
	@GraphId
	private Long id;
	
	@StartNode  @Fetch
	private City origin;
	
	@EndNode  @Fetch  
	private City destination;
	
	private Double distance;

	public Route() {
		super();
	}

	public Route(City origin, City destination, Double distance) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	public City getOrigin() {
		return origin;
	}

	public void setOrigin(City origin) {
		this.origin = origin;
	}

	public City getDestination() {
		return destination;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Route [origin=" + origin + ", destination=" + destination
				+ ", distance=" + distance + "]";
	}


}
