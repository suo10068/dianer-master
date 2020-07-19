package com.dianer.test;

import com.dianer.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 14:01
 **/
public class MybatisMain {

    private static final String resource = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();
        try {
            Person person = (Person) sqlSession.selectOne("com.dianer.mapper.PersonMapper.queryById", 1);
            System.out.println("Result : " + person.getName());
        } finally {
            sqlSession.close();
        }

    }

}
