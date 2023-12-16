package com.example.HackathonProject.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.io.Serializable;

import com.example.HackathonProject.model.Patient;
import com.example.HackathonProject.exception.PatientNotFoundException;
import com.example.HackathonProject.repo.PatientRepo;
import com.example.HackathonProject.resource.PatientResource;
import com.example.HackathonProject.service.PatientService;

@Table(name = "patient")
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "id")
    private Long id;
    @Column(name = "name")
    private String name; // [First] [Middle] [Last]
    @Column(name = "insProvider")

    private String insProvider; // Name of Insurance Provider, "none" if no insurance
    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "bloodType")
    private String bloodType;

    @Column(name = "affliction")
    private String affliction;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "inHospital")
    private String inHospital; // Is the patient in the hospital or out?

    @Column(name = "age")
    private String age;

    @Column(name = "sex")
    private String sex; // M = Male, F = Female, O = Other

    @Column(name = "birthdate")
    private String birthdate;
    @Column(nullable = false, updatable = false, name = "code")
    private String code;

    // CONSTRUCTORS:
    public Patient() {}

    public Patient(String name) {
        this.name = name;
    }

    // GETTERS:
    public Long GetId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInsProvider() {
        return insProvider;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getAffliction() {
        return affliction;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getInHospital() {
        return inHospital;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    // SETTERS:
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInsProvider(String insProvider) {
        this.insProvider = insProvider;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setAfflication(String affliction) {
        this.affliction = affliction;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setInHospital(String inHospital) {
        this.inHospital = inHospital;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Patient: {" + "id: " + id + ", insProvider: " + insProvider + ",  email: " + email + ", phoneNumber: + " + phoneNumber + ", address: " + address + ", bloodType: " + bloodType + ", affliction: " + affliction + ", treatment: " + treatment + ", inHospital: " + inHospital + ", age: " + age + ", sex: " + sex + ", birthdate: " + birthdate + ", code: " + code + "}";
    }
}