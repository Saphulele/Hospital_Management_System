# Hospital Management System - System Context Diagram

```mermaid
C4Context
  title System Context diagram for Hospital Management System
  Enterprise_Boundary(h0, "Hospital Boundary") {
    Person(patientA, "Patient A", "A patient visiting the hospital for treatment.")
    Person(patientB, "Patient B")
    Person_Ext(patientC, "Patient C", "An external patient using online consultation.")

    Person(doctorA, "Doctor A", "A doctor who treats patients and updates records.")
    Person(nurseA, "Nurse A", "A nurse who assists doctors and manages patient care.")

    System(HMS, "Hospital Management System", "Manages patient records, appointments, and billing.")

    Enterprise_Boundary(h1, "Hospital Internal Systems") {

      SystemDb_Ext(EMR, "Electronic Medical Records", "Stores all patient health records and history.")

      System_Boundary(h2, "Hospital Services") {
        System(Appointments, "Appointment System", "Manages patient bookings and doctor schedules.")
        System(Billing, "Billing System", "Handles hospital billing and payments.")
      }

      System_Ext(EmailSys, "E-mail System", "Used to send patient notifications and updates.")
      SystemDb(LabDB, "Laboratory Database", "Stores lab test reports and results.")

      Boundary(h3, "Queue Systems", "boundary") {
        SystemQueue(MedicineQueue, "Pharmacy Queue", "Manages patient prescriptions and medication orders.")
        SystemQueue_Ext(InsuranceQueue, "Insurance Approval Queue", "Handles insurance claims and approvals.")
      }
    }
  }

  BiRel(patientA, HMS, "Uses")
  BiRel(doctorA, HMS, "Updates patient records in")
  BiRel(nurseA, HMS, "Checks patient details in")
  BiRel(HMS, EMR, "Uses")
  Rel(HMS, EmailSys, "Sends notifications", "SMTP")
  Rel(EmailSys, patientA, "Sends appointment reminders to")

  UpdateElementStyle(patientA, $fontColor="red", $bgColor="grey", $borderColor="red")
  UpdateRelStyle(patientA, HMS, $textColor="blue", $lineColor="blue", $offsetX="5")
  UpdateRelStyle(HMS, EMR, $textColor="blue", $lineColor="blue", $offsetY="-10")
  UpdateRelStyle(HMS, EmailSys, $textColor="blue", $lineColor="blue", $offsetY="-40", $offsetX="-50")
  UpdateRelStyle(EmailSys, patientA, $textColor="red", $lineColor="red", $offsetX="-50", $offsetY="20")

  UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
