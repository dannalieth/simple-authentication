package com.simple.authentication.service;

import com.codahale.metrics.annotation.Timed;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public interface HelloService {

    @GET
    @Timed
    @RolesAllowed("NAUGHTY")
    String hello();
}
