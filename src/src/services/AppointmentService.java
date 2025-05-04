package services;

import com.hospital.repositories.AppointmentRepository;
import com.hospital.models.Appointment;
import com.hospital.exceptions.AppointmentNotFoundException;
import com.hospital.exceptions.AppointmentConflictException;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService extends Exception {
    private final AppointmentRepository appointmentRepo;

    public AppointmentService(AppointmentRepository appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public Appointment scheduleAppointment(Appointment appointment) {
        // Validate appointment time (must be in future)
        if (appointment.getDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time must be in the future");
        }

        // Check for overlapping appointments for the doctor
        List<Appointment> existingAppointments = appointmentRepo
                .findByDoctorIdAndDateTimeBetween(
                        appointment.getDoctorId(),
                        appointment.getDateTime().minusMinutes(29),
                        appointment.getDateTime().plusMinutes(29));

        if (!existingAppointments.isEmpty()) {
            throw new AppointmentConflictException("Doctor already has an appointment within 30 minutes of this time");
        }

        return appointmentRepo.save(appointment);
    }

    public void cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException(appointmentId));

        // Can't cancel appointments that have already passed
        if (appointment.getDateTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Cannot cancel past appointments");
        }

        appointmentRepo.delete(appointment);
    }

    public List<Appointment> getAppointmentsByPatient(String patientId) {
        return appointmentRepo.findByPatientIdOrderByDateTimeAsc(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(String doctorId) {
        return appointmentRepo.findByDoctorIdOrderByDateTimeAsc(doctorId);
    }
}
