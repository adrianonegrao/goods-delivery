package br.com.goods.delivery.api.rs.to;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Transfer Object representing a route
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class RouteTO implements TransferObject {
	private static final long serialVersionUID = 3284798662522558671L;

	@ApiModelProperty(value = "Origin", required=true)
	private String origin;
	
	@ApiModelProperty(value = "Destination", required=true)
    private String destination;
	
	@ApiModelProperty(value = "Distance", required=true)
    private Double distance;
    
	/**
	 * @param origin
	 * @param destination
	 * @param distance
	 */
	public RouteTO(String origin, String destination, Double distance) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	/**
	 * 
	 */
	public RouteTO() {
		super();
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
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

}