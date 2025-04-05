#  Surgery Scheduling

```mermaid

activityDiagram
    title Surgery Scheduling
    swimlane Surgeon
    swimlane OR Staff
    swimlane Nurse

    Surgeon --> OR Staff: Request Surgery Slot
    OR Staff --> OR Staff: Check OR Availability
    OR Staff --> Nurse: Prepare Patient
    Nurse --> Surgeon: Confirm Readiness
```

**Stakeholders:** Surgeons, Nurses, OR Staff.
**Concerns:** Resource conflicts, emergency prioritization.
**Decisions:** Emergency cases trigger rescheduling of elective surgeries.
**Stakeholder Benefit:** Dynamic scheduling meets surgeon and patient needs.
