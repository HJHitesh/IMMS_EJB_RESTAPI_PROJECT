package com.imms.rest;

import com.imms.ejb.MachineService;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/machine")
public class MachineResource {

    @EJB
    private MachineService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMachineStatus(@PathParam("id") int id) {
        return this.service.getMachineStatus(id);
    }
}
