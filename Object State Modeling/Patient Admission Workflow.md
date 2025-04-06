# Patient Admission Workflow

```mermaid

sequenceDiagram
    participant P as Patient
    participant F as Front Desk
    participant D as Doctor
    participant B as Billing
    
    P->>F: Submit Details
    F->>F: Verify Insurance
    F->>D: Assign Bed & Doctor
    D->>D: Perform Initial Assessment
    D->>B: Generate Admission Invoice
    B->>P: Collect Payment
    P->>F: Complete Admission
    F->>F: Admission Confirmed
```

**Stakeholders:** Patients, Front Desk Staff, Doctors, Billing Department.
**Concerns:** Speed, accuracy, and compliance with hospital policies.
**Parallel Actions:** Insurance verification and bed assignment happen concurrently to reduce wait time.

**Decisions:** If insurance is invalid, the workflow branches to a manual review.

**Stakeholder Benefit:** Ensures patients are admitted quickly while maintaining billing accuracy.
