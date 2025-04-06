# Appointment Rescheduling

```mermaid

flowchart TD
    title[Appointment Rescheduling]
    
    subgraph Patient
        A[Patient requests reschedule]
    end
    
    subgraph Receptionist
        B[Check availability]
        C[Confirm new slot]
    end
    
    A --> B
    B --> C
    C --> D[Appointment rescheduled]
```

**Stakeholders:** Patients, Receptionists.
**Concerns:** Minimizing no-shows.
**Decisions:** Auto-suggests alternative slots.
**Stakeholder Benefit:** Reduces administrative burden for staff.
