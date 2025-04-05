# Bed Object

```mermaid

stateDiagram-v2
    [*] --> Available
    Available --> Occupied: Patient admitted
    Occupied --> Reserved: Patient temporarily leaves (less than 24h)
    Occupied --> Maintenance: After patient discharge (requires cleaning)
    Reserved --> Occupied: Patient returns
    Reserved --> Available: Patient doesn't return (after 24h)
    Maintenance --> Available: Cleaning completed
    Maintenance --> OutOfService: Damage found
    OutOfService --> Available: Repairs completed

```
**Key States:** Available, Occupied, Reserved, Maintenance, OutOfService

**Transitions:** Tracks bed utilization and maintenance needs

# Functional Requirements Mapping:

**FR-501:** Bed allocation system

**FR-502:** Infection control procedures

**FR-503:** Facility maintenance tracking

**FR-504:** Temporary bed reservation
