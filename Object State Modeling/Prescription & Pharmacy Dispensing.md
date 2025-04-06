# Prescription & Pharmacy Dispensing

```mermaid

sequenceDiagram
    participant D as Doctor
    participant Ph as Pharmacy
    participant Pa as Patient
    
    D->>D: Prescribe Medication
    D->>Ph: Send E-Prescription
    Ph->>Ph: Check Stock & Allergies
    Ph->>Pa: Dispense Medication
```

**Stakeholders:** Doctors, Pharmacists, Patients.
**Concerns:** Drug availability, allergy checks.
**Parallel Actions:** Stock and allergy checks occur simultaneously.
**Stakeholder Benefit:** Prevents dispensing errors, meeting patient safety needs.
