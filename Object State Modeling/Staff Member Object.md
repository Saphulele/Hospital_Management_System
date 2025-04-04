# Staff Member Object

```mermaid

stateDiagram-v2
    [*] --> Candidate
    Candidate --> Onboarding: Hiring approved\n(guard: background check)
    Onboarding --> Active: Training completed
    Active --> OnLeave: Leave approved
    OnLeave --> Active: Leave period ends
    Active --> Suspended: Disciplinary action
    Suspended --> Active: Issues resolved
    Suspended --> Terminated: Severity level 3
    Active --> Terminated: Resignation/retirement
    Terminated --> [*]
    
    Onboarding --> Rejected: Failed requirements\n(guard: failed training)
    Active --> InternalInvestigation: Complaint received\n(guard: credible evidence)
    InternalInvestigation --> Active: Cleared
    InternalInvestigation --> Suspended: Wrongdoing found
```

**Key States:** Candidate, Onboarding, Active, OnLeave, Suspended, Terminated, Rejected, InternalInvestigation

**Transitions:** Complete HR lifecycle from hiring to termination

# Functional Requirements Mapping:

**FR-801:** Staff recruitment process

**FR-802:** Employee status tracking

**FR-803:** Disciplinary procedures

**FR-804:** Leave management
