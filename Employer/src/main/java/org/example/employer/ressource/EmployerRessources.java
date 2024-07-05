package org.example.employer.ressource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.employer.model.Employer;
import org.example.employer.service.EmployerService;

import java.util.List;

@Path("/Employer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployerRessources implements BasesRessources<Employer> {

    private EmployerService employerService;

    @Inject
    public EmployerRessources(EmployerService employerService) {
        this.employerService = employerService;
        System.out.println("Hey");
    }

    @Override
    @GET
    @Path("/{id}")
    public Employer finfById(@PathParam("id") Long id) {
        return employerService.findById(id);
    }

    @Override
    @GET
    @Path("/")
    public List<Employer> findAll() {
        System.out.println("Hey");
        return employerService.findAll();
    }

    @Override
    @POST
    @Path("/Add")
    public Employer create(Employer entity) {
        employerService.add(entity.getName(), entity.getPoste(), entity.getDepartement());
        return null;
    }

    @Override
    @PUT
    @Path("/{id}")
    public Employer update(@PathParam("id") Long id, Employer entity) {
       return employerService.update(id, entity.getName(), entity.getPoste(), entity.getDepartement());
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
