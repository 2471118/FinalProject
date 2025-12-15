# Final Project

## Author: Allen H.L. Tang
## ID: 2471118
This is the final java project for the introduction to programming course,
it is a rough school managing system that handles students, courses,
departments, assignments and addresses.

There are 5 Classes besides Main in the org file
    - Address
    - Assignment
    - Course
    - Department
    - Student
As well as a new util file with
    - Util
And a MainTest
    - MainTest

This project is a Java program that simulates a basic student course management system. It includes students, departments,
courses, assignments, and addresses. The project focuses on practicing object-oriented programming and unit testing.
Students can register for and drop courses. Courses belong to departments and contain assignments with weighted scores.
Final grades are calculated based on these weights. Addresses validate Canadian postal codes to ensure correct data.
All IDs are generated automatically so each student, course, department, and assignment has a unique identifier.
When a student registers for a course, both the student and the course are updated, and assignment score lists are adjusted accordingly.
The project uses Lombok to reduce repetitive code and JUnit 5 to test important methods with clear display names.
Overall, it demonstrates clean design, validation, and testing in Java.