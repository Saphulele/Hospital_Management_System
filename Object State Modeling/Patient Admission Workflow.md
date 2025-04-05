# Patient Admission Workflow

```mermaid

activityDiagram
    title Patient Admission Workflow
    swimlane Patient
    swimlane Front Desk
    swimlane Doctor
    swimlane Billing

    Patient --> Front Desk: Submit Details
    Front Desk --> Front Desk: Verify Insurance
    Front Desk --> Doctor: Assign Bed & Doctor
    Doctor --> Doctor: Perform Initial Assessment
    Doctor --> Billing: Generate Admission Invoice
    Billing --> Patient: Collect Payment
    Patient --> Front Desk: Complete Admission
    Front Desk --> End: Admission Confirmed
```

**Stakeholders:** Patients, Front Desk Staff, Doctors, Billing Department.
**Concerns:** Speed, accuracy, and compliance with hospital policies.
**Parallel Actions:** Insurance verification and bed assignment happen concurrently to reduce wait time.

**Decisions:** If insurance is invalid, the workflow branches to a manual review.

**Stakeholder Benefit:** Ensures patients are admitted quickly while maintaining billing accuracy.
