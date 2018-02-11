package com.simple.authentication.Resource;

import com.simple.authentication.service.HelloService;

public class HelloResource implements HelloService {
    @Override
    public String hello() {
        return "hello";
    }
}
