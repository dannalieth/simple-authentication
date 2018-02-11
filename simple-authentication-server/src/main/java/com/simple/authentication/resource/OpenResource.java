package com.simple.authentication.resource;

import com.simple.authentication.service.OpenService;

public class OpenResource implements OpenService {
    @Override
    public String open() {
        return "Opened!";
    }
}
