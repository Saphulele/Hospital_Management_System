# Billing Invoice Object

```mermaid

stateDiagram-v2
    [*] --> Generated
    Generated --> Pending: Sent to patient
    Pending --> PartialPayment: Initial payment
    note right of PartialPayment
        Requires > minimum amount
    end note
    PartialPayment --> Paid: Balance cleared
    Pending --> Paid: Full payment
    Pending --> Overdue: Past due date
    note right of Overdue
        After 30+ days without payment
    end note
    Overdue --> Collections: Further overdue
    note right of Collections
        After 90+ days without payment
    end note
    Overdue --> Paid: Late payment
    Collections --> Paid: Debt settled
    Collections --> WrittenOff: Uncollectible
    note right of WrittenOff
        Requires management approval
    end note
    Paid --> [*]
    WrittenOff --> [*]
```

 **Key States:** Generated, Pending, PartialPayment, Paid, Overdue, Collections, WrittenOff

**Transitions:** Financial workflow with payment tracking and collection process

# Functional Requirements Mapping:

**FR-701:** Invoice generation

**FR-702:** Payment processing

**FR-703:** Overdue account handling

**FR-704:** Financial reporting
