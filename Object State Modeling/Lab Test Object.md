# Lab Test Object

```mermaid
stateDiagram-v2
    [*] --> Ordered
    Ordered --> Collected: Sample taken\n(guard: patient prepared)
    Collected --> InProgress: Lab receives
    InProgress --> Completed: Results ready
    Completed --> Verified: Doctor reviews
    Verified --> Archived: After 30 days
    Collected --> Rejected: Sample inadequate
    Rejected --> Ordered: New sample needed
    Archived --> [*]
    
    InProgress --> CriticalAlert: Abnormal results\n(guard: life-threatening)
    CriticalAlert --> DoctorNotified: Immediate contact
    DoctorNotified --> Completed: Response received
```

**Key States:** Ordered, Collected, InProgress, Completed, Verified, Archived, Rejected, CriticalAlert, DoctorNotified

**Transitions:** Laboratory workflow with quality control and emergency handling

# Functional Requirements Mapping:

**FR-601:** Test ordering system

**FR-602:** Sample handling procedures

**FR-603:** Critical result notification

**FR-604:** Test result verification
