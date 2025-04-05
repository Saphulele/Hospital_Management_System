# Prescription & Pharmacy Dispensing

```mermaid

activityDiagram
    title Prescription Workflow
    swimlane Doctor
    swimlane Pharmacy
    swimlane Patient

    Doctor --> Doctor: Prescribe Medication
    Doctor --> Pharmacy: Send E-Prescription
    Pharmacy --> Pharmacy: Check Stock & Allergies
    Pharmacy --> Patient: Dispense Medication
```

**Stakeholders:** Doctors, Pharmacists, Patients.
**Concerns:** Drug availability, allergy checks.
**Parallel Actions:** Stock and allergy checks occur simultaneously.
**Stakeholder Benefit:** Prevents dispensing errors, meeting patient safety needs.
