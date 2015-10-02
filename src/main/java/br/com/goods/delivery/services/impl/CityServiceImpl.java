package br.com.goods.delivery.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.cxf.common.util.CollectionUtils;
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
 * Services with business rules about routes.
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {
	
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
		Set<City> cities = cityRepository.findByName(name);
		return cityHelper.fromCitySetToTOSet(cities);
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
	public void deleteByMapNameAndName(String mapName, String name) throws NotFoundException{
		City city = cityRepository.findByMapNameAndName(mapName, name);
		if(city == null){
			throw new NotFoundException("City does not found");
		}
		cityRepository.delete(city);
	}
}
