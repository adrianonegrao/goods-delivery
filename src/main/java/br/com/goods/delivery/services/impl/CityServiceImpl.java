/**
 * 
 */
package br.com.goods.delivery.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.cxf.common.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.CityRepository;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.exception.NotFoundException;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {
	private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CityHelper cityHelper;
	
	@Override
	public City saveCity(City city){
		
		City existingCity = cityRepository.findByMapNameAndName(city.getMapName(), city.getName());
		if (existingCity!=null){
			return existingCity;
		}
		return cityRepository.save(city);
	}

	@Override
	public City updateCity(City city){
		return cityRepository.save(city);
	}
	
	@Override
	public Set<CityTO> findByName(String name){
		return cityHelper.fromCitySetToTOSet(cityRepository.findByName(name));
	}
	
	@Override
	public CityTO findByMapNameAndName(String mapName, String name) throws NotFoundException{
		City city = cityRepository.findByMapNameAndName(mapName, name);
		if(city==null){
			throw new NotFoundException("City does not found");
		}
		return cityHelper.fromCityToTO(city);
	}
	
	@Override
	public Set<CityTO> findByMapName(String mapName) throws NotFoundException{
		Set<City> cities = cityRepository.findByMapName(mapName);
		if(CollectionUtils.isEmpty(cities)){
			throw new NotFoundException("Map does not found");
		}
		
		Set<CityTO> citiesTO = new HashSet<CityTO>(); 

		for(City city : cities ){
			citiesTO.add(cityHelper.fromCityToTO(city));
		}
		
		return citiesTO;
	}

	@Override
	public CityTO findById(Long id) throws NotFoundException{
		City city = cityRepository.findById(id);
		if(city == null){
			throw new NotFoundException("City does not found");
		}
		return cityHelper.fromCityToTO(city);
	}
	
	@Override
	public void deleteByMapNameAndName(String mapName, String name){
		City city = cityRepository.findByMapNameAndName(mapName, name);
		cityRepository.delete(city);
	}
}
