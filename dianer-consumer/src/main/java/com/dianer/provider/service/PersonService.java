package com.dianer.provider.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dianer-server")
public interface PersonService {

    @GetMapping(value = "/person/c")
    public String test3();
}
