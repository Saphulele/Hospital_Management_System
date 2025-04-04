# Prescription Object
```mermaid

stateDiagram-v2
    [*] --> Created
    Created --> Verified: Pharmacist checks
    note right of Verified
        Required: valid doctor ID
    end note
    Verified --> Filled: Medication dispensed
    Filled --> Collected: Patient receives
    Filled --> Expired: Not collected in 7 days
    Verified --> Rejected: Interaction detected
    note right of Rejected
        Based on allergy check
    end note
    Rejected --> Modified: Doctor updates
    Modified --> Verified
    Collected --> [*]
    Expired --> [*]
    Rejected --> [*]
```
**Key States:** Created, Verified, Filled, Collected, Rejected, Modified, Expired

**Transitions:** Medication dispensing workflow with safety checks

# Functional Requirements Mapping:

**FR-401:** Prescription creation

**FR-402:** Drug interaction checking

**FR-403:** Dispensing workflow

**FR-404:** Prescription expiration handling
