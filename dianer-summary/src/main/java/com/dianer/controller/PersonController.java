package com.dianer.controller;

import com.dianer.entity.Person;
import com.dianer.entity.Result;
import com.dianer.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/{id}")
    public Result test1(@PathVariable int id) {
        log.info("=== {} ===", id);
        List<Person> list = personService.queryById(id);
        return Result.success(list);
    }

    @GetMapping(value = "id/{id}")
    public Result findById(@PathVariable int id) {
        log.info("=== {} ===", id);
        List<Person> list = personService.findById(id);
        return Result.success(list);
    }

    @GetMapping(value = "/{id}/{name}")
    public Result findByIdAndName(@PathVariable long id, @PathVariable String name, HttpServletRequest request) {
        log.info("=== {} ===", request.getRequestURI());
        log.info("=== {} ===", request.getRequestURL());
        List<Person> list = personService.findByIdAndName(id, name);
        return Result.success(list);
    }

    @GetMapping(value = "/name/{name}")
    public Result test2(@PathVariable("name") String name) {
        log.info("=== {} ===", name);
        List<Person> list = personService.queryByName(name);
        return Result.success(list);
    }

}
