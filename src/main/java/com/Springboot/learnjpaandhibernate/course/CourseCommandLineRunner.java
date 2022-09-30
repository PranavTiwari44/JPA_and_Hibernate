package com.Springboot.learnjpaandhibernate.course;

import com.Springboot.learnjpaandhibernate.course.Course;
import com.Springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.Springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.Springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
            repository.save(new Course(1, "Learn JavaFX!", "Pranav"));
            repository.save(new Course(2, "Learn Spring Boot", "Pranav"));
            repository.save(new Course(3, "Learn JavaScript", "Pranav"));

            repository.deleteById((long)2);

            System.out.println(repository.findById((long)3));
    }
}
