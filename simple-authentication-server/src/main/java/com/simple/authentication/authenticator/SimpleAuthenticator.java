package com.simple.authentication.authenticator;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import java.util.Optional;

public class SimpleAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("asdf".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername(), "NAUGHTY"));
        }
        return Optional.empty();
    }
}
