# 1. Generic Repository Interface (base.py)

from abc import ABC, abstractmethod
from typing import Generic, TypeVar, Optional, List

T = TypeVar('T')  # Entity type
ID = TypeVar('ID')  # ID type (could be str, int, etc.)

class Repository(Generic[T, ID], ABC):
    """Generic repository interface with standard CRUD operations"""
    
    @abstractmethod
    def save(self, entity: T) -> None:
        """Saves a given entity (create or update)"""
        pass
    
    @abstractmethod
    def find_by_id(self, id: ID) -> Optional[T]:
        """Retrieves an entity by its id"""
        pass
    
    @abstractmethod
    def find_all(self) -> List[T]:
        """Returns all entities"""
        pass
    
    @abstractmethod
    def delete(self, id: ID) -> None:
        """Deletes the entity with the given id"""
        pass

 #  2. Entity-Specific Repository Interfaces (patient.py)

 from typing import List, Optional
from abc import ABC, abstractmethod
from hospital.repositories.base import Repository
from hospital.entities.patient import Patient

class PatientRepository(Repository[Patient, str], ABC):
    """Patient-specific repository interface"""
    
    @abstractmethod
    def find_by_last_name(self, last_name: str) -> List[Patient]:
        """Finds patients by last name"""
        pass
    
    @abstractmethod
    def find_by_insurance_provider(self, provider: str) -> List[Patient]:
        """Finds patients by insurance provider"""
        pass

  # doctor.py

  from typing import List, Optional
from abc import ABC, abstractmethod
from hospital.repositories.base import Repository
from hospital.entities.doctor import Doctor

class DoctorRepository(Repository[Doctor, str], ABC):
    """Doctor-specific repository interface"""
    
    @abstractmethod
    def find_by_specialization(self, specialization: str) -> List[Doctor]:
        """Finds doctors by specialization"""
        pass
    
    @abstractmethod
    def find_by_department(self, department: str) -> List[Doctor]:
        """Finds doctors by department"""
        pass

# appointment.py

from datetime import datetime
from typing import List, Optional
from abc import ABC, abstractmethod
from hospital.repositories.base import Repository
from hospital.entities.appointment import Appointment

class AppointmentRepository(Repository[Appointment, int], ABC):
    """Appointment-specific repository interface"""
    
    @abstractmethod
    def find_by_patient_id(self, patient_id: str) -> List[Appointment]:
        """Finds appointments by patient ID"""
        pass
    
    @abstractmethod
    def find_by_doctor_id(self, doctor_id: str) -> List[Appointment]:
        """Finds appointments by doctor ID"""
        pass
    
    @abstractmethod
    def find_by_date_range(self, start: datetime, end: datetime) -> List[Appointment]:
        """Finds appointments within a date range"""
        pass

 # medical_record.py

 from typing import List, Optional
from abc import ABC, abstractmethod
from hospital.repositories.base import Repository
from hospital.entities.medical_record import MedicalRecord

class MedicalRecordRepository(Repository[MedicalRecord, int], ABC):
    """Medical record-specific repository interface"""
    
    @abstractmethod
    def find_by_patient_id(self, patient_id: str) -> List[MedicalRecord]:
        """Finds medical records by patient ID"""
        pass
    
    @abstractmethod
    def find_by_diagnosis_containing(self, keyword: str) -> List[MedicalRecord]:
        """Finds medical records containing diagnosis keyword"""
        pass
