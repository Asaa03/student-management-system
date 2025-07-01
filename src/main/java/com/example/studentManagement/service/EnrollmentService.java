package com.example.studentManagement.service;

import com.example.studentManagement.model.Course;
import com.example.studentManagement.model.User;

import java.util.List;

public interface EnrollmentService {
    void enrollUserInCourse(User user, List<Long> courseIds);
    List<Course> getEnrolledCourses(User user);
}
