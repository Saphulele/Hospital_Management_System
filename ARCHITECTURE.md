graph TD;
  A[Patient] -->|Visits| B[Hospital Management System];
  C[Doctor] -->|Uses| B;
  D[Admin] -->|Manages| B;
  B -->|Sends Claims| E[Insurance System];
  B -->|Sends Prescriptions| F[Pharmacy System];
