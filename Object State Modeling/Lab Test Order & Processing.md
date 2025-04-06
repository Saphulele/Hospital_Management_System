#  Lab Test Order & Processing

```mermaid

sequenceDiagram
    participant D as Doctor
    participant L as Lab
    participant P as Patient
    
    D->>D: Order Test
    D->>L: Send Test Request
    L->>L: Process Sample
    L->>D: Send Results
    D->>P: Discuss Results
```

**Stakeholders:** Doctors, Lab Technicians, Patients.
**Concerns:** Turnaround time, result accuracy.
**Decisions:** Lab checks sample viability; if compromised, workflow restarts.
**Stakeholder Benefit:** Automated result delivery reduces manual errors for lab staff.
