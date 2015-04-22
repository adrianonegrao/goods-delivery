package br.com.goods.delivery.api.rs.to;

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
	
	@ApiModelProperty(value = "City name", required=true)
	private String cityName;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cityName == null) ? 0 : cityName.hashCode());
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
		CityTO other = (CityTO) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityTO [cityName=" + cityName + "]";
	}
	
}