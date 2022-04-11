package com.javaexpress;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServerApplication {
	
	Logger logger = LoggerFactory.getLogger(GatewayServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		logger.info("myRoutes method is called in gateway server");
	    return builder.routes()
	        .route("routename",p -> 
	             p .path("/bank/accounts/**")
	            .filters(f -> f.rewritePath("/bank/accounts/(?<segment>.*)","/${segment}")
	            				.addResponseHeader("X-Response-Time",new Date().toString()))
	            .uri("lb://ACCOUNTS")).
	        route(p -> p
		            .path("/bank/**")
		            .filters(f -> f.rewritePath("/bank/(?<segment>.*)","/${segment}")
		            				.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://ACCOUNTS")).
	        route(p -> p
		            .path("/bank/loans/**")
		            .filters(f -> f.rewritePath("/bank/loans/(?<segment>.*)","/${segment}")
		            		.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://LOANS")).
	        route(p -> p
		            .path("/bank/cards/**")
		            .filters(f -> f.rewritePath("/bank/cards/(?<segment>.*)","/${segment}")
		            		.addResponseHeader("X-Response-Time",new Date().toString()))
		            .uri("lb://CARDS")).build();
	}

}
