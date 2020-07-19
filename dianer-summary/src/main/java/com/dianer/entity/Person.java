package com.dianer.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 08:38
 **/

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String name_1;
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
