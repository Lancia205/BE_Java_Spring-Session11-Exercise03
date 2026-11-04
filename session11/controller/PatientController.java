package com.example.session11.controller;

import com.example.session11.entity.Patient;
import com.example.session11.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Them benh nhan
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {

        log.info("Controller: Tiếp nhận bệnh nhân {}", patient.getName());

        if (patient.getAge() > 120) {
            log.warn("Tuổi bệnh nhân bất thường: {} tuổi", patient.getAge());
        }

        return patientService.addPatient(patient);
    }

    // Tim kiem benh nhan
    @GetMapping("/search")
    public List<Patient> searchPatient() {

        log.info("Controller: Nhận yêu cầu tìm kiếm bệnh nhân");

        return patientService.searchPatient();
    }
}