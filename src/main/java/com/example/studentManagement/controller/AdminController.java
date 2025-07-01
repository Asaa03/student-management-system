package com.example.studentManagement.controller;

import com.example.studentManagement.model.Course;
import com.example.studentManagement.model.Role;
import com.example.studentManagement.model.User;
import com.example.studentManagement.repository.RoleRepository;
import com.example.studentManagement.service.AdminService;
import com.example.studentManagement.service.CourseService;
import com.example.studentManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private final UserService userService;
    private final AdminService adminService;
    private final CourseService courseService;
    private final RoleRepository roleRepository;


    public AdminController(AdminService adminService, UserService userService, CourseService courseService, RoleRepository roleRepository){
        this.adminService = adminService;
        this.userService = userService;
        this.courseService = courseService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/admin")
    public String adminDashboard(Model model){
        Map<String, Long> roleCount = adminService.getRoleCount();
        model.addAttribute("adminCount", roleCount.get("admin"));
        model.addAttribute("facultyCount", roleCount.get("faculty"));
        model.addAttribute("userCount", roleCount.get("user"));
        return "admin/dashboard";
    }

    @GetMapping("/admin/addUser")
    public String showAddUserForm(Model model){
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @PostMapping("/admin/addUser")
    public String addUser(@Valid @ModelAttribute("user") User user, Model model) {
        Role defaultRole = roleRepository.findByRoleName("ROLE_USER");
        user.getRoles().add(defaultRole);

        userService.saveUser(user);
        model.addAttribute("success", "User added successfully!");
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @GetMapping("/admin/addCourse")
    public String showAddCourseForm(Model model){
        model.addAttribute("course", new Course());
        return "admin/addCourse";
    }

    @PostMapping("/admin/addCourse")
    public String addCourse(@Valid @ModelAttribute("course") Course course, Model model ){
        courseService.saveCourse(course);
        model.addAttribute("success", "Course added successfully");
        model.addAttribute("course", new Course());
        return "admin/addCourse";
    }

    @GetMapping("/admin/manageUser")
    public String viewAllUsers(Model model){
        List<User> user = userService.getAllUsers();
        model.addAttribute("users", user);
        return "admin/manageUser";
    }

    @PostMapping("/admin/updateUser/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User updateUser){
        userService.updateUserDetails(id, updateUser);
        return "redirect:/admin/manageUser";
    }

    @GetMapping("/admin/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return "redirect:/admin/manageUser";
    }



}
