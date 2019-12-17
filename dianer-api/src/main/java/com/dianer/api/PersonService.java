package com.dianer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/person")
public interface PersonService {

    @GetMapping(value = "/c")
    public String test3();

}
