package com.zoo.bookingService.resource;

import com.zoo.bookingService.service.BookingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bookings")
public class BookingResource {

    @Inject
    private BookingService bookingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/version")
    public String getVersion() {
        return "0.0.1";
    }
}
