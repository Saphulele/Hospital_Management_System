#  Inventory Replenishment

```mermaid

graph TD
    A[Pharmacy: Check Stock Levels] --> B{Low Stock?}
    B -->|Yes| C[Procurement: Place Order]
    B -->|No| F[End Process]
    C --> D[Procurement: Receive Shipment]
    D --> E[Pharmacy: Update Inventory]
    E --> F
```
**Stakeholders:** Pharmacy, Procurement.
**Concerns:** Stockouts, overstocking.
**Automated Triggers:** System alerts procurement at threshold.
**Stakeholder Benefit:** Prevents stockouts for critical medications.
