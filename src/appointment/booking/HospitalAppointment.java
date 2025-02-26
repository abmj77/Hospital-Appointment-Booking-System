package appointment.booking;


import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HospitalAppointment {
    public static void addAppointment() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int appointmentId = random.nextInt(9000000) + 1000000;
        File file = new File(appointmentId + ".txt");
        while (file.exists()) {
            appointmentId = random.nextInt(9000000) + 1000000;
            file = new File(appointmentId + ".txt");
        }
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        while (!name.matches("[a-zA-Z ]+")) {
            System.out.println("name is invalid please enter a valid name");
            name = sc.nextLine();
        }
        System.out.println("Enter your ID: ");
        String id = sc.nextLine();
        while (!id.matches("[0-9]{8}")) {
            System.out.println("ID should be 8 digits try again: ");
            id = sc.nextLine();
        }
        System.out.println("Enter your phone number: ");
        String phone = sc.nextLine();
        while (!phone.matches("05[0-9]{8}")) {
            System.out.println("phone number should be 10 digits and start with 05, please enter another phone number: ");
            phone = sc.nextLine();
        }
        System.out.println("Enter your disease: ");
        String disease = sc.nextLine();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        while (age < 0 || age > 120) {
            System.out.println("age is invalid please enter a valid age");
            age = sc.nextInt();
        }
        System.out.print("Enter your gender (Male/Female): ");
        String gender = sc.next();
        while (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            System.out.print("Enter your gender (Male or Female): ");
            gender = sc.nextLine();
        }
        Patient patient = new Patient(id, name, phone, disease, age, gender);
        Doctor doctor = Doctor.getDoctor();
        if (doctor == null) {
            return;
        }
        System.out.println("Enter the appointment date: ");
        String date = sc.nextLine();
        while (!date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            System.out.println("date just be in format yyyy-mm-dd, please enter another date: ");
            date = sc.nextLine();
        }
        Appointment appointment = new Appointment(appointmentId + "", date, doctor, patient);
        appointment.saveAppointment();
        System.out.println("Appointment added successfully");
        System.out.println("Your appointment id is: " + appointmentId+" and your doctor is: "+doctor.getName());
        System.out.println("save this id to find your appointment later");
        System.out.println("____________________________________________________________");
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Add appointment");
        System.out.println("2- Delete appointment");
        System.out.println("3- View appointment");
        System.out.println("4- Add doctors");
        System.out.println("5- Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 5) {
            System.out.println("Invalid choice, please enter a valid choice");
            choice = sc.nextInt();
        }
        return choice;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("____________________________________________________________");
        System.out.println("Welcome to the hospital appointment booking system");
        System.out.println("____________________________________________________________");
        int ch;
        do {
            System.out.println("____________________________________________________________");
            ch = menu();
            System.out.println("____________________________________________________________");
            switch (ch) {
                case 1:
                    addAppointment();
                    break;
                case 2:
                    Appointment.deleteAppointment();
                    break;
                case 3:
                    Appointment.searchAppointment();
                    break;
                case 4:
                    Doctor.addDoctor();
                    break;
                case 5:
                    System.out.println("Thank you for using our system");
                    break;
            }
        } while (ch != 5);
    }
}
