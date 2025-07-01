package com.example.studentManagement.service;

import com.example.studentManagement.model.Course;
import com.example.studentManagement.model.Enrollment;
import com.example.studentManagement.model.User;
import com.example.studentManagement.repository.CourseRepository;
import com.example.studentManagement.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

    private final EnrollmentRepository enrollmentRepository;

    private  final CourseRepository courseRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository){
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void enrollUserInCourse(User user, List<Long> courseIds) {
        for(Long courseId : courseIds){
            Course course = courseRepository.findById(courseId).orElse(null);
            if(course != null){
                Enrollment enrollment = new Enrollment();
                enrollment.setUser(user);
                enrollment.setCourse(course);
                enrollmentRepository.save(enrollment);
            }
        }
    }

    @Override
    public List<Course> getEnrolledCourses(User user) {
        return enrollmentRepository.findByUser(user)
                .stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }
}
