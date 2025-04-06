# Challenges in Choosing Granularity for States/Actions

When designing state diagrams (for object behavior) or activity diagrams (for process flow) in a Hospital Management System (HMS), selecting the right level of detail is crucial.

# Key Challenges:
**Too High-Level (Low Granularity):**

**Problem:** Missing critical transitions (e.g., skipping "Lab Test Pending" between "Doctor Consultation" and "Discharge").

**Impact:** Incomplete system logic, leading to errors.

# Example (State Diagram):

**Overly simplified:** Admitted → Discharged (missing intermediate states like In-Treatment, Test Scheduled).

**Too Detailed (High Granularity):**

**Problem:** Diagram becomes cluttered (e.g., modeling every minor step in "Patient Registration").

**Impact:** Hard to maintain/read; Agile teams may reject it as over-engineering.

# Example (Activity Diagram):

**Unnecessary steps:** Enter Name → Validate Name → Save Name → Enter DOB → Validate DOB → ….

**Balancing Readability & Precision:**

**Solution:** Focus on user goals (e.g., "Schedule Appointment" as one action vs. breaking into "Check Doctor Availability → Confirm Slot → Notify Patient").


| Challenge                          | Solution                                                                 |
|------------------------------------|--------------------------------------------------------------------------|
| Diagrams seen as overhead         | Create just enough diagrams (e.g., only for complex workflows like "Emergency Patient Admission"). |
| User stories lack technical detail | Use diagrams to clarify acceptance criteria (e.g., state transitions for "Patient Discharge"). |
| Frequent changes in Agile sprints  | Keep diagrams lightweight (e.g., sketch on whiteboard, not UML-heavy).  |
