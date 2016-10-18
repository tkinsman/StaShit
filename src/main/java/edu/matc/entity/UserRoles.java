package edu.matc.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by toddkinsman on 10/18/16.
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {


    private String user_name;

    private String role_name;

    public UserRoles(String user_name, String role_name) {
        this.user_name = user_name;
        this.role_name = role_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
