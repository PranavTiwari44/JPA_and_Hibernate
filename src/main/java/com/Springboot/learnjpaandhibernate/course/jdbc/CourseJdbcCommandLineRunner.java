package com.Springboot.learnjpaandhibernate.course.jdbc;

import com.Springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
            repository.insert(new Course(1, "Learn JavaFX!", "Pranav"));
            repository.insert(new Course(2, "Learn Spring Boot", "Pranav"));
            repository.insert(new Course(3, "Learn JavaScript", "Pranav"));

            repository.deleteByID(2);

            System.out.println(repository.selectByID(1));

    }
}
