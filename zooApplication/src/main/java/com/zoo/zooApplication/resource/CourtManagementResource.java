package com.zoo.zooApplication.resource;

import com.zoo.zooApplication.request.CreateFieldRequest;
import com.zoo.zooApplication.response.Court;
import com.zoo.zooApplication.service.CourtAndFieldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/courtManagement")
@Api(value = "Operations relating to courts and fields")
public class CourtManagementResource {
    private CourtAndFieldService courtAndFieldService;

    @Inject
    public CourtManagementResource(CourtAndFieldService courtAndFieldService) {
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

    @ApiOperation(value = "find the court and its fields by court id", response = Court.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Court found and all the field belong to it")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/courts/{courtId}")
    public Court findById(@PathParam("courtId") String courtId) {
        return courtAndFieldService.findCourtById(courtId);
    }

    @ApiOperation(value = "add a new field to the court", response = Court.class)
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Successfully added the field to court")})
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/courts/{courtId}/fields")
    public Court addFieldToCourt(@PathParam("courtId") String courtId, CreateFieldRequest createFieldRequest) {
        return courtAndFieldService.addFieldToCourt(courtId, createFieldRequest);
    }

    @ApiOperation(value = "find the court and its fields by field id", response = Court.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Court found and all the field belong to it including the field requested")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fields/{fieldId}")
    public Court findByFieldId(@PathParam("fieldId") String fieldId) {
        return courtAndFieldService.findCourtByFieldId(fieldId);
    }
}
