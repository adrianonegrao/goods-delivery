package br.com.goods.delivery.test.services;


import static br.com.goods.delivery.test.helper.TestMockHelper.MAP_NAME;
import static br.com.goods.delivery.test.helper.TestMockHelper.getSetCityTO;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.MapTO;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.exception.NotFoundException;
import br.com.goods.delivery.services.impl.MapServiceImpl;


/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MapServiceTest {

	@InjectMocks
	private MapServiceImpl mapService;
		
	@Mock
	private CityHelper cityHelper;
	
	@Mock
	private CityService cityService ;

	@Test(expected=NotFoundException.class)
	public void testFindByNameNull() throws NotFoundException{
		when(cityService.findByMapName(anyString())).thenThrow(new NotFoundException(""));
		mapService.findByName(MAP_NAME);
	}
	
	@Test
	public void testFindByName() throws NotFoundException{
		when(cityService.findByMapName(anyString())).thenReturn(getSetCityTO());
		MapTO map = mapService.findByName(MAP_NAME);
		assertNotNull(map);
	}
}