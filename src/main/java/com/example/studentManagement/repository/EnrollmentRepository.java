package com.example.studentManagement.repository;

import com.example.studentManagement.model.Enrollment;
import com.example.studentManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByUser(User user);
}
