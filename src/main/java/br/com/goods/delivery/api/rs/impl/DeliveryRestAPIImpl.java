package br.com.goods.delivery.api.rs.impl;

import java.net.HttpURLConnection;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.DeliveryRestAPI;

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
	
	@GET
	@Path("/lessExpensiveCostRoute")
	@Produces({MediaType.APPLICATION_JSON}) @Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "Provides the less expensive cost of a delivery and its path", notes = "More notes about this method", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid mapName, originName, destinationName, price or autonomy supplied"),
			@ApiResponse(code = 404, message = "Route not found"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response lessExpensiveCostDelivery(
			@NotNull @PathParam(value = "mapName") String mapName,
			@NotNull @PathParam(value = "sourceName") String originName,
			@NotNull @PathParam(value = "destinationName") String destinationName,
			@NotNull @PathParam(value = "price") @DefaultValue("0.0") Double price,
			@NotNull @PathParam(value = "autonomy") @DefaultValue("0.0") Double autonomy) {
		validateParameters(mapName, originName, destinationName, price,
				autonomy);
		
		return Response.ok().entity(mapName).build();
	}

	/**
	 * @param mapName
	 * @param sourceName
	 * @param destinationName
	 * @param price
	 * @param autonomy
	 */
	private void validateParameters(String mapName, String originName,
			String destinationName, Double price, Double autonomy) {
		if (StringUtils.isEmpty(mapName)) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("mapName parameter is mandatory").build());
		}
		if (StringUtils.isEmpty(originName)) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("mapName parameter is mandatory").build());
		}
		if (StringUtils.isEmpty(destinationName)) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("mapName parameter is mandatory").build());
		}
		if (price == null) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("mapName parameter is mandatory").build());
		}
		if (autonomy == null) {
			throw new WebApplicationException(Response
					.status(HttpURLConnection.HTTP_BAD_REQUEST)
					.entity("mapName parameter is mandatory").build());
		}
	}

}