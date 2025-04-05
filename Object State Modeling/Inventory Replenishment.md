#  Inventory Replenishment

```mermaid

activityDiagram
    title Inventory Replenishment
    swimlane Pharmacy
    swimlane Procurement

    Pharmacy --> Pharmacy: Check Stock Levels
    Pharmacy --> Procurement: Low Stock? (Yes)
    Procurement --> Procurement: Place Order
    Procurement --> Pharmacy: Update Inventory
```
**Stakeholders:** Pharmacy, Procurement.
**Concerns:** Stockouts, overstocking.
**Automated Triggers:** System alerts procurement at threshold.
**Stakeholder Benefit:** Prevents stockouts for critical medications.
