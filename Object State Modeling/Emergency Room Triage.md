#  Emergency Room Triage

```mermaid

flowchart TD
    start[Patient Arrives]
    
    subgraph "Triage Nurse"
        assess[Assess Severity]
        decision{Critical?}
        queue[Place in Queue by Priority]
    end
    
    subgraph "ER Doctor"
        immediate[Immediate Treatment]
        routine[Routine Treatment]
    end
    
    start --> assess
    assess --> decision
    decision -->|Yes| immediate
    decision -->|No| queue
    queue --> routine
```
**Stakeholders:** ER Staff, Patients.
**Concerns:** Prioritization, life-threatening cases.
**Decisions:** Patients are routed based on severity.
**Stakeholder Benefit:** Ensures life-saving care is prioritized.
