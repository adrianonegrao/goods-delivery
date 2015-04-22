/**
 * 
 */
package br.com.goods.delivery.services.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.impl.CityRepository;
import br.com.goods.delivery.services.CityService;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CityServiceImpl implements CityService {
	private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public City saveCity(City city){
		return cityRepository.save(city);
	}
	
	@Override
	public City findByName(String name){
		return cityRepository.findByName(name);
	}
	
	@Override
	public Set<City> findByMapName(String mapName){
		return cityRepository.findByMapName(mapName);
	}

	@Override
	public City findById(Long id){
		return cityRepository.findById(id);
	}
}
