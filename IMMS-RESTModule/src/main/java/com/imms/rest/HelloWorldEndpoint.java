package com.imms.rest;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "{\"message\": \"Hello, World!\"}";
    }
}