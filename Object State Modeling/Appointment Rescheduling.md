# Appointment Rescheduling

```mermaid

activityDiagram
    title Appointment Rescheduling
    swimlane Patient
    swimlane Receptionist

    Patient --> Receptionist: Request Reschedule
    Receptionist --> Receptionist: Check Availability
    Receptionist --> Patient: Confirm New Slot
```

**Stakeholders:** Patients, Receptionists.
**Concerns:** Minimizing no-shows.
**Decisions:** Auto-suggests alternative slots.
**Stakeholder Benefit:** Reduces administrative burden for staff.
