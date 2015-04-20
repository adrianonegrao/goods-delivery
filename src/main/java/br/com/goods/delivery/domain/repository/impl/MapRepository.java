package br.com.goods.delivery.domain.repository.impl;

import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.goods.delivery.domain.model.Map;

/**
 * @Map entity repository
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
public interface MapRepository extends GraphRepository<Map> {

}