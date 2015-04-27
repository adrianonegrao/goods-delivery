/**
 * 
 */
package br.com.goods.delivery.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.domain.model.Route;
import br.com.goods.delivery.domain.repository.RouteRepository;
import br.com.goods.delivery.services.RouteService;

/**
 * Services with business rules about routes.
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional
public class RouteServiceImpl implements RouteService {
	private static final Logger logger = LoggerFactory.getLogger(RouteServiceImpl.class);
	
	@Autowired
	private RouteRepository routeRepository;

	@Override
	public Route saveRoute(Route route){
		return routeRepository.save(route);
	}
	
}
