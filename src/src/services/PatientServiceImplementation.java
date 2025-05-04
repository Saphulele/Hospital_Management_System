package services;

import com.hospitalmanagement.dto.PatientDto;
import com.hospitalmanagement.exception.ResourceNotFoundException;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.repository.PatientRepository;
import com.hospitalmanagement.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto findById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDto.class);
    }

    @Override
    public PatientDto update(Long id, PatientDto patientDto) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        modelMapper.map(patientDto, existingPatient);
        Patient updatedPatient = patientRepository.save(existingPatient);
        return modelMapper.map(updatedPatient, PatientDto.class);
    }

    @Override
    public void delete(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));
        patientRepository.delete(patient);
    }
}
