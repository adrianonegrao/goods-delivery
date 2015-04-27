package br.com.goods.delivery.api.rs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.DeliveryRestAPI;
import br.com.goods.delivery.api.rs.to.output.DeliveryTO;
import br.com.goods.delivery.api.rs.to.output.OutputTO;
import br.com.goods.delivery.services.DeliveryService;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * Rest API that receive a mapName, origin, destination, price and autonomy 
 * and provides the less expensive delivery cost and its route.
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Path("/delivery")
@Api(value = "/delivery", description = "Everything about delivery, cost and routes")
public class DeliveryRestAPIImpl implements DeliveryRestAPI{
	
	@Autowired
	private DeliveryService deliveryService;
	
	@GET
	@Path("/lessExpensiveCostRoute/{mapName}/{originName}/{destinationName}/{price}/{autonomy}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Provides the less expensive delivery cost and its route.", response = DeliveryTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid mapName, originName, destinationName, price or autonomy supplied"),
			@ApiResponse(code = 404, message = "Route not found"), 
			@ApiResponse(code = 415, message = "Unsupported Media Type"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	@Override
	public Response lessExpensiveCostDelivery(
			@ApiParam(name="mapName", required=true) @PathParam(value = "mapName") String mapName,
			@ApiParam(name="originName", required=true) @PathParam(value = "originName") String originName,
			@ApiParam(name="destinationName", required=true) @PathParam(value = "destinationName") String destinationName,
			@ApiParam(name="price", required=true) @PathParam(value = "price") Double price,
			@ApiParam(name="autonomy", required=true) @PathParam(value = "autonomy") Double autonomy) {

	DeliveryTO deliveryOutpuTO = new DeliveryTO();
		try{
			deliveryOutpuTO = deliveryService.findLessExpensiveCostDelivery(mapName, originName, destinationName, price, autonomy);
		}catch(FieldNotNullException e){
			return Response.status(Response.Status.NOT_FOUND).entity(new OutputTO(e.getMessage())).build();
		}catch(NotFoundException e){
			return Response.status(Response.Status.NOT_FOUND).entity(new OutputTO(e.getMessage())).build();
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MESSAGE)).build();
		}
		return Response.ok().entity(deliveryOutpuTO).build();
	}

}