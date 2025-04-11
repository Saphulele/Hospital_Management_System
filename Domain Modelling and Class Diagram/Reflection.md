# Reflection on Designing the Domain Model and Class Diagram for a Hospital Management System

Designing a domain model and class diagram for a Hospital Management System (HMS) was an insightful yet challenging experience. The process required careful consideration of abstraction, relationships, and method definitions to ensure the system accurately represented real-world hospital operations while maintaining scalability and maintainability. Below, I reflect on the challenges faced, alignment with previous assignments, trade-offs made, and key lessons learned about object-oriented design.

# 1. Challenges Faced in Designing the Domain Model and Class Diagram
**Abstraction and Encapsulation**
One of the primary challenges was determining the right level of abstraction. A hospital system involves numerous entities—patients, doctors, nurses, appointments, medical records, prescriptions, billing, and departments—each with complex interactions. Deciding which attributes and behaviors belonged to which class required careful thought. For example, should Patient and Doctor inherit from a common Person class, or should they be separate entities with shared attributes? I initially struggled with overcomplicating inheritance hierarchies before settling on a more composition-based approach.

**Defining Relationships**

Understanding and correctly implementing relationships (associations, aggregations, compositions, and inheritance) was another hurdle. For instance:

Should Appointment be an independent class or an attribute of Patient and Doctor?

Should MedicalRecord be a composition of Patient (since records cannot exist without a patient), or should it be an association?

How should Department relate to Doctor—should it be a one-to-many association, or should Doctor have a Department attribute?

After several iterations, I established that Appointment should be a separate class linked to Patient and Doctor via associations, while MedicalRecord was a composition under Patient.

**Method Definitions**

Determining the responsibilities of each class was tricky. For example:

Should Patient have a method like scheduleAppointment(), or should Appointment handle that logic?

Should Billing calculate charges based on Treatment, or should Treatment compute its own cost?

I realized that following the Single Responsibility Principle (SRP) was crucial—each class should have one primary responsibility. Thus, AppointmentScheduler became a separate service class rather than embedding scheduling logic in Patient or Doctor.

# 2. Alignment with Previous Assignments (Use Cases, State Diagrams, Requirements)

**The class diagram was designed to align with prior artifacts:**

**Use Cases:** The classes directly supported functionalities like "Schedule Appointment," "Generate Bill," and "Update Medical Record." For example, the Appointment class mapped to the "Schedule Appointment" use case, while Billing handled payment processing.

**State Diagrams:** The Appointment class reflected states like "Scheduled," "Completed," and "Cancelled," matching the state transitions outlined earlier.

**Requirements:** Functional requirements (e.g., "The system shall allow doctors to view patient records") were satisfied by associations like Doctor -- accesses --> MedicalRecord.

Ensuring consistency across all models helped maintain a cohesive system design.

# 3. Trade-offs Made in the Design

**Inheritance vs. Composition**

Initially, I considered deep inheritance hierarchies (e.g., Person → Staff → Doctor/Nurse), but this led to rigidity. Instead, I favored composition (e.g., Doctor has a StaffRole property) for greater flexibility.

**Simplified Associations**
Some many-to-many relationships (e.g., Doctor works in multiple Departments) were simplified to avoid excessive complexity in the first draft. Later, junction classes (e.g., DepartmentAssignment) were introduced for clarity.

**Omitting Edge Cases**
Certain edge cases (e.g., emergency walk-ins vs. scheduled appointments) were deferred to keep the initial model manageable, with plans to extend later.

# 4. Lessons Learned About Object-Oriented Design

**Start Simple, Refine Incrementally:** Early attempts to model everything perfectly led to paralysis. Iterative refinement was more effective.

**Favor Composition Over Inheritance:** Deep inheritance creates brittle hierarchies, whereas composition allows flexible, reusable components.

**Single Responsibility Principle is Key:** Classes should have one primary function, avoiding bloated designs.

**Consistency Across Models Matters:** The domain model must align with use cases, state diagrams, and requirements to ensure a coherent system.

**Trade-offs Are Necessary:** Not every real-world complexity needs immediate implementation—focus on core functionalities first.
