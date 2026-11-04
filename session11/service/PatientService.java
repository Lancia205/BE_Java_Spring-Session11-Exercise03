package com.example.session11.service;

import com.example.session11.entity.Patient;
import com.example.session11.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Them benh nhan
    public Patient addPatient(Patient patient) {
        log.info("Đang thêm bệnh nhân: {}", patient.getName());

        return patientRepository.save(patient);
    }

    // Tim kiem danh sach benh nhan
    public List<Patient> searchPatient() {

        log.trace("Bắt đầu tìm kiếm bệnh nhân");

        log.debug("Đang thực hiện truy vấn Database");

        List<Patient> patients = patientRepository.findAll();

        log.info("Đã tìm thấy {} bệnh nhân", patients.size());

        return patients;
    }
}