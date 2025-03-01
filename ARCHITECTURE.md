---
title: Hospital Management System - System Context & Container Diagram
---

%% SYSTEM CONTEXT DIAGRAM
C4Context
  title System Context Diagram for Hospital Management System
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

%% CONTAINER DIAGRAM
C4Container
  title Container Diagram for Hospital Management System

  System_Ext(email_system, "E-Mail System", "Sends notifications and reports to patients and staff", $tags="v1.0")
  Person(patient, "Patient", "A patient using the hospital services", $tags="v1.0")
  Person(doctor, "Doctor", "A medical professional managing patient records", $tags="v1.0")

  Container_Boundary(hms, "Hospital Management System") {
      Container(web_portal, "Web Portal", "React, Node.js", "Provides all hospital management functionalities to doctors and patients via web browser")
      Container_Ext(mobile_app, "Mobile App", "Flutter, Dart", "Provides appointment booking and limited access to patient records")
      Container(api_service, "API Service", "Python, FastAPI", "Manages all core hospital operations via API")
      ContainerDb(database, "Database", "PostgreSQL", "Stores patient records, doctor schedules, prescriptions, billing information, etc.")
      ContainerDb_Ext(lab_system, "Laboratory System", "Stores lab test results and connects to external labs")
  }

  System_Ext(insurance_system, "Insurance System", "Handles insurance claims and approvals")

  Rel(patient, web_portal, "Uses", "HTTPS")
  UpdateRelStyle(patient, web_portal, $offsetY="60", $offsetX="90")
  Rel(patient, mobile_app, "Uses", "HTTPS")
  UpdateRelStyle(patient, mobile_app, $offsetY="-30")

  Rel(doctor, web_portal, "Uses", "HTTPS")
  Rel(doctor, api_service, "Updates patient records in", "REST API")
  Rel(web_portal, api_service, "Uses", "async, JSON/HTTPS")
  Rel(mobile_app, api_service, "Uses", "async, JSON/HTTPS")
  Rel_Back(database, api_service, "Reads from and writes to", "sync, SQL")

  Rel(email_system, patient, "Sends appointment reminders and reports to")
  UpdateRelStyle(email_system, patient, $offsetX="-45")
  Rel(api_service, email_system, "Sends e-mails using", "sync, SMTP")
  UpdateRelStyle(api_service, email_system, $offsetY="-60")

  Rel(api_service, insurance_system, "Processes insurance claims with", "sync/async, XML/HTTPS")
  UpdateRelStyle(api_service, insurance_system, $offsetY="-50", $offsetX="-140")

  Rel(api_service, lab_system, "Fetches lab reports from", "sync, REST API")
