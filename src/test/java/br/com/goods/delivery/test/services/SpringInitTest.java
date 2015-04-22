/**
 * 
 */
package br.com.goods.delivery.test.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class SpringInitTest {

	private final Logger log = LoggerFactory.getLogger(SpringInitTest.class);
	
	@Test
	public void springInitTest(){
		log.info("Spring inicializado com sucesso");
	}
	
}
