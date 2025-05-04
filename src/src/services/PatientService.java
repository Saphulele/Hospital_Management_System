package services;

import com.hospital.repositories.PatientRepository;
import com.hospital.models.Patient;
import com.hospital.exceptions.PatientNotFoundException;
import com.hospital.exceptions.PatientAlreadyAdmittedException;

import java.time.LocalDate;
import java.util.List;

public class PatientService extends Exception{
    private final PatientRepository patientRepo;

    public PatientService(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient admitPatient(Patient patient) {
        // Check if patient with same ID is already admitted
        if (patientRepo.findById(patient.getId()).isPresent()) {
            throw new PatientAlreadyAdmittedException(patient.getId());
        }

        // Validate patient age (must be at least 1 year old)
        if (patient.getDateOfBirth().isAfter(LocalDate.now().minusYears(1))) {
            throw new IllegalArgumentException("Patient must be at least 1 year old");
        }

        // Set admission date to current date
        patient.setAdmissionDate(LocalDate.now());

        return patientRepo.save(patient);
    }

    public Patient dischargePatient(String patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(patientId));

        if (patient.getDischargeDate() != null) {
            throw new IllegalStateException("Patient already discharged");
        }

        patient.setDischargeDate(LocalDate.now());
        return patientRepo.save(patient);
    }

    public List<Patient> getAllAdmittedPatients() {
        return patientRepo.findByDischargeDateIsNull();
    }

    public Patient getPatientById(String patientId) {
        return patientRepo.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException(patientId));
    }
}
