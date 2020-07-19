package com.dianer.repository;

import com.dianer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {


    List<Person> findByIdAndName(long id, String name);
}
