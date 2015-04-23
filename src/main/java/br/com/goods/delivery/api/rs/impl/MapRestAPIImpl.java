package br.com.goods.delivery.api.rs.impl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goods.delivery.api.rs.MapRestAPI;
import br.com.goods.delivery.api.rs.to.input.MapInputTO;
import br.com.goods.delivery.api.rs.to.output.OutputTO;
import br.com.goods.delivery.domain.model.City;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.MapService;

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
@Path("/map")
@Api(value = "/map", description = "Operations about maps")
public class MapRestAPIImpl implements MapRestAPI{
	private static final Logger logger = LoggerFactory.getLogger(MapRestAPIImpl.class);
	
	@Autowired
	private MapService mapService;

	@Autowired
	private CityService cityService;
	
	@GET
	@Path("/echo/{input}")
	@Consumes({MediaType.TEXT_PLAIN})
	@Produces({MediaType.TEXT_PLAIN })
	public String ping(@PathParam("input") String cityName) {
		return cityName;
	}

	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 415, message = "Unsupported Media Type"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response createMap(MapInputTO mapTO) {
		try{
			mapService.saveMap(mapTO);
		}
		catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MSG)).build();
		}
		return Response.ok().entity(new OutputTO(OutputTO.SUCCESS_MSG)).build();
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "XXXXXXXXXXXXXXXXXXXXXXXX"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response createOrUpdateMap(MapInputTO mapTO) {
		try{
			mapService.saveMap(mapTO);
		}
		catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MSG)).build();
		}
		return Response.ok().entity(mapTO).build();
	}

	@GET
	@Path("/city/{cityId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "XXXXXXXXXXXXXXXXXXXXXXXX"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response findCityById(@PathParam("mapId") Long mapId) {
		City city = null;
		try{
			//TODO O RETORNO DESSE MÉTODO DEVE SER UM TO E NÃO UMA ENTIDADE. 
			city = cityService.findById(mapId);
		}
		catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MSG)).build();
		}
		return Response.ok().entity(city).build();
	}

	@GET
	@Path("/{mapName}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "XXXXXXXXXXXXXXXXXXXXXXXX"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response findCityByName(@PathParam("mapName") String mapName) {
		Set<City> cities = new HashSet<City>();
		try{
			//TODO O RETORNO DESSE MÉTODO DEVE SER UM TO E NÃO UMA ENTIDADE. 
			cities = mapService.findByName(mapName);
		}
		catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MSG)).build();
		}
		return Response.ok().entity(cities).build();
	}


	@DELETE
	@Path("/{mapName}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "XXXXXXXXXXXXXXXXXXXXXXXX"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response deleteMap(@PathParam("mapName") String mapName) {
		return Response.ok().build();
	}
	
}