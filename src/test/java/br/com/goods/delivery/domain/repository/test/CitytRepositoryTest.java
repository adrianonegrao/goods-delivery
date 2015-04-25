package br.com.goods.delivery.domain.repository.test;

import static com.lordofthejars.nosqlunit.neo4j.Neo4jRule.Neo4jRuleBuilder.newNeo4jRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.CityRepository;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.neo4j.Neo4jRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
@EnableTransactionManagement
public class CitytRepositoryTest {
//
	@Autowired
	private CityRepository cityRepository;
//	
//	@Autowired
//    private ApplicationContext applicationContext;
//
//    @Rule
//    public Neo4jRule neo4jRule = newNeo4jRule()
//                    .defaultSpringGraphDatabaseServiceNeo4j();
	@Test
	@UsingDataSet(locations="maps-dataset.xml", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testeCityRepository()  {
		City jeanLuc = cityRepository.findByMapNameAndName("TEST_MAP", "São Paulo");
		Result<City> findAll = cityRepository.findAll();
		for (City city : findAll) {
			System.out.println(city.getName());
		}
		assertThat(jeanLuc, is(createMember("São Paulo")));
	}

	private static City createMember(String cityName) {
		return new City(cityName, "Test Map");
	}
}
