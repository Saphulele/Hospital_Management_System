graph TD

    %% Define actors
    subgraph Actors
        Patient
        Doctor
        Nurse
        Admin
        BillingStaff
        System
    end

    %% Define use cases
    subgraph UseCases
        PatientRegistration[Patient Registration]
        ScheduleAppointment[Schedule Appointment]
        AccessPatientPortal[Access Patient Portal]
        PayBill[Pay Bill]
        UpdateMedicalRecords[Update Medical Records]
        ViewDoctorSchedule[View Doctor Schedule]
        EmergencyOverride[Emergency Override]
        SecureMessaging[Secure Messaging]
        ManageAccessControl[Manage Access Control]
        GenerateBill[Generate Bill]
        SendNotifications[Send Notifications]
        LogUpdates[Log Updates]
    end

    %% Relationships
    Patient -->|Register| PatientRegistration
    Patient -->|Schedule Appointment| ScheduleAppointment
    Patient -->|Access Patient Portal| AccessPatientPortal
    Patient -->|Pay Bill| PayBill
    Doctor -->|Update Medical Records| UpdateMedicalRecords
    Doctor -->|View Doctor Schedule| ViewDoctorSchedule
    Doctor -->|Emergency Override| EmergencyOverride
    Nurse -->|Secure Messaging| SecureMessaging
    Admin -->|Manage Access Control| ManageAccessControl
    BillingStaff -->|Generate Bill| GenerateBill
    System -->|Send Notifications| SendNotifications
    System -->|Log Updates| LogUpdates
