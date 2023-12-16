package com.example.HackathonProject.exception;

import com.example.HackathonProject.model.Patient;
import com.example.HackathonProject.exception.PatientNotFoundException;
import com.example.HackathonProject.repo.PatientRepo;
import com.example.HackathonProject.resource.PatientResource;
import com.example.HackathonProject.service.PatientService;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public PatientNotFoundException() {
        super("Patient not found.");
    }
}