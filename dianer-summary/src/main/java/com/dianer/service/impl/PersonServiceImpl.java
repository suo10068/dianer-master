package com.dianer.service.impl;

import com.dianer.entity.Person;
import com.dianer.mapper.PersonMapper;
import com.dianer.repository.PersonRepository;
import com.dianer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 08:48
 **/
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonRepository repository;

    @Override
    public List<Person> queryById(int id) {
        return personMapper.queryById(id);
    }

    @Override
    public List<Person> queryByName(String name) {
        return personMapper.queryByName(name);
    }

    @Override
    public int insert(String name) {
        return 0;
    }

    @Override
    public List<Person> findById(int id) {
        Optional<Person> optional = repository.findById((long) id);
        List<Person> list = new ArrayList<Person>();
        list.add(optional.get());
        return list;
    }

    @Override
    public List<Person> findByIdAndName(long id, String name) {
        return repository.findByIdAndName(id, name);
    }
}
