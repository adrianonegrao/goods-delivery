package br.com.goods.delivery.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.MapRestAPI;
import br.com.goods.delivery.api.rs.to.MapTO;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Path("/map")
public class MapRestAPIImpl implements MapRestAPI{

	@GET
	@Path("/echo/{input}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public String ping(@PathParam("input") String input) {
		return input;
	}

	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/map")
	@Override
	public Response createOrUpdateMap(MapTO input) {
		input.setMapName(input.getMapName());
		return Response.ok().entity(input).build();
	}

	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/map")
	@Override
	public Response deleteMap(MapTO input) {
		input.setMapName(input.getMapName());
		return Response.ok().entity(input).build();
	}
	
}