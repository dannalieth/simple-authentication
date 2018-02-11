package com.simple.authentication;

import com.simple.authentication.authenticator.SimpleAuthenticator;
import com.simple.authentication.authenticator.SimpleAuthorizer;
import com.simple.authentication.authenticator.User;
import com.simple.authentication.resource.HelloResource;
import com.simple.authentication.resource.OpenResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.CachingAuthenticator;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

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
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new SimpleAuthenticator())
                        .setAuthorizer(new SimpleAuthorizer())
                        .setRealm("default realm")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
        environment.jersey().register(new HelloResource());
        environment.jersey().register(new OpenResource());
    }
}
