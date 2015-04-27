/**
 * 
 */
package br.com.goods.delivery.domain.model;


/**
 * Interface that force all entity implementation 
 * create an id. 
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface Entity {

	public Long getId();

	public void setId(Long id);

}