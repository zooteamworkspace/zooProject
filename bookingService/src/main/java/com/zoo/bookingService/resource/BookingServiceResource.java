package com.zoo.bookingService.resource;

import com.zoo.bookingService.response.FieldBooking;
import com.zoo.bookingService.service.BookingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("search")
@Api(value = "Operations relating to field bookings and reservations")
public class BookingServiceResource {


    @Inject
    private BookingService bookingService;

    @ApiOperation(value = "find the field bookings by field id", response = FieldBooking.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Resource found")})
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    @Path("fieldId={fieldId}&limit={limit}&offset={offset}")

    public List<FieldBooking> findByFieldId(@PathParam("fieldId") String fieldId,
                                            @PathParam("limit") int lim,
                                            @PathParam("offset") int offset) {
        Pageable pageable = PageRequest.of(offset,lim);
        return bookingService.findAllBookingByFieldId(NumberUtils.toLong(fieldId),pageable);
    }
}