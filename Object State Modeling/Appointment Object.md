# Appointment Object

```mermaid
   stateDiagram-v2
    [*] --> Scheduled
    Scheduled --> Confirmed: Patient confirms
    note right of Confirmed
        Must confirm within 48 hours
    end note
    Scheduled --> Cancelled: Patient cancels
    Confirmed --> CheckedIn: Patient arrives
    CheckedIn --> Completed: Consultation ends
    CheckedIn --> NoShow: Patient doesn't arrive
    note right of NoShow
        After 15 min past appointment time
    end note
    Scheduled --> NoShow: Patient doesn't confirm
    Completed --> [*]
    Cancelled --> [*]
    NoShow --> [*]
    Confirmed --> Rescheduled: Patient requests change
    note right of Rescheduled
        Must be >24h before appointment
    end note
    Rescheduled --> Scheduled: New time allocated
```

**Key States:** Scheduled, Confirmed, CheckedIn, Completed, Cancelled, NoShow, Rescheduled

**Transitions:** Captures the lifecycle of appointments including confirmation, execution, and exceptions

# Functional Requirements Mapping:

**FR-201:** Appointment scheduling system

**FR-202:** Patient notification system

**FR-203:** No-show tracking

**FR-204:** Appointment modification workflow
