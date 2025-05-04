package services;

import com.hospital.repositories.DoctorRepository;
import com.hospital.models.Doctor;
import com.hospital.exceptions.DoctorNotFoundException;
import com.hospital.exceptions.DoctorNotAvailableException;

import java.util.List;

public class DoctorService extends Exception {
    private final DoctorRepository doctorRepo;

    public DoctorService(DoctorRepository doctorRepo) {
        this.doctorRepo = doctorRepo;a
    }

    public Doctor addDoctor(Doctor doctor) {
        // Validate doctor's license number
        if (doctor.getLicenseNumber() == null || doctor.getLicenseNumber().isEmpty()) {
            throw new IllegalArgumentException("License number is required");
        }

        // Check if license number is already registered
        if (doctorRepo.findByLicenseNumber(doctor.getLicenseNumber()).isPresent()) {
            throw new IllegalArgumentException("Doctor with this license number already exists");
        }

        return doctorRepo.save(doctor);
    }

    public Doctor assignPatient(String doctorId, String patientId) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        // Check if doctor has reached maximum patient capacity (e.g., 20 patients)
        if (doctor.getAssignedPatientIds().size() >= 20) {
            throw new DoctorNotAvailableException(doctorId, "Doctor has reached maximum patient capacity");
        }

        doctor.getAssignedPatientIds().add(patientId);
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAvailableDoctors() {
        return doctorRepo.findByAssignedPatientIdsSizeLessThan(20);
    }

    public Doctor getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));
    }
}
