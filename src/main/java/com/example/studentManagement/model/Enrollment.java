package com.example.studentManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne
    User user;

    @ManyToOne
    Course course;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }
}
