package com.zoo.zooApplication.resource;

import com.zoo.zooApplication.response.Court;
import com.zoo.zooApplication.service.CourtAndFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/courts")
@Api(value = "Operations relating to courts and fields")
public class CourtResource {
    private CourtAndFieldService courtAndFieldService;

    @Inject
    public CourtResource(CourtAndFieldService courtAndFieldService) {
        this.courtAndFieldService = courtAndFieldService;
    }

    @ApiOperation(value = "get current version", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Resource found")})
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/version")
    public String getVersion() {
        return "0.0.1";
    }

    @ApiOperation(value = "find the court and its fields by court id", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Court found and all the field belong to it")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courtId}")
    public Court findById(@PathParam("courtId") String courtId) {
        return courtAndFieldService.findCourtById(courtId);
    }
}
