/**
 * 
 */
package br.com.goods.delivery.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.services.DeliveryService;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class DeliveryServiceImpl implements DeliveryService{
	private static final Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);
	
	public Double lessExpensiveCostDelivery(String mapName, String originName,
			String destinationName, Double price, Double autonomy){
		return null;
	}

}