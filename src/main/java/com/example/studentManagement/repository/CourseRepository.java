package com.example.studentManagement.repository;

import com.example.studentManagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    List<Course> findAll();

    List<Course> findBySemester(int semester);

}
