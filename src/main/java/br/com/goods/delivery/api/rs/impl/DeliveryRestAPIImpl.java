package br.com.goods.delivery.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.DeliveryRestAPI;
import br.com.goods.delivery.api.rs.to.input.DeliveryInputTO;
import br.com.goods.delivery.api.rs.to.output.DeliveryOutputTO;
import br.com.goods.delivery.api.rs.to.output.OutputTO;
import br.com.goods.delivery.services.DeliveryService;

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
	@Path("/lessExpensiveCostRoute")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Provides the less expensive cost of a delivery and its path", notes = "More notes about this method", response = DeliveryOutputTO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid mapName, originName, destinationName, price or autonomy supplied"),
			@ApiResponse(code = 404, message = "Route not found"), 
			@ApiResponse(code = 415, message = "Unsupported Media Type"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response lessExpensiveCostDelivery(DeliveryInputTO deliveryTO) {
		DeliveryOutputTO deliveryOutpuTO = new DeliveryOutputTO();
		try{
			deliveryOutpuTO = deliveryService.findLessExpensiveCostDelivery(
					deliveryTO.getMapName(), deliveryTO.getOriginName(),
					deliveryTO.getDestinationName(), deliveryTO.getPrice(),
					deliveryTO.getAutonomy());
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MSG)).build();
		}
		return Response.ok().entity(deliveryOutpuTO).build();
	}

//	private void validateParameters(String mapName, String originName,
//			String destinationName, Double price, Double autonomy) {
////		Response.serverError().entity("UUID cannot be blank").build();
//		if (StringUtils.isEmpty(mapName)) {
//			throw new WebApplicationException(Response
//					.status(HttpURLConnection.HTTP_BAD_REQUEST)
//					.entity("mapName parameter is mandatory").build());
//		}
//		if (StringUtils.isEmpty(originName)) {
//			throw new WebApplicationException(Response
//					.status(HttpURLConnection.HTTP_BAD_REQUEST)
//					.entity("mapName parameter is mandatory").build());
//		}
//		if (StringUtils.isEmpty(destinationName)) {
//			throw new WebApplicationException(Response
//					.status(HttpURLConnection.HTTP_BAD_REQUEST)
//					.entity("mapName parameter is mandatory").build());
//		}
//		if (price == null) {
//			throw new WebApplicationException(Response
//					.status(HttpURLConnection.HTTP_BAD_REQUEST)
//					.entity("mapName parameter is mandatory").build());
//		}
//		if (autonomy == null) {
//			throw new WebApplicationException(Response
//					.status(HttpURLConnection.HTTP_BAD_REQUEST)
//					.entity("mapName parameter is mandatory").build());
//		}
//	}

}