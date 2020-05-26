package com.dianer.controller;

import com.dianer.aspectj.annotation.CacheLock;
import com.dianer.aspectj.annotation.CacheParam;
import com.dianer.api.PersonService;
import com.dianer.entity.Person;
import com.dianer.mapper.PersonMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/person")
public class PersonController implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @GetMapping(value = "/a")
    public List<Person> test(@Valid Person person) {
        log.info("请求参数：{}", person);
        return personMapper.queryById(String.valueOf(person.getId()));
    }

    @CacheLock(prefix = "token", expire = 30)
    @GetMapping(value = "/b")
    public String test2(@CacheParam String token) {
        log.info("=== {} ===", token);
        return "success - " + token;
    }

    @Override
    public String test3() {
        log.info("请求参数：{}");
        return "【AAAA】";
    }

}
