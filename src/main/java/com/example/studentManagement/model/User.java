package com.example.studentManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long  id;

    @Column(name = "userName",nullable = false)
    public String userName;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "email",unique = true, nullable = false)
    public String email;

    @Column(name = "semester")
    public int semester;

    @Column(name = "number" )
    public long number;

    @Column(name = "address")
    public String address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getSemester(){
        return semester;
    }
    public void setSemester(int semester){
        this.semester = semester;
    }

    public long getNumber(){
        return number;
    }
    public void setNumber(long number){
        this.number = number;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
