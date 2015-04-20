package br.com.goods.delivery.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.DeliveryRestAPI;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Path("/delivery")
public class DeliveryRestAPIImpl implements DeliveryRestAPI{

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/lessExpensiveCostRoute")
	@Override
	public Response lessExpensiveCostDelivery(@PathParam("input") String from, @PathParam("input") String to) {
		return Response.ok().entity(from).build();
	}
	
}