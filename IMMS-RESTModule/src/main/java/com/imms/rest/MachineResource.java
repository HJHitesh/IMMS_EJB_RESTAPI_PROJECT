package com.imms.rest;


import java.util.List;

import com.imms.model.Machine;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/machines")
@Stateless
public class MachineResource {
    @PersistenceContext private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Machine> getAllMachines() {
        return em.createQuery("SELECT m FROM Machine m", Machine.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMachine(Machine machine) {
        em.persist(machine);
        return Response.status(Response.Status.CREATED).build();
    }
}
