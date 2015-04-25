package br.com.goods.delivery.api.rs.impl;

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
import br.com.goods.delivery.api.rs.to.CityTO;
import br.com.goods.delivery.api.rs.to.MapTO;
import br.com.goods.delivery.api.rs.to.input.MapInputTO;
import br.com.goods.delivery.api.rs.to.output.OutputTO;
import br.com.goods.delivery.services.CityService;
import br.com.goods.delivery.services.MapService;
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
@Path("/map")
@Api(value = "/map", description = "Operations about maps")
public class MapRestAPIImpl implements MapRestAPI{
	private static final Logger logger = LoggerFactory.getLogger(MapRestAPIImpl.class);
	
	@Autowired
	private MapService mapService;

	@Autowired
	private CityService cityService;
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 415, message = "Unsupported Media Type"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response createMap(MapInputTO mapTO) {
		try{
			mapService.saveMap(mapTO);
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MESSAGE)).build();
		}
		return Response.status(Response.Status.CREATED).entity(new OutputTO("Map has been successfully created", mapTO)).build();
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response createOrUpdateMap(MapInputTO mapInputTO) {
		try{
			mapService.saveMap(mapInputTO);
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MESSAGE)).build();
		}
		return Response.ok().entity(new OutputTO("Map has been successfully created")).build();
	}

	@GET
	@Path("/city/{cityId}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "City not found"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response findCityById(@PathParam("cityId") Long cityId) {
		CityTO city = new CityTO();
		try{
			city = cityService.findById(cityId);
		}catch(NotFoundException e){
			return Response.status(Response.Status.NOT_FOUND).entity(new OutputTO(e.getMessage())).build();
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MESSAGE)).build();
		}
		return Response.ok().entity(new OutputTO(OutputTO.SUCCESS_MESSAGE, city)).build();
	}

	@GET
	@Path("/{mapName}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "Map not found"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response findCityByName(@PathParam("mapName") String mapName) {
		MapTO mapTO = new MapTO(mapName, null, null);
		try{
			mapTO = mapService.findByName(mapName);
		}catch(NotFoundException e){
			return Response.status(Response.Status.NOT_FOUND).entity(new OutputTO(e.getMessage())).build();
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MESSAGE)).build();
		}
		return Response.ok().entity(new OutputTO(OutputTO.SUCCESS_MESSAGE, mapTO)).build();
	}


	@GET
	@Path("/{mapName}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "Routes not found"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response findRoutesByMapName(@PathParam("mapName") String mapName) {
		MapTO map = new MapTO();
		try{
			map = mapService.findByName(mapName);
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO(OutputTO.ERROR_MESSAGE)).build();
		}
		return Response.ok().entity(map.getRoutes()).build();
	}
	
	@DELETE
	@Path("/{mapName}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(value = "XXXXXXXXXXXXXXXXXXXXXXXX", notes = "XXXXXXXXXXXXXXXXXXXXXXXX", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "XXXXXXXXXXXXXXXXXXXXXXXX"),
			@ApiResponse(code = 404, message = "Map not found"), 
			@ApiResponse(code = 500, message = "Internal server error")
	})
	public Response deleteMap(@PathParam("mapName") String mapName) {
		try{
			mapService.remove(mapName);
		}catch(NotFoundException e){
			return Response.status(Response.Status.NOT_FOUND).entity(new OutputTO(e.getMessage())).build();
		}catch(Exception e){
			return Response.serverError().entity(new OutputTO("Map has been successfully deleted")).build();
		}
		return Response.ok().entity(new OutputTO(OutputTO.SUCCESS_MESSAGE)).build();
	}
	
}