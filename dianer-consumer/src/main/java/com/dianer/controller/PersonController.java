package com.dianer.controller;

import com.dianer.provider.service.KKPersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/test")
public class PersonController {

    @Autowired
    KKPersonService service;

    @GetMapping()
    public String test() {
        String result;
        try {
            result = service.test3();
        } catch (Exception e) {
            log.error("服务调用异常：", e);
            result = "服务调用失败";
        }
        return result;
    }
}
