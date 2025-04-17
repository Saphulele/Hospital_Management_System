from __future__ import annotations
from datetime import datetime
from abc import ABC, abstractmethod
from typing import List, Optional
from queue import Queue
import copy

# Base Classes
class Person:
    def __init__(self, name: str, contact_info: str):
        self.name = name
        self.contact_info = contact_info
    
    def get_name(self) -> str:
        return self.name
    
    def set_name(self, name: str) -> None:
        self.name = name
    
    def get_contact_info(self) -> str:
        return self.contact_info
    
    def set_contact_info(self, contact_info: str) -> None:
        self.contact_info = contact_info

class Staff(Person, ABC):
    def __init__(self, name: str, contact_info: str, employee_id: str, department: str):
        super().__init__(name, contact_info)
        self.employee_id = employee_id
        self.department = department
    
    def get_employee_id(self) -> str:
        return self.employee_id
    
    def get_department(self) -> str:
        return self.department

# Forward declarations to fix circular dependencies
class Patient(Person):
    pass

class Doctor(Staff):
    pass

class Appointment:
    def __init__(self, patient: Optional[Patient], doctor: Optional[Doctor], 
                 date_time: Optional[datetime], reason: str):
        self.patient = patient
        self.doctor = doctor
        self.date_time = date_time
        self.reason = reason
    
    def get_patient(self) -> Optional[Patient]:
        return self.patient
    
    def set_patient(self, patient: Optional[Patient]) -> None:
        self.patient = patient
    
    def get_doctor(self) -> Optional[Doctor]:
        return self.doctor
    
    def set_doctor(self, doctor: Optional[Doctor]) -> None:
        self.doctor = doctor
    
    def get_date_time(self) -> Optional[datetime]:
        return self.date_time
    
    def set_date_time(self, date_time: Optional[datetime]) -> None:
        self.date_time = date_time
    
    def get_reason(self) -> str:
        return self.reason
    
    def set_reason(self, reason: str) -> None:
        self.reason = reason

# Complete the Patient class implementation
class Patient(Person):
    def __init__(self, name: str, contact_info: str):
        super().__init__(name, contact_info)
        self.medical_history = ""
        self.appointments: List[Appointment] = []
    
    def add_appointment(self, appointment: Appointment) -> None:
        self.appointments.append(appointment)
    
    def get_medical_history(self) -> str:
        return self.medical_history
    
    def update_medical_history(self, update: str) -> None:
        self.medical_history += "\n" + update
    
    def clone(self) -> Patient:
        return copy.deepcopy(self)

# Complete the Doctor class implementation
class Doctor(Staff):
    def __init__(self, name: str, contact_info: str, employee_id: str, 
                 department: str, specialization: str):
        super().__init__(name, contact_info, employee_id, department)
        self.specialization = specialization
        self.patients: List[Patient] = []
    
    def add_patient(self, patient: Patient) -> None:
        self.patients.append(patient)
    
    def get_specialization(self) -> str:
        return self.specialization

class Nurse(Staff):
    def __init__(self, name: str, contact_info: str, employee_id: str, 
                department: str, qualification: str):
        super().__init__(name, contact_info, employee_id, department)
        self.qualification = qualification
    
    def get_qualification(self) -> str:
        return self.qualification

# Singleton Pattern
class HospitalManagementSystem:
    _instance = None
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance.patients: List[Patient] = []
            cls._instance.doctors: List[Doctor] = []
            cls._instance.nurses: List[Nurse] = []
            cls._instance.appointments: List[Appointment] = []
        return cls._instance
    
    def add_patient(self, patient: Patient) -> None:
        self.patients.append(patient)
    
    def add_doctor(self, doctor: Doctor) -> None:
        self.doctors.append(doctor)
    
    def add_nurse(self, nurse: Nurse) -> None:
        self.nurses.append(nurse)
    
    def schedule_appointment(self, appointment: Appointment) -> None:
        self.appointments.append(appointment)
        if appointment.get_patient() and appointment.get_doctor():
            appointment.get_patient().add_appointment(appointment)
            appointment.get_doctor().add_patient(appointment.get_patient())
    
    def get_patients(self) -> List[Patient]:
        return self.patients.copy()
    
    def get_doctors(self) -> List[Doctor]:
        return self.doctors.copy()
    
    def get_nurses(self) -> List[Nurse]:
        return self.nurses.copy()
    
    def get_appointments(self) -> List[Appointment]:
        return self.appointments.copy()

# Factory Method Pattern
class StaffFactory(ABC):
    @abstractmethod
    def create_staff(self, name: str, contact_info: str, 
                    employee_id: str, department: str) -> Staff:
        pass

class DoctorFactory(StaffFactory):
    def create_staff(self, name: str, contact_info: str, 
                    employee_id: str, department: str) -> Staff:
        return Doctor(name, contact_info, employee_id, department, "General")

class NurseFactory(StaffFactory):
    def create_staff(self, name: str, contact_info: str, 
                    employee_id: str, department: str) -> Staff:
        return Nurse(name, contact_info, employee_id, department, "RN")

# Abstract Factory Pattern
class HospitalAbstractFactory(ABC):
    @abstractmethod
    def create_patient(self, name: str, contact_info: str) -> Patient:
        pass
    
    @abstractmethod
    def create_staff(self, staff_type: str, name: str, contact_info: str, 
                    employee_id: str, department: str) -> Staff:
        pass

class GeneralHospitalFactory(HospitalAbstractFactory):
    def create_patient(self, name: str, contact_info: str) -> Patient:
        return Patient(name, contact_info)
    
    def create_staff(self, staff_type: str, name: str, contact_info: str, 
                    employee_id: str, department: str) -> Staff:
        if staff_type.lower() == "doctor":
            return Doctor(name, contact_info, employee_id, department, "General")
        elif staff_type.lower() == "nurse":
            return Nurse(name, contact_info, employee_id, department, "RN")
        else:
            raise ValueError("Invalid staff type")

# Builder Pattern
class PatientBuilder:
    def __init__(self):
        self.name = ""
        self.contact_info = ""
        self.medical_history = ""
    
    def set_name(self, name: str) -> PatientBuilder:
        self.name = name
        return self
    
    def set_contact_info(self, contact_info: str) -> PatientBuilder:
        self.contact_info = contact_info
        return self
    
    def set_medical_history(self, medical_history: str) -> PatientBuilder:
        self.medical_history = medical_history
        return self
    
    def build(self) -> Patient:
        patient = Patient(self.name, self.contact_info)
        if self.medical_history:
            patient.update_medical_history(self.medical_history)
        return patient

# Object Pool Pattern
class AppointmentPool:
    _instance = None
    
    def __new__(cls, max_size: int):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance.max_size = max_size
            cls._instance.pool = Queue(maxsize=max_size)
            cls._instance.initialize_pool()
        return cls._instance
    
    def initialize_pool(self) -> None:
        for _ in range(self.max_size):
            self.pool.put(Appointment(None, None, None, ""))
    
    def acquire(self, patient: Patient, doctor: Doctor, 
               date_time: datetime, reason: str) -> Optional[Appointment]:
        if not self.pool.empty():
            appointment = self.pool.get()
            appointment.set_patient(patient)
            appointment.set_doctor(doctor)
            appointment.set_date_time(date_time)
            appointment.set_reason(reason)
            return appointment
        return None
    
    def release(self, appointment: Appointment) -> None:
        if self.pool.qsize() < self.max_size:
            appointment.set_patient(None)
            appointment.set_doctor(None)
            appointment.set_date_time(None)
            appointment.set_reason("")
            self.pool.put(appointment)

def main():
    print("=== Hospital Management System with All Creational Patterns ===")
    
    # 1. Singleton Pattern
    print("\n1. Testing Singleton Pattern:")
    hospital1 = HospitalManagementSystem()
    hospital2 = HospitalManagementSystem()
    print(f"Are both instances the same? {hospital1 is hospital2}")
    
    # 2. Factory Method Pattern
    print("\n2. Testing Factory Method Pattern:")
    doctor_factory = DoctorFactory()
    doctor = doctor_factory.create_staff("Dr. Smith", "123-4567", "D001", "Cardiology")
    print(f"Created Doctor: {doctor.get_name()}, Specialty: {doctor.get_specialization()}")
    
    nurse_factory = NurseFactory()
    nurse = nurse_factory.create_staff("Nurse Jane", "987-6543", "N001", "ER")
    print(f"Created Nurse: {nurse.get_name()}, Qualification: {nurse.get_qualification()}")
    
    # 3. Abstract Factory Pattern
    print("\n3. Testing Abstract Factory Pattern:")
    factory = GeneralHospitalFactory()
    patient = factory.create_patient("John Doe", "555-1234")
    print(f"Created Patient: {patient.get_name()}")
    
    abstract_doctor = factory.create_staff("doctor", "Dr. Brown", "111-2222", "D002", "Pediatrics")
    print(f"Created Doctor via Abstract Factory: {abstract_doctor.get_name()}")
    
    # 4. Builder Pattern
    print("\n4. Testing Builder Pattern:")
    complex_patient = (PatientBuilder()
                      .set_name("Alice Wonder")
                      .set_contact_info("555-9876")
                      .set_medical_history("Allergic to penicillin, diabetic")
                      .build())
    print(f"Built Patient: {complex_patient.get_name()}, History: {complex_patient.get_medical_history()}")
    
    # 5. Prototype Pattern
    print("\n5. Testing Prototype Pattern:")
    original_patient = Patient("Original Bob", "555-0000")
    original_patient.update_medical_history("Hypertension")
    cloned_patient = original_patient.clone()
    print(f"Original: {original_patient.get_name()}, History: {original_patient.get_medical_history()}")
    print(f"Clone: {cloned_patient.get_name()}, History: {cloned_patient.get_medical_history()}")
    
    # Modify original to show deep copy
    original_patient.update_medical_history("Added condition")
    print("After modification:")
    print(f"Original History: {original_patient.get_medical_history()}")
    print(f"Clone History: {cloned_patient.get_medical_history()}")
    
    # 6. Object Pool Pattern
    print("\n6. Testing Object Pool Pattern:")
    pool = AppointmentPool(3)
    
    # Create resources
    pool_patient = Patient("Pool Patient", "555-1111")
    pool_doctor = Doctor("Pool Doctor", "555-2222", "D003", "General", "Internal Medicine")
    
    # Acquire appointments
    appt1 = pool.acquire(pool_patient, pool_doctor, datetime.now(), "Checkup")
    appt2 = pool.acquire(pool_patient, pool_doctor, datetime.now(), "Follow-up")
    print(f"Appointment 1: {appt1.get_reason() if appt1 else 'None'}")
    print(f"Appointment 2: {appt2.get_reason() if appt2 else 'None'}")
    
    # Release and reuse
    if appt1:
        pool.release(appt1)
    appt3 = pool.acquire(pool_patient, pool_doctor, datetime.now(), "New appointment")
    print(f"Appointment 3 (should reuse appt1's object): {appt3.get_reason() if appt3 else 'None'}")
    
    # 7. Integration with Hospital Management System
    print("\n7. Integrating All Patterns with Hospital System:")
    
    # Add created objects to hospital system
    hospital1.add_patient(patient)
    hospital1.add_patient(complex_patient)
    hospital1.add_patient(cloned_patient)
    hospital1.add_patient(pool_patient)
    
    hospital1.add_doctor(doctor)
    hospital1.add_doctor(abstract_doctor)
    hospital1.add_doctor(pool_doctor)
    
    hospital1.add_nurse(nurse)
    
    if appt1: hospital1.schedule_appointment(appt1)
    if appt2: hospital1.schedule_appointment(appt2)
    if appt3: hospital1.schedule_appointment(appt3)
    
    # Show system status
    print("\nHospital System Status:")
    print(f"Patients: {len(hospital1.get_patients())}")
    print(f"Doctors: {len(hospital1.get_doctors())}")
    print(f"Nurses: {len(hospital1.get_nurses())}")
    print(f"Appointments: {len(hospital1.get_appointments())}")
    
    print("\n=== All Patterns Demonstrated Successfully ===")

if __name__ == "__main__":
    main()
