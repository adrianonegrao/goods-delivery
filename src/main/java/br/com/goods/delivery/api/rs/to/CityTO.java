package br.com.goods.delivery.api.rs.to;

import java.util.HashSet;
import java.util.Set;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Transfer Object representing a map
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@ApiModel(value = "A city is a...")
public class CityTO implements TransferObject{
	private static final long serialVersionUID = 7936926986022175328L;
	
	private Long id;
	
	@ApiModelProperty(value = "City name", required=true)
	private String cityName;

	private Set<RouteTO> routes;
	
	/**
	 * @param cityName
	 * @param routes
	 */
	public CityTO(String cityName, Set<RouteTO> routes, Long id) {
		super();
		this.cityName = cityName;
		this.routes = routes;
		this.id = id;
	}

	/**
	 * 
	 */
	public CityTO() {
		super();
		this.routes = new HashSet<RouteTO>();
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CityTO [id=" + id + ", cityName=" + cityName + ", routes="
				+ routes.size() + "]";
	}

	
}