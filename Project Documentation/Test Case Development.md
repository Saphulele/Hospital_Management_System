# Test Case Table

|Test Case ID    | Requirement ID | Description     | Steps          | Expected Results | Actual Results      |  Status(Pass/Fail)     |
|----------------|----------------|-----------------|----------------|------------------|---------------------|------------------------|
| Test Case-001  |     FR-001     |Patient registration with all mandatory fields filled                 |1. Enter valid name, contact information, and medical history. 2. Submit the form.                |A unique patient ID is generated, and the registration is successful.                  |                     |                        |
| Test Case-002  |     FR-002     |Patient registration with missing mandatory fields                1. Leave one mandatory field (e.g., medical history) blank. 2. Submit the form.|1. Leave one mandatory field (e.g., medical history) blank. 2. Submit the form.               | System displays an error message and does not allow submission.                 |                     |                        |
| Test Case-003  |     FR-003     |Book an appointment with real-time availability                 |1. Log in as a patient. 2. Select a doctor and available time slot. 3. Confirm the appointment.|Record is updated, and the change is logged with a timestamp and doctor’s name.                  |                     |                        |
| Test Case-004  |     FR-004     |Reschedule an appointment within 24 hours of the scheduled time                 | 1. Log in as a patient. 2. Select an existing appointment. 3. Reschedule to a new time slot.               | Appointment is rescheduled, and confirmation is sent via email/SMS.                |                     |                        |
| Test Case-005  |     FR-005     |Doctor views patient medical records                 |1. Log in as a doctor. 2. Search for a patient by ID or name. 3. Access the patient’s medical records.                |Patient records are displayed within 3 seconds.                 |                     |                        |
| Test Case-006  |     FR-006     |Doctor updates patient medical records                 | 1. Log in as a doctor. 2. Search for a patient. 3. Update the medical record and save.               | Record is updated, and the change is logged with a timestamp and doctor’s name.                 |                     |                        |
| Test Case-007  |     FR-007     |Doctor views daily schedule                 |1. Log in as a doctor. 2. Navigate to the schedule view.                | Daily schedule is displayed, including patient list and appointment times.                 |                     |                        |
| Test Case-008  |     FR-008     |System prevents overlapping appointments                 | 1. Log in as a doctor. 2. Attempt to schedule two appointments at the same time.               | System flags the overlap and prevents scheduling.                 |                     |                        |



# Non-Functional Test Scenarios

**1. Performance Test**
**Scenario:** Simulate 1,000 concurrent users accessing the patient portal to view medical records.

**Steps:**

Use a load testing tool to simulate 1,000 concurrent users.

Measure the response time for accessing medical records.

**Expected Result:** Response time ≤ 3 seconds for 95% of requests.

**2. Security Test**
**Scenario:** Verify encryption of sensitive data in transit and at rest.

**Steps:**

Use a network monitoring tool to capture data packets during transmission.

Inspect the database to ensure data is encrypted at rest.

**Expected Result:** All sensitive data is encrypted in transit and at rest.
