package com.example.studentManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(name = "roleName", unique = true)
    public String roleName;

    public long getRoleId(){
        return id;
    }
    public void setRoleId(long id){
        this.id = id;
    }

    public String getRoleName(){
        return roleName;
    }
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

}
