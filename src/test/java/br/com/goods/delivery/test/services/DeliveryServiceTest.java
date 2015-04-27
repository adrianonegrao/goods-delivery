/**
 * 
 */
package br.com.goods.delivery.test.services;

import static br.com.goods.delivery.test.helper.TestMockHelper.AUTONOMY;
import static br.com.goods.delivery.test.helper.TestMockHelper.DESTINATION_NAME;
import static br.com.goods.delivery.test.helper.TestMockHelper.MAP_NAME;
import static br.com.goods.delivery.test.helper.TestMockHelper.ORIGIN_NAME;
import static br.com.goods.delivery.test.helper.TestMockHelper.PRICE;
import static br.com.goods.delivery.test.helper.TestMockHelper.createMapInputTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.output.DeliveryTO;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.DeliveryService;
import br.com.goods.delivery.services.MapService;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class DeliveryServiceTest {

	@Autowired
	private CityHelper cityHelper;
	
	@Autowired
	private MapService mapService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private DeliveryService deliveryService;

	@Before
	public void initTest(){
		mapService.saveMap(createMapInputTO());
	}
	
	@After
	public void finishTest() throws NotFoundException{
		mapService.remove(MAP_NAME);
	}

	@Test
	public void testFindLessExpensiveCostDelivery() throws NotFoundException, FieldNotNullException{
		DeliveryTO deliveryTO = deliveryService.findLessExpensiveCostDelivery(MAP_NAME, ORIGIN_NAME, DESTINATION_NAME, PRICE, AUTONOMY);
		Assert.isTrue(new Double(6.25).equals(deliveryTO.getCost()));
		Assert.isTrue(" a b b d".equals(deliveryTO.getRoute()));
	}
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryMapNameNull() throws NotFoundException, FieldNotNullException{
		deliveryService.findLessExpensiveCostDelivery(null, ORIGIN_NAME, DESTINATION_NAME, PRICE, AUTONOMY);
	}

	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryOriginNameNull() throws NotFoundException, FieldNotNullException{
		deliveryService.findLessExpensiveCostDelivery(MAP_NAME, null, DESTINATION_NAME, PRICE, AUTONOMY);
	}
	
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryDestinationNameNull() throws NotFoundException, FieldNotNullException{
		deliveryService.findLessExpensiveCostDelivery(MAP_NAME, ORIGIN_NAME, null, PRICE, AUTONOMY);
	}
	
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryPriceNull() throws NotFoundException, FieldNotNullException{
		deliveryService.findLessExpensiveCostDelivery(MAP_NAME, ORIGIN_NAME, DESTINATION_NAME,  null, AUTONOMY);
	}
	
	@Test(expected=FieldNotNullException.class)
	public void testExceptionFindLessExpensiveCostDeliveryAutonomyNull() throws NotFoundException, FieldNotNullException{
		deliveryService.findLessExpensiveCostDelivery(MAP_NAME, ORIGIN_NAME, DESTINATION_NAME,  PRICE, null);
	}
}
