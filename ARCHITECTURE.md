C4Context
  title Hospital Management System - Context Diagram

  Person(patient, "Patient", "Visits the hospital for consultations and treatments")
  Person(doctor, "Doctor", "Provides medical services to patients")
  Person(admin, "Admin", "Manages hospital operations")
  
  System(hms, "Hospital Management System", "Manages patient records, appointments, and billing")

  System_Ext(insurance, "Insurance System", "Handles patient insurance claims")
  System_Ext(pharmacy, "Pharmacy System", "Manages prescription fulfillment")

  BiRel(patient, hms, "Uses")
  BiRel(doctor, hms, "Uses")
  BiRel(admin, hms, "Manages")
  Rel(hms, insurance, "Sends claims")
  Rel(hms, pharmacy, "Sends prescriptions")

  UpdateLayoutConfig($c4ShapeInRow="3", $c4BoundaryInRow="1")
