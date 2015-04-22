package br.com.goods.delivery.db.cfg;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 *  Neo4J repositories configuration 
 *  
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "br.com.goods.delivery.domain")
public class Neo4JConfig extends Neo4jConfiguration{


	public Neo4JConfig() {
        setBasePackage("br.com.goods.delivery.domain");
    }

    @Bean
    GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("goodsDeliveryNeo4j.db");
    }
	
}