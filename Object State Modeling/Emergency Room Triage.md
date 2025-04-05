#  Emergency Room Triage

```mermaid

activityDiagram
    title ER Triage Workflow
    swimlane Triage Nurse
    swimlane ER Doctor

    Triage Nurse --> Triage Nurse: Assess Severity
    Triage Nurse --> ER Doctor: Critical? (Yes)
    ER Doctor --> ER Doctor: Immediate Treatment
    Triage Nurse --> Triage Nurse: Non-Critical? (No)
```
**Stakeholders:** ER Staff, Patients.
**Concerns:** Prioritization, life-threatening cases.
**Decisions:** Patients are routed based on severity.
**Stakeholder Benefit:** Ensures life-saving care is prioritized.
