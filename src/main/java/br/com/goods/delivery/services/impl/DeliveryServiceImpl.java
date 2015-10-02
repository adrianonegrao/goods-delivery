package br.com.goods.delivery.services.impl;

import static br.com.goods.delivery.domain.model.Route.DISTANCE_RELATIONSHIP_TYPE;

import java.text.MessageFormat;

import org.apache.cxf.common.util.StringUtils;
import org.neo4j.graphalgo.GraphAlgoFactory;
import org.neo4j.graphalgo.PathFinder;
import org.neo4j.graphalgo.WeightedPath;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.PathExpanders;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.api.rs.to.output.DeliveryTO;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.DeliveryService;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;

/**
 * Services that provides the core business rules about delivery, cost and routes. 
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{
	private static final Logger logger = LoggerFactory.getLogger(DeliveryServiceImpl.class);
	
	@Autowired
	private GraphDatabaseService graphDatabaseService;
	
	@Autowired
	private CityService cityService;
	
	public DeliveryTO findLessExpensiveCostDelivery(String mapName, String originName, String destinationName, Double price, Double autonomy) throws NotFoundException, FieldNotNullException {
		this.validateParameters(mapName, originName, destinationName, price, autonomy);
		
		logger.debug("mapName: {}, originName: {}, destinationName: {}, price: {}, autonomy: {}", mapName, originName, destinationName, price, autonomy);
		
		WeightedPath dijkstraUsage = getShortestRouteWithDijkstra(mapName, originName, destinationName);
		Double distance = dijkstraUsage.weight();
		Double cost = (price * distance)/autonomy;
		
		Iterable<Relationship> relationships = dijkstraUsage.relationships();
		StringBuilder sb = new StringBuilder();
		for (Relationship relationship : relationships) {
			sb.append(" ");
			sb.append(relationship.getStartNode().getProperty("name"));
			sb.append(" ");
			sb.append(relationship.getEndNode().getProperty("name"));
		}
		
		String route = sb.toString();
		String message = MessageFormat.format("The less expensive cost delivery route is {0} and costs $ {1}", route, cost);
		
		logger.debug("The less expensive cost delivery route is {} and costs $ {}", route, cost);
		
		return new DeliveryTO(cost, route, message);
	}
	
    private WeightedPath getShortestRouteWithDijkstra(String mapName, String originName, String destinationName) throws NotFoundException{
    	CityTO origin = cityService.findByMapNameAndName(mapName, originName);
    	CityTO destination = cityService.findByMapNameAndName(mapName, destinationName);

    	PathFinder<WeightedPath> finder = GraphAlgoFactory.dijkstra(
            PathExpanders.forTypeAndDirection(new DistanceRelationshipType(), Direction.BOTH), DISTANCE_RELATIONSHIP_TYPE );

    	Node originNode = graphDatabaseService.getNodeById(origin.getId());
    	Node destinatioNode = graphDatabaseService.getNodeById(destination.getId());
        return finder.findSinglePath( originNode, destinatioNode );
    }

	 private class DistanceRelationshipType implements RelationshipType {
		@Override
		public String name() {
			return DISTANCE_RELATIONSHIP_TYPE;
		}
	}
	 
	private void validateParameters(String mapName, String originName,
			String destinationName, Double price, Double autonomy) throws FieldNotNullException {
		if (StringUtils.isEmpty(mapName)) {
			throw new FieldNotNullException("mapName cannot be null or blank");
		}
		if (StringUtils.isEmpty(originName)) {
			throw new FieldNotNullException("originName cannot be null or blank");
		}
		if (StringUtils.isEmpty(destinationName)) {
			throw new FieldNotNullException("destinationName cannot be null or blank");
		}
		if (price == null) {
			throw new FieldNotNullException("price cannot be null or blank");
		}
		if (autonomy == null) {
			throw new FieldNotNullException("autonomy cannot be null or blank");
		}
	}
}