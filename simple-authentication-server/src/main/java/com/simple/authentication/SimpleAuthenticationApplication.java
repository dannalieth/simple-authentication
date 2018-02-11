package com.simple.authentication;

import com.simple.authentication.Resource.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.simple.authentication.backend.DatabaseBackend;

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
        //DatabaseBackend databaseBackend = configuration.getDatabaseBackend(environment);
        environment.jersey().register(new HelloResource());
    }
}
