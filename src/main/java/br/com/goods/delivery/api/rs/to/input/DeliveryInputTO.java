/**
 * 
 */
package br.com.goods.delivery.api.rs.to.input;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.goods.delivery.api.rs.to.TransferObject;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@ApiModel(value = "XXXXXXXXXXXXXXXXXXXXXXXX")
@XmlRootElement(name = "Delivery")
public class DeliveryInputTO implements TransferObject{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "XXXXXXXXXXXXXXXXXXXXXXXX", required=true)
	private String mapName;
	private String originName;
	private String destinationName;
	@ApiModelProperty(value = "XXXXXXXXXXXXXXXXXXXXXXXX", required=true, dataType="Double (ex: 2.5)")
	private Double price;
	@ApiModelProperty(value = "XXXXXXXXXXXXXXXXXXXXXXXX", required=true, dataType="Double (ex: 2.5)")
	private Double autonomy;
	
	public DeliveryInputTO() {
		super();
	}

	/**
	 * @param mapName
	 * @param originName
	 * @param destinationName
	 * @param cost
	 * @param route
	 */
	public DeliveryInputTO(String mapName, String originName,
			String destinationName, Double price, Double autonomy) {
		super();
		this.mapName = mapName;
		this.originName = originName;
		this.destinationName = destinationName;
		this.price = price;
		this.autonomy = autonomy;
	}

	/**
	 * @return the mapName
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * @param mapName the mapName to set
	 */
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	/**
	 * @return the destinationName
	 */
	public String getDestinationName() {
		return destinationName;
	}

	/**
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the autonomy
	 */
	public Double getAutonomy() {
		return autonomy;
	}

	/**
	 * @param autonomy the autonomy to set
	 */
	public void setAutonomy(Double autonomy) {
		this.autonomy = autonomy;
	}

	/**
	 * @return the originName
	 */
	public String getOriginName() {
		return originName;
	}

	/**
	 * @param originName the originName to set
	 */
	public void setOriginName(String originName) {
		this.originName = originName;
	}

}
