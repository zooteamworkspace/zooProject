package com.zoo.zooApplication.configuration;

import com.zoo.zooApplication.resource.BookingResource;
import com.zoo.zooApplication.resource.CourtManagementResource;
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
@EnableJpaRepositories(basePackages = {"com.zoo.zooApplication.dao.repository"})
@EntityScan(basePackages = {"com.zoo.zooApplication.dao.model"})
@ComponentScan(basePackages = {"com.zoo.zooApplication"})
@ApplicationPath("/zooApplication")
public class ZooServiceConfiguration extends ResourceConfig {

    public ZooServiceConfiguration() {
        register(BookingResource.class);
        register(CourtManagementResource.class);
    }

    @PostConstruct
    public void init() {
        this.configureSwagger();
    }

    private void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle("Backend service for zoo application");
        config.setVersion("v1");
        config.setSchemes(new String[]{"http"});
        config.setBasePath("/zooApplication/");
        config.setResourcePackage("com.zoo.zooApplication.resource");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

}
