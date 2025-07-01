package com.example.studentManagement.controller;

import com.example.studentManagement.model.Course;
import com.example.studentManagement.model.User;
import com.example.studentManagement.repository.CourseRepository;
import com.example.studentManagement.service.CourseService;
import com.example.studentManagement.service.EnrollmentService;
import com.example.studentManagement.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;
    private final EnrollmentService enrollmentService;
    private final CourseRepository courseRepository;

    public CourseController(CourseService courseService, CourseRepository courseRepository, UserService userService, EnrollmentService enrollmentService){
        this.courseService = courseService;
        this.courseRepository = courseRepository;
        this.enrollmentService = enrollmentService;
        this.userService = userService;
    }

    @GetMapping("/user/course")
    public String viewCourse(Model model){
        model.addAttribute("courses",courseService.getCourse());
        return "course";
    }

    @GetMapping("/user/course/available")
    public String showAvailableCourses(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Course> courses = courseRepository.findBySemester(user.getSemester());
        model.addAttribute("courses", courses);
        return "/availableCourse";
    }

    @PostMapping("/user/course/enroll")
    public String enroll(@RequestParam List<Long> courseIds, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        enrollmentService.enrollUserInCourse(user, courseIds);
        return "redirect:/user/course/enrolled";
    }

    @GetMapping("/user/course/enrolled")
    public String showEnrolledCourses(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Course> enrolledCourses = enrollmentService.getEnrolledCourses(user);
        model.addAttribute("courses", enrolledCourses);
        return "/enrolledCourse";
    }

    @GetMapping("/admin/manageCourse")
    public String viewAllCourse(Model model){
        List<Course> course = courseRepository.findAll();
        model.addAttribute("courses", course);
        return "admin/manageCourse";
    }

    @PostMapping("/admin/updateCourse/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute Course updateCourse){
        courseService.updateCourseDetails(id, updateCourse);
        return "redirect:/admin/manageCourse";
    }

    @GetMapping("/admin/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return "redirect:/admin/manageCourse";
    }
}
