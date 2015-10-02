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

	public static final String SUCCESS_MESSAGE = "Success";
	public static final String ERROR_MESSAGE = "Internal Server Error";
	
	private String message;
	private TransferObject returnedObject;

	public OutputTO(){
		super();
	}
	
	public OutputTO(String message){
		this.message = message;
	}

	public OutputTO(String message, TransferObject returnedObject){
		this.message = message;
		this.returnedObject = returnedObject;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TransferObject getReturnedObject() {
		return returnedObject;
	}

	public void setReturnedObject(TransferObject returnedObject) {
		this.returnedObject = returnedObject;
	}
	
}