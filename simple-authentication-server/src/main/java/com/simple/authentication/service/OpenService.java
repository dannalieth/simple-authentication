package com.simple.authentication.service;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/open")
@Produces(MediaType.APPLICATION_JSON)
public interface OpenService {

    @GET
    @Timed
    String open();
}
