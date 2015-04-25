/**
 * 
 */
package br.com.goods.delivery.test.services;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.domain.repository.CityRepository;
import br.com.goods.delivery.services.exception.NotFoundException;
import br.com.goods.delivery.services.impl.CityServiceImpl;
import br.com.goods.delivery.test.mock.helper.TestMockHelper;


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
	
	@Test(expected=NotFoundException.class)
	public void testNotFoundExceptionFindByMapNameAndName() throws NotFoundException{
		when(cityRepository.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(null);
		cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME);
	}

	@Test
	public void testFindByMapNameAndName() throws NotFoundException{
		when(cityRepository.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(TestMockHelper.getCity(TestMockHelper.ORIGIN_NAME));
		when(cityHelper.fromCityToTO(TestMockHelper.getCity(TestMockHelper.ORIGIN_NAME))).thenReturn(TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME));
		CityTO city = cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME);
		Assert.assertEquals(city.toString(), TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME).toString());
	}
	
}