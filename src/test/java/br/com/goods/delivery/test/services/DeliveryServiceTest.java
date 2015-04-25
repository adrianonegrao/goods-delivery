/**
 * 
 */
package br.com.goods.delivery.test.services;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.neo4j.graphdb.GraphDatabaseService;

import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;
import br.com.goods.delivery.services.impl.DeliveryServiceImpl;
import br.com.goods.delivery.test.mock.helper.TestMockHelper;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DeliveryServiceTest {

	@InjectMocks
	private DeliveryServiceImpl deliveryService;
	
	@Mock
	private GraphDatabaseService graphDatabaseService;
	
	@Mock
	private CityService cityService;
	
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryMapNameNull() throws NotFoundException, FieldNotNullException{
		when(cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME));
		deliveryService.findLessExpensiveCostDelivery(null, TestMockHelper.ORIGIN_NAME, TestMockHelper.DESTINATION_NAME, TestMockHelper.PRICE, TestMockHelper.AUTONOMY);
	}

	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryOriginNameNull() throws NotFoundException, FieldNotNullException{
		when(cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME));
		deliveryService.findLessExpensiveCostDelivery(TestMockHelper.MAP_NAME, null, TestMockHelper.DESTINATION_NAME, TestMockHelper.PRICE, TestMockHelper.AUTONOMY);
	}
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryDestinationNameNull() throws NotFoundException, FieldNotNullException{
		when(cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME));
		deliveryService.findLessExpensiveCostDelivery(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME, null, TestMockHelper.PRICE, TestMockHelper.AUTONOMY);
	}
	
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryPriceNull() throws NotFoundException, FieldNotNullException{
		when(cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME));
		deliveryService.findLessExpensiveCostDelivery(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME, TestMockHelper.DESTINATION_NAME,  null, TestMockHelper.AUTONOMY);
	}
	
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryAutonomyNull() throws NotFoundException, FieldNotNullException{
		when(cityService.findByMapNameAndName(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME)).thenReturn(TestMockHelper.getCityTO(TestMockHelper.ORIGIN_NAME));
		deliveryService.findLessExpensiveCostDelivery(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME, TestMockHelper.DESTINATION_NAME,  TestMockHelper.PRICE, null);
	}
	
}
