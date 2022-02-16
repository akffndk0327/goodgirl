package com.example.goodgirl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "ID", nullable = false, length = 15)
    private String id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "NAME", nullable = false, length = 10)
    private String name;

    @Column(name = "ADDRESS", nullable = false, length = 50)
    private String address;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @Column(name = "BIRTHDAY", nullable = false)
    private LocalDate birthday;

    @Column(name = "GENDER", nullable = false)
    private Character gender;

    @Column(name = "PHONE", nullable = false, length = 15)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}