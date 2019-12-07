package com.dianer.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Person {
    @NotNull(message = "ID不能为空")
    private int id;
    private String name;
    private String name1;
    private String gender;
    private String code1;
    private String code2;
    private String code3;
    private String code4;
    private String code5;
    private String code6;
    private String code7;
    private String code8;
    private String code9;
    private String code10;

}
