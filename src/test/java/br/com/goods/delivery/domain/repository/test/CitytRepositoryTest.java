package br.com.goods.delivery.domain.repository.test;

import static com.lordofthejars.nosqlunit.neo4j.Neo4jRule.Neo4jRuleBuilder.newNeo4jRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.impl.CityRepository;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.neo4j.Neo4jRule;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class CitytRepositoryTest {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public Neo4jRule neo4jRule = newNeo4jRule()
			.defaultSpringGraphDatabaseServiceNeo4j();

	@Test
	@UsingDataSet(locations = "classpath:maps-dataset.xml", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void information_about_starship_where_serves_and_members_under_his_service_should_be_retrieved()  {
		City jeanLuc = cityRepository.findByName("São Paulo");
		assertThat(jeanLuc, is(createMember("São Paulo")));
	}

	private static City createMember(String cityName) {
		return new City(cityName, "Test Map");
	}
}
