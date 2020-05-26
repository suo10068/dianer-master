package com.dianer.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @GetMapping(value = "/b")
    public String test2(String token) {
        log.info("=== {} ===", token);
        return "success - " + token;
    }
}
