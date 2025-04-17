# Creational Design Patterns Implementation

| Pattern         | When to Use | Example Implementation | Justification |
|-----------------|-------------|------------------------|---------------|
| **Simple Factory** | Centralized object creation | `PatientFactory` creates `Inpatient`, `Outpatient`, or `EmergencyPatient` | Used to simplify patient type creation with a single factory method |
| **Factory Method** | Delegate instantiation to subclasses | `ReportGenerator` with `RadiologyReportGenerator` and `PathologyReportGenerator` subclasses | Allows different departments to implement their own report generation |
| **Abstract Factory** | Create families of related objects | `WardFactory` with `ICUWardFactory` and `GeneralWardFactory` implementations | Ensures compatible beds and equipment are created for each ward type |
| **Builder** | Construct complex objects step-by-step | `PrescriptionBuilder` with methods like `add_medication()` and `set_duration()` | Handles complex prescription creation with many optional fields |
| **Prototype** | Clone existing objects to avoid costly initialization | `MedicalTest` with cloneable prototypes for blood tests and MRI scans | Avoids reconfiguring standard test procedures from scratch |
| **Singleton** | Ensure one instance globally | `HospitalInformationSystem` managing all patient and staff records | Prevents duplicate systems and maintains data consistency |
