# System Context Diagram

```mermaid
  %% Hospital Management System - Context Diagram
  graph TD
    A[Hospital Management System] 
    B[Admin] 
    C[Doctor] 
    D[Nurse] 
    E[Patient] 
    F[External Systems] 
    G[Insurance Provider]
    
    A -->|Manages Data| B[Admin]
    A -->|Manages Appointments & Medical Records| C[Doctor]
    A -->|Assigns Tasks & Manages Patient Care| D[Nurse]
    A -->|Accesses Medical Records & Makes Appointments| E[Patient]
    A -->|Integrates with| F[External Systems]
    A -->|Handles Insurance Claims| G[Insurance Provider]
    
    style A fill:#f9f,stroke:#333,stroke-width:4px
    style B fill:#add8e6,stroke:#333,stroke-width:2px
    style C fill:#ffcc99,stroke:#333,stroke-width:2px
    style D fill:#f0e68c,stroke:#333,stroke-width:2px
    style E fill:#90ee90,stroke:#333,stroke-width:2px
    style F fill:#ffb6c1,stroke:#333,stroke-width:2px
    style G fill:#ffb6c1,stroke:#333,stroke-width:2px

```
# System Container Diagram

```mermaid

  %% Hospital Management System - Container Diagram
  graph TD
    A[Hospital Management System] --> B[Web Application]
    A[Hospital Management System] --> C[Mobile Application]
    A[Hospital Management System] --> D[Database]
    A[Hospital Management System] --> E[Payment Gateway]
    A[Hospital Management System] --> F[Authentication Service]
    
    B -->|User Interface| G[Frontend: React]
    B -->|API Requests| H[Backend: Node.js]
    
    C -->|User Interface| I[Mobile Frontend: Flutter]
    C -->|API Requests| J[Mobile Backend: Node.js]

    D --> K[SQL Database]
    E --> L[Payment API Integration]
    F --> M[OAuth 2.0 Service]
    
    G --> H
    I --> J
    H --> D
    J --> D
    
    style A fill:#f9f,stroke:#333,stroke-width:4px
    style B fill:#add8e6,stroke:#333,stroke-width:2px
    style C fill:#ffcc99,stroke:#333,stroke-width:2px
    style D fill:#f0e68c,stroke:#333,stroke-width:2px
    style E fill:#90ee90,stroke:#333,stroke-width:2px
    style F fill:#ffb6c1,stroke:#333,stroke-width:2px
    style G fill:#ffebcd,stroke:#333,stroke-width:2px
    style H fill:#ffebcd,stroke:#333,stroke-width:2px
    style I fill:#ffebcd,stroke:#333,stroke-width:2px
    style J fill:#ffebcd,stroke:#333,stroke-width:2px
    style K fill:#f0e68c,stroke:#333,stroke-width:2px
    style L fill:#ffcc99,stroke:#333,stroke-width:2px
    style M fill:#ffb6c1,stroke:#333,stroke-width:2px

```

# System Component Diagram

```mermaid

  %% Hospital Management System - Component Diagram
  graph TD
    A[Hospital Management System]
    
    subgraph Web Layer
      B[Web Frontend] --> C[Web Backend]
    end
    
    subgraph Mobile Layer
      D[Mobile Frontend] --> E[Mobile Backend]
    end

    subgraph Data Layer
      F[Database] 
      G[Patient Records Service] 
      H[Appointment Management Service] 
      I[Payment Service] 
    end

    subgraph External Systems
      J[External Payment Gateway] 
      K[Insurance API] 
      L[Email Notification Service]
    end

    A --> B
    A --> D
    A --> F
    A --> G
    A --> H
    A --> I
    A --> J
    A --> K
    A --> L

    C --> F
    C --> G
    C --> H
    C --> I

    E --> F
    E --> G
    E --> H
    E --> I

    G --> F
    H --> F
    I --> F
    J --> I
    K --> F
    L --> I

    style A fill:#f9f,stroke:#333,stroke-width:4px
    style B fill:#add8e6,stroke:#333,stroke-width:2px
    style C fill:#ffebcd,stroke:#333,stroke-width:2px
    style D fill:#ffcc99,stroke:#333,stroke-width:2px
    style E fill:#ffcc99,stroke:#333,stroke-width:2px
    style F fill:#f0e68c,stroke:#333,stroke-width:2px
    style G fill:#f0e68c,stroke:#333,stroke-width:2px
    style H fill:#f0e68c,stroke:#333,stroke-width:2px
    style I fill:#f0e68c,stroke:#333,stroke-width:2px
    style J fill:#ffb6c1,stroke:#333,stroke-width:2px
    style K fill:#ffb6c1,stroke:#333,stroke-width:2px
    style L fill:#ffb6c1,stroke:#333,stroke-width:2px

```

# System Component Diagram

```mermaid

classDiagram
    class Patient {
        +String patientId
        +String name
        +String dob
        +String gender
        +String contactInfo
        +String address
        +String medicalHistory
        +String allergies
        +registerPatient()
        +updatePatientInfo()
    }

    class Doctor {
        +String doctorId
        +String name
        +String specialty
        +String contactInfo
        +String schedule
        +String department
        +addDoctor()
        +updateDoctorSchedule()
    }

    class Appointment {
        +String appointmentId
        +String date
        +String time
        +String status
        +String doctorId
        +String patientId
        +scheduleAppointment()
        +cancelAppointment()
    }

    class Prescription {
        +String prescriptionId
        +String patientId
        +String doctorId
        +String medicationDetails
        +String dosage
        +generatePrescription()
    }

    class Bill {
        +String billId
        +String patientId
        +Double amount
        +String paymentStatus
        +generateBill()
        +updateBillStatus()
    }

    class Ward {
        +String wardId
        +String wardName
        +String capacity
        +String availableBeds
        +String department
        +assignPatientToWard()
        +dischargePatient()
    }

    class Hospital {
        +String hospitalId
        +String name
        +String address
        +String contactInfo
        +addPatient()
        +assignDoctor()
        +manageAppointments()
        +processBilling()
    }

    Patient "1" --> "*" Appointment : has
    Patient "1" --> "*" Bill : has
    Patient "1" --> "1" Prescription : receives
    Doctor "1" --> "*" Appointment : handles
    Doctor "1" --> "*" Prescription : writes
    Hospital "1" --> "*" Patient : manages
    Hospital "1" --> "*" Doctor : manages
    Hospital "1" --> "*" Ward : manages
    Ward "1" --> "*" Patient : accommodates
    Hospital "1" --> "*" Bill : processes

