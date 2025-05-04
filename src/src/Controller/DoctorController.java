package Controller;

import com.hospitalmanagement.dto.AppointmentDto;
import com.hospitalmanagement.dto.DoctorDto;
import com.hospitalmanagement.service.AppointmentService;
import com.hospitalmanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private DoctorService doctorService;


    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return new ResponseEntity<>(doctorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        return new ResponseEntity<>(doctorService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/{doctorId}/appointments")
    public ResponseEntity<AppointmentDto> scheduleAppointment(
            @PathVariable Long doctorId,
            @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(
                appointmentService.scheduleAppointment(doctorId, appointmentDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}/appointments")
    public ResponseEntity<List<AppointmentDto>> getDoctorAppointments(
            @PathVariable Long doctorId) {
        return new ResponseEntity<>(
                appointmentService.findByDoctorId(doctorId),
                HttpStatus.OK);
    }
}
