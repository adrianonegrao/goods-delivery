package br.com.goods.delivery.domain.repository.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.CityRepository;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class CitytRepositoryTest {

	@Autowired
	private CityRepository cityRepository;

	@Test
	@UsingDataSet(locations = "classpath:maps-dataset.xml", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testeCityRepository()  {
		 City jeanLuc = cityRepository.findByName("São Paulo");
		 assertThat(jeanLuc, is(createMember("São Paulo")));
	}

	private static City createMember(String cityName) {
		return new City(cityName, "Test Map");
	}
}
