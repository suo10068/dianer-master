package com.dianer.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 08:51
 **/
@Data
public class Result {

    private int code;
    private String msg;
    private List<Object> data;

    public Result() {

    }

    public static Result success(List data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static Result faild(String msg) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }

}
