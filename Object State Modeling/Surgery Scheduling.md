#  Surgery Scheduling

```mermaid

sequenceDiagram
    participant S as Surgeon
    participant OR as OR Staff
    participant N as Nurse
    
    S->>OR: Request Surgery Slot
    OR->>OR: Check OR Availability
    OR->>N: Prepare Patient
    N->>S: Confirm Readiness
```

**Stakeholders:** Surgeons, Nurses, OR Staff.
**Concerns:** Resource conflicts, emergency prioritization.
**Decisions:** Emergency cases trigger rescheduling of elective surgeries.
**Stakeholder Benefit:** Dynamic scheduling meets surgeon and patient needs.
