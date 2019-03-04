package com.zoo.bookingService.resource;

import com.zoo.bookingService.response.FieldBooking;
import com.zoo.bookingService.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.math.NumberUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/bookings")
@Api(value = "Operations relating to field bookings and reservations")
public class BookingResource {

    @Inject
    private BookingService bookingService;

    @ApiOperation(value = "get current version", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Resource found")})
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/version")
    public String getVersion() {
        return "0.0.1";
    }

    @ApiOperation(value = "find the field bookings by id", response = FieldBooking.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Resource found")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{bookingId}")
    public FieldBooking findById(@PathParam("bookingId") String bookingId) {
        return bookingService.findBookingById(NumberUtils.toLong(bookingId));
    }
}
