package com.entitymapping.oneToOne.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class UserProfile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Size(max = 100)
    private String city;

    @Size(max = 100)
    private String state;

    @Size(max = 100)
    private String country;

    @Size(max = 32)
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User user;

    public UserProfile(){}

    public UserProfile(String phoneNumber, Gender gender, String city, String state, String country, String zipCode){
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
