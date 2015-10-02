/**
 * 
 */
package br.com.goods.delivery.api.rs.to.output;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Transfer Object that represents a delivery with 
 * properties of the less expensive delivery cost and its route.
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@ApiModel(value = "Delivery object that contains the properties of the less expensive delivery cost and its route")
public class DeliveryTO extends OutputTO{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "The route cost", required=true)
	private Double cost;
	
	@ApiModelProperty(value = "The shortest route found", required=true)
	private String route;
	
	public DeliveryTO() {
		super();
	}

	public DeliveryTO(Double cost, String route) {
		super();
		this.cost = cost;
		this.route = route;
	}

	public DeliveryTO(Double cost, String route, String message) {
		super(message);
		this.cost = cost;
		this.route = route;
	}
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String rota) {
		this.route = rota;
	}
	
}
