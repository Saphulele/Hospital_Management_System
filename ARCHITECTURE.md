```mermaid
graph TD;
  A[User] -->|Uses| B[Web App];
  B -->|Fetches data| C[Database];
  B -->|Sends request| D[API Server];
