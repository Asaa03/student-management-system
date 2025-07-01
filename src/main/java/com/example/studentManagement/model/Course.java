package com.example.studentManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "semester", nullable = false)
    public int semester;

    @Column(name="courseCode", nullable = false)
    public String courseCode;

    @Column(name = "courseName", unique = true)
    public String courseName;

    @Column(name = "cred", nullable = false)
    public int cred;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public int getSemester(){
        return semester;
    }
    public void setSemester(int semester){
        this.semester = semester;
    }

    public String getCourseCode(){
        return courseCode;
    }
    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public int getCred(){
        return cred;
    }
    public void setCred(int cred){
        this.cred = cred;
    }
}
