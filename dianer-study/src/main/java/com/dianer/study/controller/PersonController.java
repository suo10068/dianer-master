package com.dianer.study.controller;

import com.dianer.study.annotation.CacheLock;
import com.dianer.study.annotation.CacheParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @CacheLock(prefix = "token", expire = 10)
    @GetMapping(value = "/b")
    public String test2(@CacheParam String token) {
        log.info("=== {} ===", token);
        return "success - " + token;
    }
}
