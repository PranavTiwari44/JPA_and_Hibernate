package com.Springboot.learnjpaandhibernate.course.jdbc;

import com.Springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static  String SELECT_QUERY =
            """
            select * from course where id =  ?;
            """;
    private static  String DELETE_QUERY =
            """
            delete from course where id =  ?;
            """;
    private static String INSERT_QUERY =
            """
            insert into course (id, name, author)
            values(?, ?, ?);
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteByID(long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course selectByID(long id){
       return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
