# Hospital Management System - Domain Model

| Entity          | Attributes                                | Methods                                  | Relationships                     | Business Rules                                                                 |
|-----------------|-------------------------------------------|------------------------------------------|-----------------------------------|--------------------------------------------------------------------------------|
| **Patient**     | `patientId`, `name`, `dob`, `contact`, `medicalHistory`, `accountStatus` | `register()`, `updateInfo()`, `viewAppointments()` | `Appointment`, `MedicalRecord`, `Billing` | Only **one active** appointment per `Doctor`.<br> Unpaid bills >60 days suspend account. |
| **Doctor**      | `doctorId`, `name`, `specialization`, `contact`, `schedule`, `maxDailyAppointments` | `viewSchedule()`, `prescribeMedication()`, `diagnose()` | `Appointment`, `Prescription` | Max **20 appointments/day**.<br> No overlapping appointments. |
| **Appointment** | `appointmentId`, `dateTime`, `status`, `reason`, `isActive` | `schedule()`, `cancel()`, `reschedule()` | `Patient`, `Doctor`, `Room` | Unique active slot per `Patient`-`Doctor`.<br> No overlaps for `Doctor`/`Room`. |
| **MedicalRecord** | `recordId`, `diagnosis`, `treatment`, `prescriptions`, `notes`, `isArchived` | `addDiagnosis()`, `updateTreatment()` | `Patient`, `Doctor` | **Permanently archived** (no deletion). |
| **Prescription** | `prescriptionId`, `medication`, `dosage`, `instructions`, `issueDate`, `expiryDate` | `issue()`, `refill()`, `verify()` | `Doctor`, `Patient`, `Appointment` | Requires valid `Appointment`.<br> Expires in **30 days**. |
| **Billing**     | `billId`, `amount`, `dueDate`, `status`, `services` | `generateBill()`, `processPayment()` | `Patient`, `Appointment` | Unpaid bills >60 days suspend `Patient`. |
| **Room**        | `roomId`, `type`, `status`, `capacity`   | `assignPatient()`, `release()`          | `Patient`, `Appointment` | Assigned by **condition** (e.g., ICU).<br> No overlaps for `Room`. |
