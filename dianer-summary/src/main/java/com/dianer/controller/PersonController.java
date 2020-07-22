package com.dianer.controller;

import com.dianer.entity.Person;
import com.dianer.entity.Result;
import com.dianer.service.PersonService;
import com.dianer.util.FreemarkerUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Log4j2
@RequestMapping(value = "/person")
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    FreemarkerUtil freemarkerUtil;

    @GetMapping(value = "/{id}")
    public Result test1(@PathVariable int id) {
        log.info("=== {} ===", id);

        Map<String, Object> map = new HashMap<>();
        map.put("TrsCode", "AAAAAA");
        map.put("num", "007");

        List<Map<String, Object>> list = new ArrayList<>();
        map.put("BList", list);

        Map<String, Object> m1 = new HashMap<>();
        m1.put("ReturnCode", "m1");
        Map<String, Object> m2 = new HashMap<>();
        m2.put("ReturnCode", "m2");
        Map<String, Object> m3 = new HashMap<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        String process = null;
        try {
            process = freemarkerUtil.process(map, "test-01");
            System.out.println(process);
        } catch (Exception e) {
            process = e.getMessage();
        }

        return Result.success(Arrays.asList(process));
//        List<Person> list = personService.queryById(id);
//        return Result.success(list);
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
