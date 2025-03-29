# Kanban Board Definition
A Kanban board is a visual project management tool that helps teams track work as it moves through different stages of a workflow. It uses columns (like "To Do," "In Progress," "Done") and cards (representing tasks) 
to provide real-time visibility into work status, identify bottlenecks, and improve efficiency.

# Kanban Board for a Hospital Management System
# 1. Visualizing Workflow
The board is divided into columns representing different stages of task completion:

**Backlog (Pending Requests):** New patient admissions, appointment requests, lab test orders.

**To Do (Scheduled):** Tasks approved and ready for processing (e.g., scheduled surgeries, diagnostic tests).

**In Progress (Active Work):** Tasks being handled (e.g., doctors reviewing patient records, nurses administering treatment).

**Review (Quality Check):** Tasks needing verification (e.g., lab results validation, discharge summaries).

**Done (Completed):** Finished tasks (e.g., discharged patients, processed billing).

**Example:** A patient's lab test request moves from Backlog → To Do (scheduled) → In Progress (sample collected) → Review (results verified) → Done (report sent).

# 2. Limiting Work-in-Progress (WIP)
To prevent overloading staff and ensure timely care:

**WIP Limits per Column:**

**In Progress (Doctors):** Max 5 patients at a time.

**In Progress (Lab):** Max 3 simultaneous tests per technician.

**Bottleneck Detection:** If the "Review" column exceeds its WIP limit (e.g., too many unverified reports), the team reallocates staff to balance the workload.

**Outcome:** Prevents delays (e.g., lab backlog) and ensures focus on critical tasks.

# 3. Supporting Agile Principles
**Continuous Delivery:** Small, frequent updates (e.g., daily patient discharges, real-time lab updates).

**Adaptability:** Urgent cases (e.g., emergency surgeries) can be prioritized by moving them to the top of the "To Do" column.

**Feedback Loops:** Daily stand-up meetings to discuss blockers (e.g., missing patient records delaying discharges).

**Agile Alignment:** Responds to changing hospital needs (e.g., sudden ICU admissions) while maintaining steady workflow.
