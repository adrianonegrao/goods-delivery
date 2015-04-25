package br.com.goods.delivery.api.rs.impl;

import java.net.HttpURLConnection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.DeliveryRestAPI;
import br.com.goods.delivery.api.rs.to.output.DeliveryOutputTO;
import br.com.goods.delivery.api.rs.to.output.OutputTO;
import br.com.goods.delivery.services.DeliveryService;
import br.com.goods.delivery.services.exception.FieldNotNullException;
import br.com.goods.delivery.services.exception.NotFoundException;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * 
 * @author Tayguer A. Ap. Onofre
 * @version 1.0
 *
 */
@Service
@Path("/delivery")
@Api(value = "/delivery", description = "Operations about delivery")
public class DeliveryRestAPIImpl implements DeliveryRestAPI{
	private static final Logger logger = LoggerFactory.getLogger(DeliveryRestAPIImpl.class);
	
	@Autowired
	private DeliveryService deliveryService;
	
	@GET
	@Path("/lessExpensiveCostRoute/{mapName}/{originName}/{destinationName}/{price}/{autonomy}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Provides the less expensive delivery cost and its route", notes = "More notes about this method", response = DeliveryOutputTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid mapName, originName, destinationName, price or autonomy supplied"),
			@ApiResponse(code = 404, message = "Route not found"), 
			@ApiResponse(code = 415, message = "Unsupported Media Type"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response lessExpensiveCostDelivery(
			@PathParam(value = "mapName") String mapName,
			@PathParam(value = "originName") String originName,
			@PathParam(value = "destinationName") String destinationName,
			@PathParam(value = "price") Double price,
			@PathParam(value = "autonomy") Double autonomy) {

	DeliveryOutputTO deliveryOutpuTO = new DeliveryOutputTO();
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