# repository_factory.py

from enum import Enum
from repositories.interfaces import (
    PatientRepository,
    DoctorRepository,
    AppointmentRepository
)
from repositories.implementations.memory import (
    InMemoryPatientRepository,
    InMemoryDoctorRepository,
    InMemoryAppointmentRepository
)
 from repositories.implementations.database import (  future imports
   DatabasePatientRepository,
   DatabaseDoctorRepository,
   DatabaseAppointmentRepository
)


class StorageType(Enum):
    MEMORY = "memory"
    DATABASE = "database"


class RepositoryFactory:
    _current_storage_type = StorageType.MEMORY

    @classmethod
    def set_storage_type(cls, storage_type: StorageType):
        cls._current_storage_type = storage_type

    @classmethod
    def get_patient_repository(cls) -> PatientRepository:
        if cls._current_storage_type == StorageType.MEMORY:
            return InMemoryPatientRepository()
        elif cls._current_storage_type == StorageType.DATABASE:
            # return DatabasePatientRepository()  # future implementation
            raise NotImplementedError("Database repository not implemented yet")
        raise ValueError("Invalid storage type")

    @classmethod
    def get_doctor_repository(cls) -> DoctorRepository:
        if cls._current_storage_type == StorageType.MEMORY:
            return InMemoryDoctorRepository()
        elif cls._current_storage_type == StorageType.DATABASE:
            # return DatabaseDoctorRepository()  # future implementation
            raise NotImplementedError("Database repository not implemented yet")
        raise ValueError("Invalid storage type")

    @classmethod
    def get_appointment_repository(cls) -> AppointmentRepository:
        if cls._current_storage_type == StorageType.MEMORY:
            return InMemoryAppointmentRepository()
        elif cls._current_storage_type == StorageType.DATABASE:
            # return DatabaseAppointmentRepository()  # future implementation
            raise NotImplementedError("Database repository not implemented yet")
        raise ValueError("Invalid storage type")

# Sample Repository Interface (patient_repository.py in interfaces)

from abc import ABC, abstractmethod
from typing import List, Optional
from models.patient import Patient


class PatientRepository(ABC):
    @abstractmethod
    def add(self, patient: Patient) -> Patient:
        pass

    @abstractmethod
    def get_by_id(self, patient_id: int) -> Optional[Patient]:
        pass

    @abstractmethod
    def get_all(self) -> List[Patient]:
        pass

    @abstractmethod
    def delete(self, patient_id: int) -> bool:
        pass

    @abstractmethod
    def update(self, patient: Patient) -> Patient:
        pass

# Sample In-Memory Implementation (patient_repository.py in implementations/memory)

from typing import List, Optional, Dict
from models.patient import Patient
from repositories.interfaces.patient_repository import PatientRepository


class InMemoryPatientRepository(PatientRepository):
    def __init__(self):
        self._patients: Dict[int, Patient] = {}
        self._next_id = 1

    def add(self, patient: Patient) -> Patient:
        patient.id = self._next_id
        self._patients[patient.id] = patient
        self._next_id += 1
        return patient

    def get_by_id(self, patient_id: int) -> Optional[Patient]:
        return self._patients.get(patient_id)

    def get_all(self) -> List[Patient]:
        return list(self._patients.values())

    def delete(self, patient_id: int) -> bool:
        if patient_id in self._patients:
            del self._patients[patient_id]
            return True
        return False

    def update(self, patient: Patient) -> Patient:
        if patient.id not in self._patients:
            raise ValueError("Patient not found")
        self._patients[patient.id] = patient
        return patient
