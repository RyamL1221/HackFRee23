package com.example.HackathonProject.service;

import com.example.HackathonProject.model.Patient;
import com.example.HackathonProject.exception.PatientNotFoundException;
import com.example.HackathonProject.repo.PatientRepo;
import com.example.HackathonProject.resource.PatientResource;
import com.example.HackathonProject.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class PatientService {

    private final PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }
    public Patient addPatient(Patient patient) {
        patient.setCode(UUID.randomUUID().toString());
        return patientRepo.save(patient);
    }

    public List<Patient> findAllPatients() {
        return patientRepo.findAll();
    }

    public Patient updatePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient findPatientById(Long id) {
        return patientRepo.findPatientById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient with id " + id + "was not found."));
    }

    public void deletePatient(Long id) {
        patientRepo.deletePatientById(id);
    }
}