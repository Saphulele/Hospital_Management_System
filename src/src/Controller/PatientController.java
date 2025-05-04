package Controller;

import DTO.PatientDto;
import com.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/patients")
    public class PatientController {

        @Autowired
        private PatientService patientService;

        @GetMapping
        public ResponseEntity<List<PatientDto>> getAllPatients() {
            return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
            return new ResponseEntity<>(patientService.findById(id), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
            return new ResponseEntity<>(patientService.save(patientDto), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
            return new ResponseEntity<>(patientService.update(id, patientDto), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
            patientService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
