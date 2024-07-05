package org.example.employer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/JSON")
    public String hello() {
        return "Hello, World!";
    }
}