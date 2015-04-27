package br.com.goods.delivery.api.rs.to;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Transfer Object representing a route
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@ApiModel(value = "Route")
public class RouteTO implements TransferObject {
	private static final long serialVersionUID = 3284798662522558671L;

	@ApiModelProperty(value = "Origin", required=true)
	private String origin;
	
	@ApiModelProperty(value = "Destination", required=true)
    private String destination;
	
	@ApiModelProperty(value = "Distance", required=true)
    private Double distance;
    
	public RouteTO(String origin, String destination, Double distance) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}

	public RouteTO() {
		super();
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

}