package com.infinite.jsf.insurance.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Recipient implements Serializable {

    private String hId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String userName;
    private String gender;          //changed from Gender to String
    private Date dob;
    private String address;
    private Date createdAt;
    private String password;
    private String email;
    private String status;          //  changed from Status to String

    private Set<Subscription> subscriptions;

    public Recipient() {
        // Default constructor
    }

    public Recipient(String hId, String firstName, String lastName, String mobile, String userName, String gender,
                     Date dob, String address, Date createdAt, String password, String email, String status,
                     Set<Subscription> subscriptions) {
        this.hId = hId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.userName = userName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.createdAt = createdAt;
        this.password = password;
        this.email = email;
        this.status = status;
        this.subscriptions = subscriptions;
    }

    public String gethId() {
        return hId;
    }

    public void sethId(String hId) {
        this.hId = hId;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
    
}
