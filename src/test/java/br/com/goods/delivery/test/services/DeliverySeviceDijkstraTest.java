/**
 * 
 */
package br.com.goods.delivery.test.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import br.com.goods.delivery.api.rs.helper.CityHelper;
import br.com.goods.delivery.api.rs.to.output.DeliveryOutputTO;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.DeliveryService;
import br.com.goods.delivery.services.MapService;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;
import br.com.goods.delivery.test.mock.helper.TestMockHelper;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class DeliverySeviceDijkstraTest {

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
		mapService.saveMap(TestMockHelper.createMapInputTO());
	}
	
	@After
	public void finishTest() throws NotFoundException{
		mapService.remove(TestMockHelper.MAP_NAME);
	}

	@Test
	public void testFindLessExpensiveCostDelivery() throws NotFoundException, FieldNotNullException{
		DeliveryOutputTO deliveryTO = deliveryService.findLessExpensiveCostDelivery(TestMockHelper.MAP_NAME, TestMockHelper.ORIGIN_NAME, TestMockHelper.DESTINATION_NAME, TestMockHelper.PRICE, TestMockHelper.AUTONOMY);
		Assert.isTrue(new Double(6.25).equals(deliveryTO.getCost()));
		Assert.isTrue(" a b b d".equals(deliveryTO.getRoute()));
	}
	
}
