package br.com.goods.delivery.domain.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.com.goods.delivery.domain.model.Route;

/**
 * @{link Route} entity repository
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Repository
public interface RouteRepository extends GraphRepository<Route> {

}