# Medical Record Object

```mermaid

stateDiagram-v2
    [*] --> Draft
    Draft --> InReview: Doctor completes entry
    note right of InReview
        Required: all fields completed
    end note
    InReview --> Approved: Verified by supervisor
    InReview --> CorrectionNeeded: Errors found
    CorrectionNeeded --> Draft: Doctor updates
    Approved --> Archived: After patient discharge
    note right of Archived
        Required: all treatments complete
    end note
    Archived --> RestrictedAccess: After 7 years
    RestrictedAccess --> [*]
    
    Approved --> Amended: New information added
    Amended --> InReview: Resubmitted for verification
```

**Key States:** Draft, InReview, Approved, CorrectionNeeded, Archived, RestrictedAccess, Amended

**Transitions:** Ensures proper documentation workflow with verification steps

# Functional Requirements Mapping:

**FR-301:** Electronic health record management

**FR-302:** Record verification process

**FR-303:** Data retention policy

**FR-304:** Record amendment procedure
