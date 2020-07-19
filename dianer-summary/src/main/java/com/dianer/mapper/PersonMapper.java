package com.dianer.mapper;

import com.dianer.entity.Person;

import java.util.List;


public interface PersonMapper {

    List<Person> queryById(int id);
    List<Person> queryByName(String name);
    void insert(Person person);
}
