package br.com.goods.delivery.services.impl;

import java.text.MessageFormat;

import org.neo4j.graphalgo.GraphAlgoFactory;
import org.neo4j.graphalgo.PathFinder;
import org.neo4j.graphalgo.WeightedPath;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.PathExpanders;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.api.rs.to.output.DeliveryOutputTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.domain.repository.CityRepository;
import br.com.goods.delivery.services.DeliveryService;

/**
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{
	private static final Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);
	
	@Autowired(required=false)
	private GraphDatabaseService graphDatabaseService;
	
	@Autowired
	private CityRepository cityRepository;
	
	public DeliveryOutputTO findLessExpensiveCostDelivery(String mapName, String originName, String destinationName, Double price, Double autonomy) {
		WeightedPath dijkstraUsage = getLessExpensiveCostPathWithDijkstra(mapName, originName, destinationName);
		Double distance = dijkstraUsage.weight();
		Double cost = (price * distance)/autonomy;
		
		Iterable<Relationship> relationships = dijkstraUsage.relationships();
		
		StringBuilder sb = new StringBuilder();
		for (Relationship relationship : relationships) {
			sb.append(" ");
			sb.append(relationship.getStartNode().getProperty("name"));
		}
		
		String route = sb.toString();
		String message = MessageFormat.format("Route {0} cost {1} and is the less expensive cost delivery route", route, cost);
		
		return new DeliveryOutputTO(cost, route, message);
	}
	
	@Transactional		
    private WeightedPath getLessExpensiveCostPathWithDijkstra(String mapName, String originName, String destinationName){
    	City origin = cityRepository.findByName(originName);
    	City destination = cityRepository.findByName(destinationName);
//    	Node originNode = graphDatabaseService.getNodeById(origin.getId());
//    	Node destinatioNode = graphDatabaseService.getNodeById(destination.getId());

    	PathFinder<WeightedPath> finder = GraphAlgoFactory.dijkstra(                
            PathExpanders.forTypeAndDirection( new RelationshipType() {
				@Override
				public String name() {
					return "distance";
				}
			}, Direction.BOTH ), "distance" );

    	Transaction tx = graphDatabaseService.beginTx();
        WeightedPath path = finder.findSinglePath( (Node)origin, (Node) destination );
        tx.success();
	  	tx.close();
        return path;
    }

}