package com.simple.authentication;

import static com.google.common.base.Preconditions.checkNotNull;

import com.simple.authentication.backend.DatabaseBackend;
import com.simple.authentication.backend.DatabaseConfiguration;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Server configuration for the simple-authentication API server.
 */
public final class SimpleAuthenticationConfiguration extends Configuration {
    private final DatabaseConfiguration databaseConfiguration;

    @JsonCreator
    public SimpleAuthenticationConfiguration(
            @JsonProperty("database") final DatabaseConfiguration database) {
        checkNotNull(database);

        this.databaseConfiguration = database;
    }

    public DatabaseConfiguration getDatabaseConfiguration() { return databaseConfiguration; }

    public DatabaseBackend getDatabaseBackend(Environment environment) {
        return databaseConfiguration.createDBI(environment, "jdbi-backend").onDemand(DatabaseBackend.class);
    }
}
