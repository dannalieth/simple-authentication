package com.simple.authentication;

import com.simple.authentication.resource.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Main entry point to the simple-authentication API server.
 */
public final class SimpleAuthenticationApplication extends Application<SimpleAuthenticationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SimpleAuthenticationApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SimpleAuthenticationConfiguration> bootstrap) {
      
    }

    @Override
    public void run(final SimpleAuthenticationConfiguration configuration, final Environment environment) {
        environment.jersey().register(new HelloResource());
    }
}
