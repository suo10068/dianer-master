package com.dianer.service;

import com.dianer.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> queryById(int id);
    public List<Person> queryByName(String name);
    public int insert(String name);

    public List<Person> findById(int id);


    List<Person> findByIdAndName(long id, String name);
}
