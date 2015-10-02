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
@ApiModel(value = "City")
public class CityTO implements TransferObject{
	private static final long serialVersionUID = 7936926986022175328L;
	
	@ApiModelProperty(value = "City id", required=true)
	private Long id;
	
	@ApiModelProperty(value = "City name", required=true)
	private String cityName;

	@ApiModelProperty(value = "City routes", required=true)
	private Set<RouteTO> routes;
	
	public CityTO(String cityName, Set<RouteTO> routes, Long id) {
		super();
		this.cityName = cityName;
		this.routes = routes;
		this.id = id;
	}

	public CityTO() {
		super();
		this.routes = new HashSet<RouteTO>();
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set<RouteTO> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<RouteTO> routes) {
		this.routes = routes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CityTO [id=" + id + ", cityName=" + cityName + ", routes="
				+ routes.size() + "]";
	}

	
}