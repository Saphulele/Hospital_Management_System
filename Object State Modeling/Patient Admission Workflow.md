# Patient Admission Workflow

activityDiagram
    title Patient Admission Workflow
    swimlane Patient
    swimlane Front Desk
    swimlane Doctor
    swimlane Billing

    Patient --> Front Desk: Submit Details
    Front Desk --> Front Desk: Verify Insurance
    Front Desk --> Doctor: Assign Bed & Doctor
    Doctor --> Doctor: Perform Initial Assessment
    Doctor --> Billing: Generate Admission Invoice
    Billing --> Patient: Collect Payment
    Patient --> Front Desk: Complete Admission
    Front Desk --> End: Admission Confirmed
