package com.zoo.bookingService.configuration;

import com.zoo.bookingService.resource.BookingResource;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@EnableJpaRepositories(basePackages = {"com.zoo.bookingService.dao.repository"})
@EntityScan(basePackages = {"com.zoo.bookingService.dao.model"})
@ComponentScan(basePackages = {"com.zoo.bookingService.service", "com.zoo.bookingService.converter", "com.zoo.bookingService.util"})
@ApplicationPath("/bookingService")
public class BookingServiceConfiguration extends ResourceConfig {

    public BookingServiceConfiguration() {
        register(BookingResource.class);
    }

    @PostConstruct
    public void init() {
        this.configureSwagger();
    }

    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle("Booking Service for Zoo project");
        config.setVersion("v1");
        config.setSchemes(new String[]{"http"});
        config.setBasePath("/bookingService/");
        config.setResourcePackage("com.zoo.bookingService.resource");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

}
