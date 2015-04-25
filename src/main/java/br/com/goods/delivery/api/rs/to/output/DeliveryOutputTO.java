/**
 * 
 */
package br.com.goods.delivery.api.rs.to.output;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class DeliveryOutputTO extends OutputTO{
	private static final long serialVersionUID = 1L;

	private Double cost;
	private String route;
	
	public DeliveryOutputTO() {
		super();
	}

	public DeliveryOutputTO(Double cost, String route) {
		super();
		this.cost = cost;
		this.route = route;
	}

	public DeliveryOutputTO(Double cost, String route, String message) {
		super(message);
		this.cost = cost;
		this.route = route;
	}
	
	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}
	/**
	 * @return the rota
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * @param rota the rota to set
	 */
	public void setRoute(String rota) {
		this.route = rota;
	}
	
}
