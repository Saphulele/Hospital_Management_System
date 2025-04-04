# Billing Invoice Object

stateDiagram-v2
    [*] --> Generated
    Generated --> Pending: Sent to patient
    Pending --> PartialPayment: Initial payment\n(guard: >minimum amount)
    PartialPayment --> Paid: Balance cleared
    Pending --> Paid: Full payment
    Pending --> Overdue: Past due date\n(guard: >30 days)
    Overdue --> Collections: Further overdue\n(guard: >90 days)
    Overdue --> Paid: Late payment
    Collections --> Paid: Debt settled
    Collections --> WrittenOff: Uncollectible\n(guard: management approval)
    Paid --> [*]
    WrittenOff --> [*]

 **Key States:** Generated, Pending, PartialPayment, Paid, Overdue, Collections, WrittenOff

**Transitions:** Financial workflow with payment tracking and collection process

# Functional Requirements Mapping:

**FR-701:** Invoice generation

**FR-702:** Payment processing

**FR-703:** Overdue account handling

**FR-704:** Financial reporting
