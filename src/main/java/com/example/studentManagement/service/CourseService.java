package com.example.studentManagement.service;

import com.example.studentManagement.model.Course;
import com.example.studentManagement.model.User;
import com.example.studentManagement.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    public Map<Integer, List<Course>> getCourse(){
        List<Course> course = courseRepository.findAll();
        return course.stream()
                .collect(Collectors.groupingBy(Course:: getSemester, LinkedHashMap::new, Collectors.toList()));
    }

    public Course updateCourseDetails(Long id, Course updatedCourse) {
        Course existing = courseRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCourseCode(updatedCourse.getCourseCode());
            existing.setCourseName(updatedCourse.getCourseName());
            existing.setSemester(updatedCourse.getSemester());
            existing.setCred(updatedCourse.getCred());
            return courseRepository.save(existing); // return the updated user
        }
        return null; // in case user not found
    }

    public Course deleteCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseRepository.deleteById(id);
        }
        return course;
    }

}
