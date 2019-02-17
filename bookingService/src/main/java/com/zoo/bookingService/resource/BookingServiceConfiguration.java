package com.zoo.bookingService.resource;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/bookingSevice/v1")
public class BookingServiceConfiguration extends ResourceConfig {

    public BookingServiceConfiguration() {
        super(BookingResource.class);
    }


}
