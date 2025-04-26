# Patient Repository Tests

## test_patient_repository.py

import pytest
from models.patient import Patient
from repositories.inmemory.inmemory_patient_repository import InMemoryPatientRepository


@pytest.fixture
def repository():
    return InMemoryPatientRepository()


@pytest.fixture
def sample_patient():
    return Patient(id="123", name="John Doe", age=30, gender="Male")


def test_save_and_find_by_id(repository, sample_patient):
    repository.save(sample_patient)
    found = repository.find_by_id("123")
    assert found == sample_patient


def test_find_by_id_not_found(repository):
    assert repository.find_by_id("999") is None


def test_find_all(repository, sample_patient):
    repository.save(sample_patient)
    patients = repository.find_all()
    assert len(patients) == 1
    assert patients[0] == sample_patient


def test_delete(repository, sample_patient):
    repository.save(sample_patient)
    repository.delete("123")
    assert repository.find_by_id("123") is None


def test_update(repository, sample_patient):
    repository.save(sample_patient)
    updated_patient = Patient(id="123", name="Jane Doe", age=28, gender="Female")
    repository.update(updated_patient)
    assert repository.find_by_id("123").name == "Jane Doe"

# Doctor Repository Tests

## test_doctor_repository.py

import pytest
from models.doctor import Doctor
from repositories.inmemory.inmemory_doctor_repository import InMemoryDoctorRepository


@pytest.fixture
def repository():
    return InMemoryDoctorRepository()


@pytest.fixture
def sample_doctor():
    return Doctor(id="456", name="Dr. Smith", specialization="Cardiology")


def test_save_and_find_by_id(repository, sample_doctor):
    repository.save(sample_doctor)
    found = repository.find_by_id("456")
    assert found == sample_doctor


def test_find_by_specialization(repository, sample_doctor):
    repository.save(sample_doctor)
    cardiologists = repository.find_by_specialization("Cardiology")
    assert len(cardiologists) == 1
    assert cardiologists[0] == sample_doctor


def test_find_by_specialization_not_found(repository, sample_doctor):
    repository.save(sample_doctor)
    neurologists = repository.find_by_specialization("Neurology")
    assert len(neurologists) == 0


def test_update(repository, sample_doctor):
    repository.save(sample_doctor)
    updated_doctor = Doctor(id="456", name="Dr. Johnson", specialization="Cardiology")
    repository.update(updated_doctor)
    assert repository.find_by_id("456").name == "Dr. Johnson"

# Appointment Repository Tests

## test_appointment_repository.py

import pytest
from datetime import datetime
from models.appointment import Appointment
from repositories.inmemory.inmemory_appointment_repository import InMemoryAppointmentRepository


@pytest.fixture
def repository():
    return InMemoryAppointmentRepository()


@pytest.fixture
def sample_appointment():
    return Appointment(
        id="789",
        patient_id="123",
        doctor_id="456",
        date=datetime(2023, 6, 15, 14, 30),
        reason="Annual checkup"
    )


def test_save_and_find_by_id(repository, sample_appointment):
    repository.save(sample_appointment)
    found = repository.find_by_id("789")
    assert found == sample_appointment


def test_find_by_patient_id(repository, sample_appointment):
    repository.save(sample_appointment)
    appointments = repository.find_by_patient_id("123")
    assert len(appointments) == 1
    assert appointments[0] == sample_appointment


def test_find_by_doctor_id(repository, sample_appointment):
    repository.save(sample_appointment)
    appointments = repository.find_by_doctor_id("456")
    assert len(appointments) == 1
    assert appointments[0] == sample_appointment


def test_update(repository, sample_appointment):
    repository.save(sample_appointment)
    updated_appointment = Appointment(
        id="789",
        patient_id="123",
        doctor_id="456",
        date=datetime(2023, 6, 16, 14, 30),
        reason="Follow-up"
    )
    repository.update(updated_appointment)
    assert repository.find_by_id("789").reason == "Follow-up"
