```mermaid
classDiagram
    %% Person Base Class
    class Person {
        <<abstract>>
        -id: String
        -name: String
        -contactInfo: String
        +getDetails() String
    }
    %% Patient Class
    class Patient {
        -patientId: String
        -medicalHistory: List~MedicalRecord~
        -currentMedications: List~String~
        +requestAppointment()
        +viewMedicalHistory()
    }
    %% Staff Hierarchy
    class Staff {
        <<abstract>>
        -staffId: String
        -department: String
        -joinDate: Date
    }
    class Doctor {
        -specialization: String
        -qualifications: List~String~
        +prescribeMedication()
        +diagnosePatient()
    }
    class Nurse {
        -shift: String
        +assistDoctor()
        +monitorPatient()
    }
    class AdministrativeStaff {
        -role: String
        +manageAppointments()
        +processBilling()
    }
    %% Hospital Components
    class Department {
        -deptId: String
        -name: String
        -head: Doctor
        +addStaff()
    }
    class Appointment {
        -appointmentId: String
        -dateTime: DateTime
        -status: String
        +reschedule()
        +cancel()
    }
    class MedicalRecord {
        -recordId: String
        -diagnosis: String
        -treatment: String
        +updateRecord()
    }
    class Hospital {
        -name: String
        -departments: List~Department~
        +admitPatient()
        +dischargePatient()
    }
    %% Relationships
    Person <|-- Patient
    Person <|-- Staff
    Staff <|-- Doctor
    Staff <|-- Nurse
    Staff <|-- AdministrativeStaff
    Hospital "1" *-- "1..*" Department : contains
    Department "1" o-- "0..*" Staff : employs
    Patient "1" -- "0..*" Appointment : schedules
    Doctor "1" -- "0..*" Appointment : handles
    Patient "1" -- "1..*" MedicalRecord : has
    Doctor "1" -- "0..*" MedicalRecord : updates
    %% Notes
    note for Person "Base class for all human entities in the system"
    note for Hospital "Singleton pattern recommended for Hospital class"
    note for Department "Aggregation relationship with Staff (Staff can exist without Department)"
```

# Key Design Decisions:
**Inheritance Hierarchy:**

Used abstract Person class as base for both patients and staff

Created specialized staff types (Doctor, Nurse, Administrative) through inheritance

**Composition vs Aggregation:**

Hospital-Department is composition (departments can't exist without hospital)

Department-Staff is aggregation (staff can exist without department)

**Multiplicity:**

A patient can have multiple appointments (0..*) but each appointment belongs to one patient

Doctors can update multiple medical records but each record is tied to one patient

**Abstract Classes:**

Marked Person and Staff as abstract to prevent direct instantiation

Used UML stereotypes (<<abstract>>) for clarity

**Collections:**

Used List notation (List~Type~) for multi-valued attributes

**Notes:**

Added explanatory notes for complex relationships

Suggested Singleton pattern for Hospital class
