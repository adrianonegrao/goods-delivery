package br.com.goods.delivery.api.rs.to.output;

import br.com.goods.delivery.api.rs.to.TransferObject;


/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class OutputTO implements TransferObject{
	private static final long serialVersionUID = -1903401124993573668L;

	public static final String SUCCESS_MSG = "Success";
	public static final String ERROR_MSG = "Internal Server Error";
	
	private String message;
	
	public OutputTO(){
		super();
	}
	
	public OutputTO(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}