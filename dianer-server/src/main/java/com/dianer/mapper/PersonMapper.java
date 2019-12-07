package com.dianer.mapper;

import com.dianer.entity.Person;

import java.util.List;


public interface PersonMapper {

    List<Person> queryById(String id);
    void insert(Person person);
}
