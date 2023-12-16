package com.example.HackathonProject.repo;

import com.example.HackathonProject.model.Patient;
import com.example.HackathonProject.exception.PatientNotFoundException;
import com.example.HackathonProject.repo.PatientRepo;
import com.example.HackathonProject.resource.PatientResource;
import com.example.HackathonProject.service.PatientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    void deletePatientById(Long id);

    Optional<Patient> findPatientById(Long id);
}