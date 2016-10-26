package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import edu.matc.util.LocalDateAttributeConverter;
import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by toddkinsman on 9/21/16.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int userid;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "user_pass")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "user_rating")
    private int userRating;

    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "joinDate")
    private LocalDate joinDate;

    public User() {
    }

    public User(String userType, String userName, String firstName, String lastName, String password, String address, String city, int userRating, LocalDate joinDate) {
        this.userType = userType;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.city = city;
        this.userRating = userRating;
        this.joinDate = joinDate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

}
