# Patient Repository

## **/repositories/inmemory/inmemory_patient_repository.py**

from typing import Optional, Dict
from models.patient import Patient  # Assuming you have a Patient model
from repositories.patient_repository import PatientRepository  # Interface


class InMemoryPatientRepository(PatientRepository):
    def __init__(self):
        self._storage: Dict[str, Patient] = {}

    def save(self, patient: Patient) -> None:
        self._storage[patient.id] = patient

    def find_by_id(self, id: str) -> Optional[Patient]:
        return self._storage.get(id)

    def find_all(self) -> list[Patient]:
        return list(self._storage.values())

    def delete(self, id: str) -> None:
        if id in self._storage:
            del self._storage[id]

    def update(self, patient: Patient) -> None:
        if patient.id in self._storage:
            self._storage[patient.id] = patient

# Doctor Repository

## /repositories/inmemory/inmemory_doctor_repository.py

from typing import Optional, Dict
from models.doctor import Doctor  # Assuming you have a Doctor model
from repositories.doctor_repository import DoctorRepository  # Interface


class InMemoryDoctorRepository(DoctorRepository):
    def __init__(self):
        self._storage: Dict[str, Doctor] = {}

    def save(self, doctor: Doctor) -> None:
        self._storage[doctor.id] = doctor

    def find_by_id(self, id: str) -> Optional[Doctor]:
        return self._storage.get(id)

    def find_all(self) -> list[Doctor]:
        return list(self._storage.values())

    def delete(self, id: str) -> None:
        if id in self._storage:
            del self._storage[id]

    def update(self, doctor: Doctor) -> None:
        if doctor.id in self._storage:
            self._storage[doctor.id] = doctor

    def find_by_specialization(self, specialization: str) -> list[Doctor]:
        return [doc for doc in self._storage.values() if doc.specialization == specialization]
# Appointment Repository

## /repositories/inmemory/inmemory_appointment_repository.py

from typing import Optional, Dict, List
from models.appointment import Appointment  # Assuming you have an Appointment model
from repositories.appointment_repository import AppointmentRepository  # Interface


class InMemoryAppointmentRepository(AppointmentRepository):
    def __init__(self):
        self._storage: Dict[str, Appointment] = {}

    def save(self, appointment: Appointment) -> None:
        self._storage[appointment.id] = appointment

    def find_by_id(self, id: str) -> Optional[Appointment]:
        return self._storage.get(id)

    def find_all(self) -> List[Appointment]:
        return list(self._storage.values())

    def delete(self, id: str) -> None:
        if id in self._storage:
            del self._storage[id]

    def update(self, appointment: Appointment) -> None:
        if appointment.id in self._storage:
            self._storage[appointment.id] = appointment

    def find_by_patient_id(self, patient_id: str) -> List[Appointment]:
        return [appt for appt in self._storage.values() if appt.patient_id == patient_id]

    def find_by_doctor_id(self, doctor_id: str) -> List[Appointment]:
        return [appt for appt in self._storage.values() if appt.doctor_id == doctor_id]
# 
