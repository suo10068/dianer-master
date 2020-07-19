package com.dianer.test;

import org.aspectj.weaver.ast.Var;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-06-01 18:55
 **/
public class HashCodeMain {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("AAA", 11));
        set.add(new Person("AAA", 11));
        set.add(new Person("BBB", 22));

        set.forEach(p -> {
            System.out.println(p.toString());
        });
    }
}


class Person {

    static Random RANDOM = new Random(100);

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        result = 31 * result + this.age;

        result = RANDOM.nextInt();

        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
