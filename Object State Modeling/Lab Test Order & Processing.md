#  Lab Test Order & Processing

```mermaid

activityDiagram
    title Lab Test Order & Processing
    swimlane Doctor
    swimlane Lab
    swimlane Patient

    Doctor --> Doctor: Order Test
    Doctor --> Lab: Send Test Request
    Lab --> Lab: Process Sample
    Lab --> Doctor: Send Results
    Doctor --> Patient: Discuss Results
```

**Stakeholders:** Doctors, Lab Technicians, Patients.
**Concerns:** Turnaround time, result accuracy.
**Decisions:** Lab checks sample viability; if compromised, workflow restarts.
**Stakeholder Benefit:** Automated result delivery reduces manual errors for lab staff.
