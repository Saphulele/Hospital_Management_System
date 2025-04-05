#  Discharge & Billing

```mermaid

activityDiagram
    title Discharge Workflow
    swimlane Doctor
    swimlane Nurse
    swimlane Billing

    Doctor --> Nurse: Approve Discharge
    Nurse --> Billing: Finalize Charges
    Billing --> Patient: Generate Bill
    Patient --> Billing: Make Payment
    Billing --> Nurse: Confirm Discharge
```

**Stakeholders:** Patients, Billing, Nurses.
**Concerns:** Timely discharge, accurate billing.
**Parallel Actions:** Bed cleanup and billing occur concurrently.
**Stakeholder Benefit:** Reduces discharge delays for patients.
