/**
 * 
 */
package br.com.goods.delivery.services.exception;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public class NotFoundException extends ServiceException{
	private static final long serialVersionUID = 7831558176362444446L;

	/**
	 * @param message
	 */
	public NotFoundException(String message) {
		super(message);
	}

}
