package br.com.goods.delivery.test.services;

import static br.com.goods.delivery.test.helper.TestMockHelper.MAP_NAME;
import static br.com.goods.delivery.test.helper.TestMockHelper.ORIGIN_NAME;
import static br.com.goods.delivery.test.helper.TestMockHelper.getCity;
import static br.com.goods.delivery.test.helper.TestMockHelper.getCityTO;
import static br.com.goods.delivery.test.helper.TestMockHelper.getSetCities;
import static br.com.goods.delivery.test.helper.TestMockHelper.getSetCityTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.CityRepository;
import br.com.goods.delivery.services.exception.NotFoundException;
import br.com.goods.delivery.services.impl.CityServiceImpl;


/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

	@InjectMocks
	private CityServiceImpl cityService;
		
	@Mock
	private CityHelper cityHelper;
	
	@Mock
	private CityRepository cityRepository;

	@Test
	public void testFindById() throws NotFoundException{
		City city = getCity(ORIGIN_NAME);
		when(cityRepository.findById(anyLong())).thenReturn(city);
		when(cityHelper.fromCityToTO(city)).thenReturn(getCityTO(ORIGIN_NAME));
		CityTO findById = cityService.findById(1l);
		assertNotNull(findById);
	}

	@Test(expected=NotFoundException.class)
	public void testFindByIdNull() throws NotFoundException{
		when(cityRepository.findById(anyLong())).thenReturn(null);
		cityService.findById(1l);
	}
	
	@Test
	public void testFindByName(){
		when(cityHelper.fromCitySetToTOSet(getSetCities())).thenReturn(getSetCityTO());
		Set<CityTO> cityTO = cityService.findByName(anyString());
		assertNotNull(cityTO);
	}

	@Test
	public void testFindByNameSetNull(){
		when(cityHelper.fromCitySetToTOSet(getSetCities())).thenReturn(getSetCityTO());
		Set<CityTO> findByName = cityService.findByName(anyString());
		assertNotNull(findByName);
	}
	
	@Test(expected=NotFoundException.class)
	public void testFindByMapNameNull() throws NotFoundException{
		when(cityRepository.findByMapName(anyString())).thenReturn(null);
		cityService.findByMapName(MAP_NAME);
	}

	@Test
	public void testFindByMapName() throws NotFoundException{
		when(cityRepository.findByMapName(anyString())).thenReturn(getSetCities());
		Set<CityTO> findByMapName = cityService.findByMapName(MAP_NAME);
		assertNotNull(findByMapName);
	}
	
	@Test(expected=NotFoundException.class)
	public void testNotFoundExceptionFindByMapNameAndName() throws NotFoundException{
		when(cityRepository.findByMapNameAndName(MAP_NAME, ORIGIN_NAME)).thenReturn(null);
		cityService.findByMapNameAndName(MAP_NAME, ORIGIN_NAME);
	}

	@Test
	public void testFindByMapNameAndName() throws NotFoundException{
		when(cityRepository.findByMapNameAndName(MAP_NAME, ORIGIN_NAME)).thenReturn(getCity(ORIGIN_NAME));
		when(cityHelper.fromCityToTO(getCity(ORIGIN_NAME))).thenReturn(getCityTO(ORIGIN_NAME));
		CityTO city = cityService.findByMapNameAndName(MAP_NAME, ORIGIN_NAME);
		assertEquals(city.toString(), getCityTO(ORIGIN_NAME).toString());
	}
	
	@Test(expected=NotFoundException.class)
	public void testDeleteByMapNameAndNameNull() throws NotFoundException{
		when(cityRepository.findByMapNameAndName(anyString(), anyString())).thenReturn(null);
		cityService.deleteByMapNameAndName(MAP_NAME,  ORIGIN_NAME);
	}

	@Test
	public void testDeleteByMapNameAndName() throws NotFoundException{
		when(cityRepository.findByMapNameAndName(anyString(), anyString())).thenReturn(getCity(ORIGIN_NAME));
		cityService.deleteByMapNameAndName(MAP_NAME,  ORIGIN_NAME);
		Mockito.verify(cityRepository, atLeastOnce()).delete(getCity(ORIGIN_NAME));
	}

	@Test
	public void testSaveCity(){
		when(cityRepository.findByMapNameAndName(MAP_NAME, ORIGIN_NAME)).thenReturn(getCity(ORIGIN_NAME));
		cityService.saveCity(getCity(ORIGIN_NAME));
		Mockito.verify(cityRepository, never()).save(getCity(ORIGIN_NAME));
	}
	
	@Test
	public void testSaveCityNull(){
		when(cityRepository.findByMapNameAndName(anyString(), anyString())).thenReturn(null);
		cityService.saveCity(getCity(ORIGIN_NAME));
		Mockito.verify(cityRepository, atLeastOnce()).save(getCity(ORIGIN_NAME));
	}
	
}