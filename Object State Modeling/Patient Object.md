# Patient Object

```mermaid

stateDiagram-v2
    [*] --> Registered
    Registered --> Active: Patient checks in (valid registration)
    Active --> InTreatment: Doctor begins consultation
    InTreatment --> Recovering: Treatment completed
    Recovering --> Discharged: Recovery confirmed
    Discharged --> [*]
    
    Registered --> Archived: Account inactive (1 year)
    Active --> Archived: No show for appointment
    Recovering --> Archived: Lost to follow-up
    Discharged --> Archived: After 5 years
    
    InTreatment --> Emergency: Critical condition
    Emergency --> ICU: Requires intensive care
    ICU --> Recovering: Stable
    ICU --> Deceased: Patient passes away
    Emergency --> Deceased: Resuscitation fails
    Deceased --> [*]
```

**Key States:** Registered, Active, InTreatment, Recovering, Discharged, Emergency, ICU, Deceased, Archived

**Transitions:** Models the complete patient journey from registration through treatment to final disposition

# Functional Requirements Mapping:

**FR-101:** Patient registration system

**FR-102:** Treatment workflow management

**FR-103:** Emergency handling procedures

**FR-104:** Patient record archiving policy
