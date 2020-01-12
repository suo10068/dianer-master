package com.dianer.bigdata.controller;

import com.dianer.bigdata.config.HadoopTemplate;
import com.dianer.bigdata.service.HdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/hdfs")
public class HdfsController {

    @Autowired
    HadoopTemplate template;
    @Autowired
    HdfsService service;

    @GetMapping("/get")
    public String get() {
        template.download("input/yum.log", "C:\\Users\\dianer\\Desktop\\jar");
        return "下载成功！";
    }

    @GetMapping("/put/{fileName}")
    public String put(@PathVariable(value = "fileName") String fileName) {
        System.out.println(fileName);
        template.copyFileToHDFS(false, false, "C:\\Users\\dianer\\Desktop\\log", "input");
        return "上传成功";
    }

    @GetMapping("/merge")
    public String merge() throws IOException {
        service.merge();
        return "合并成功";
    }
}
