# Hospital Management System

## Language Choice: Python

I chose Python for this implementation because:
- Clean syntax and rapid development
- Strong OOP capabilities despite being dynamically typed
- Excellent readability for demonstrating design patterns
- Wide adoption in healthcare and enterprise systems

## Key Design Decisions

1. **Class Structure**:
   - Used inheritance with `Person` as base class
   - Abstract Base Classes (ABC) for interfaces
   - Type hints for better code documentation
   - Composition for object relationships

2. **Pattern Applications**:
   - Singleton using `__new__` for HospitalManagementSystem
   - Factory Method with ABC for staff creation
   - Abstract Factory for creating hospital object families
   - Builder pattern for complex Patient construction
   - Prototype using `copy.deepcopy`
   - Object Pool with `Queue` for Appointment reuse

3. **Testing Approach**:
   - Built-in `unittest` framework could be used
   - Each pattern demonstrated in main execution
   - Clear output shows each pattern's behavior

## How to Run

1. **Requirements**:
   - Python 3.7 or higher
   - No additional dependencies required

2. **Execution**:
   ```bash
   # Save the code as hospital_system.py
   python hospital_system.py
