#  Discharge & Billing

```mermaid

flowchart TD
    title[Discharge Workflow]
    
    subgraph Doctor
        A[Approve Discharge]
    end
    
    subgraph Nurse
        B[Process Discharge]
        F[Complete Discharge]
    end
    
    subgraph Billing
        C[Finalize Charges]
        D[Generate Bill]
        E[Process Payment]
    end
    
    subgraph Patient
        P[Make Payment]
    end
    
    A --> B
    B --> C
    C --> D
    D --> P
    P --> E
    E --> F
```

**Stakeholders:** Patients, Billing, Nurses.
**Concerns:** Timely discharge, accurate billing.
**Parallel Actions:** Bed cleanup and billing occur concurrently.
**Stakeholder Benefit:** Reduces discharge delays for patients.
