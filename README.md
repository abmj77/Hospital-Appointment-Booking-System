# Hospital_Appointment_Booking_System

A Java-based console application designed to manage hospital appointments. This system allows users to book, delete, and view appointments, as well as add doctors to the system. It uses file-based storage for persistence and includes input validation for a robust user experience.

## Features

- Book appointments with unique reservation IDs.
- Assign patients to available doctors.
- Delete and search appointments by reservation ID.
- Add doctor profiles with details like specialization and working hours.
- Store data in text files for persistence.

## Project_Structure

The project is organized in the `appointment.booking` package and consists of the following Java files:

- **HospitalAppointment.java**
  - Main entry point of the application.
  - Provides a menu-driven interface for adding appointments, deleting appointments, viewing appointments, adding doctors, and exiting the system.
  - Implements user input handling and basic workflow logic.

- **Doctor.java**
  - Extends the `Person` class to represent a doctor.
  - Manages doctor-specific attributes: specialization, treatment cost (amount), and working hours.
  - Includes methods to add doctors to a `doctors.txt` file and retrieve a doctor from the list for appointment booking.

- **Person.java**
  - Abstract base class for `Doctor` and `Patient`.
  - Defines common attributes: ID, name, and phone number.
  - Provides foundational structure for inheritance.

- **Patient.java**
  - Extends the `Person` class to represent a patient.
  - Adds patient-specific attributes: disease, age, and gender.
  - Used in appointments to store patient details.

- **Appointment.java**
  - Represents an appointment with a reservation ID, date, doctor, and patient.
  - Handles saving appointments to individual text files (e.g., `1234567.txt`).
  - Provides static methods to delete and search appointments by reservation ID.
     
## Interact with the Menu

The application presents a menu with the following options:

1.  **Add appointment:** Allows a patient to schedule an appointment with a doctor. The system will generate a unique appointment ID.
2.  **Delete appointment:** Allows a patient to cancel an existing appointment by providing the appointment ID.
3.  **View appointment:** Allows a patient to view the details of an appointment by providing the appointment ID.
4.  **Add doctors:** Allows an administrator to add new doctors to the system.
5.  **Exit:** Terminates the application.

Users interact with the menu by entering the corresponding number for their desired action. Input validation is performed to ensure data integrity.

## Example Output

```
____________________________________________________________
Welcome to the hospital appointment booking system

____________________________________________________________
____________________________________________________________
1- Add appointment
2- Delete appointment
3- View appointment
4- Add doctors
5- Exit
Enter your choice: 1
____________________________________________________________
Enter your name:
John Doe
Enter your ID:
12345678
Enter your phone number:
0512345678
Enter your disease:
Flu
Enter your age:
30
Enter your gender (Male/Female): Male
Enter the appointment date:
2024-03-15
Appointment added successfully
Your appointment id is: 7890123 and your doctor is: Dr. Smith
save this id to find your appointment later
____________________________________________________________
____________________________________________________________
1- Add appointment
2- Delete appointment
3- View appointment
4- Add doctors
5- Exit
Enter your choice: 3
____________________________________________________________
Enter the reservation id of the appointment you want to search
7890123
Appointment Details
Reservation Id: 7890123
id: 12345678
name: John Doe
gender: Male
age: 30
disease: Flu
phone: 0512345678
Doctor's ID: D001, Doctor's name: Dr. Smith, Doctor's phone: 0598765432, Doctor's specialization: Cardiology, Doctor's amount: 200.0, Doctor's working hours: 9:00-17:00
Date: 2024-03-15
____________________________________________________________
1- Add appointment
2- Delete appointment
3- View appointment
4- Add doctors
5- Exit
Enter your choice: 5
____________________________________________________________
Thank you for using our system
```

## Requirements

*   Java Development Kit (JDK) 8 or higher.
*   A terminal or IDE (e.g., IntelliJ IDEA, Eclipse) to compile and run the code.
*   Write permissions in the directory to create `.txt` files for appointments and doctors.

## Notes

**File Storage:**

*   Doctor data is stored in `doctors.txt` in CSV format (e.g., `123,Dr. Smith,0501234567,Cardiology,500.0,8:00-12:00`).
*   Each appointment is saved in a separate `.txt` file named after its reservation ID (e.g., `1234567.txt`).

**Input Validation:**

*   Patient IDs must be 8 digits.
*   Phone numbers must start with "05" and be 10 digits.
*   Dates must follow the `yyyy-mm-dd` format.
*   Names and specializations must contain only letters and spaces.

**Error Handling:**

*   The system checks for duplicate doctor IDs.
*   The system ensures valid input through loops.
*   If no doctors are available, appointment booking is halted until a doctor is added.


## Author

Abdulmajeed Abdullah
