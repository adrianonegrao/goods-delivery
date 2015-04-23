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

	public DeliveryOutputTO(Double cost, String route, String mensage) {
		super();
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
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
		DeliveryOutputTO other = (DeliveryOutputTO) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeliveryOutPutTO [cost=" + cost + ", rota=" + route + "]";
	}
	
}
