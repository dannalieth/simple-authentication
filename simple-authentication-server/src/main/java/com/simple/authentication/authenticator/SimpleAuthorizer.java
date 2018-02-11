package com.simple.authentication.authenticator;

import io.dropwizard.auth.Authorizer;

public class SimpleAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User user, String role) {
        return user.getName().equals("naughtybynature") && user.getRole().equals(role);
    }
}
