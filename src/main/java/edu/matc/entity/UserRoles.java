package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by toddkinsman on 10/18/16.
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @Column(name = "user_name")
    private String user_name;

    @Column(name = "role_name")
    private String role_name;

    @Column(name = "user_role_id")
    private int userRoleId;

    public UserRoles() {
    }

    public UserRoles(String user_name, String role_name) {
        super();
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

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }
}
