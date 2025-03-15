
# 1. Patient Registration
**Description:**
Allows patients to register in the system by providing personal details (name, contact information, and medical history). A unique patient ID is generated automatically.

**Preconditions:**

The patient is not already registered in the system.

The system is operational and accessible.

**Postconditions:**

A new patient record is created in the system.

A unique patient ID is generated and assigned to the patient.

**Basic Flow:**

Patient navigates to the registration page.

Patient enters personal details (name, contact information, and medical history).

System validates mandatory fields.

System generates a unique patient ID.

System saves the patient record.

System displays a confirmation message with the patient ID.

**Alternative Flows:**

**Alternative Flow 1:** Mandatory fields missing: If any mandatory field is empty, the system displays an error message and prompts the patient to fill in the missing details.

**Alternative Flow 2:** Duplicate registration: If the patient is already registered, the system displays an error message and redirects the patient to the login page.

# 2. Schedule Appointment
**Description:**
Allows patients to book, reschedule, or cancel appointments with doctors based on real-time availability.

**Preconditions:**

The patient is registered and logged into the system.

The doctor’s schedule is available in the system.

**Postconditions:**

An appointment is booked, rescheduled, or canceled.

The patient and doctor receive a confirmation notification.

**Basic Flow:**

Patient logs into the system and navigates to the appointment scheduling page.

Patient selects a doctor and views available time slots.

Patient selects a preferred time slot and confirms the appointment.

System checks for conflicts and books the appointment.

System sends a confirmation notification via email/SMS.

System updates the doctor’s schedule.

**Alternative Flows:**

**Alternative Flow 1:** No available slots: If no slots are available, the system suggests alternative dates/times.

**Alternative Flow 2:** Rescheduling: Patient selects an existing appointment and chooses a new time slot.

**Alternative Flow 3:** Cancellation: Patient cancels an appointment, and the system frees up the time slot.

# 3. Update Medical Records
**Description:**
Allows doctors to view and update patient medical records. All changes are logged with a timestamp and the doctor’s name.

**Preconditions:**

The doctor is logged into the system.

The patient’s medical record exists in the system.

**Postconditions:**

The patient’s medical record is updated.

A log entry is created with the timestamp and doctor’s name.

**Basic Flow:**

Doctor logs into the system and searches for the patient by ID or name.

System retrieves the patient’s medical record.

Doctor updates the medical record (e.g., adds diagnosis, prescriptions, or test results).

System validates the changes and saves the updated record.

System logs the update with a timestamp and doctor’s name.

**Alternative Flows:**

**Alternative Flow 1:** Invalid patient ID: If the patient ID is invalid, the system displays an error message.

**Alternative Flow 2:** Unauthorized access: If the doctor does not have permission to access the record, the system denies access.

# 4. Generate Bill
**Description:**
Generates bills for consultations, tests, and treatments. Patients can view and pay bills online.

**Preconditions:**

The consultation, test, or treatment is completed.

The patient’s record exists in the system.

**Postconditions:**

A bill is generated and linked to the patient’s record.

The patient receives a notification with the bill details.

**Basic Flow:**

System automatically generates a bill after a consultation, test, or treatment is completed.

System links the bill to the patient’s record.

Patient logs into the patient portal and views the bill.

Patient pays the bill online.

System updates the payment status and sends a receipt.

**Alternative Flows:**

**Alternative Flow 1:** Insurance claim: If the patient has insurance, the system processes the claim and updates the bill accordingly.

**Alternative Flow 2:** Payment failure: If the payment fails, the system notifies the patient and prompts them to retry.

# 5. Send Notifications
**Description:**
Sends notifications to patients for appointment reminders, test results, and billing updates.

**Preconditions:**

The event (e.g., appointment, test result, or bill) is triggered in the system.

The patient’s contact information is available.

**Postconditions:**

The notification is delivered to the patient via email/SMS.

The notification is logged in the system.

**Basic Flow:**

System detects an event (e.g., upcoming appointment, test result, or bill generation).

System prepares the notification content.

System sends the notification via email/SMS.

System logs the notification delivery.

**Alternative Flows:**

**Alternative Flow 1:** Notification failure: If the notification fails to deliver, the system retries or alerts the admin.

**Alternative Flow 2:** Patient preferences: If the patient has opted out of notifications, the system skips sending.

# 6. Secure Messaging
**Description:**
Provides a secure messaging system for doctors, nurses, and staff to communicate.

**Preconditions:**

The user (doctor, nurse, or staff) is logged into the system.

The recipient is available in the system.

**Postconditions:**

The message is delivered and stored securely.

The message is logged with a timestamp.

**Basic Flow:**

User logs into the system and navigates to the messaging feature.

User composes a message and selects a recipient.

System encrypts the message and sends it.

Recipient receives the message within 2 seconds.

System logs the message with a timestamp.

**Alternative Flows:**

**Alternative Flow 1:** Recipient unavailable: If the recipient is not available, the system stores the message and delivers it later.

**Alternative Flow 2:** Unauthorized access: If the user does not have permission to message the recipient, the system denies the request.

# 7. Manage Access Control
**Description:**
Allows administrators to configure role-based access control (RBAC) for all users.

**Preconditions:**

The admin is logged into the system.

The user roles and permissions are defined in the system.

**Postconditions:**

User roles and permissions are updated in the system.

Access control policies are enforced.

**Basic Flow:**

Admin logs into the system and navigates to the access control settings.

Admin selects a user and assigns/updates their role and permissions.

System validates the changes and updates the user’s access rights.

System enforces the new access control policies.

**Alternative Flows:**

**Alternative Flow 1:** Invalid role: If the role is invalid, the system displays an error message.

**Alternative Flow 2:** Unauthorized changes: If the admin does not have permission to modify access control, the system denies the request.

# 8. Emergency Override
**Description:**
Allows doctors to override appointment schedules in case of emergencies.

**Preconditions:**

The doctor is logged into the system.

An emergency situation is declared.

**Postconditions:**

The appointment schedule is updated.

Affected patients are notified.

**Basic Flow:**

Doctor logs into the system and marks an appointment as an emergency.

System reschedules other appointments automatically.

System notifies affected patients within 5 minutes.

System logs the emergency override.

**Alternative Flows:**

**Alternative Flow 1:** No available slots: If no slots are available, the system alerts the admin.

**Alternative Flow 2:** Patient refusal: If a patient refuses the rescheduled appointment, the system cancels the appointment.
