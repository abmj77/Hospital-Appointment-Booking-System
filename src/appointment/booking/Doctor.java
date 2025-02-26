package appointment.booking;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Person {
    private String specialization;
    private double amount;
    private String WorkingHours;

    public Doctor() {
    }

    public Doctor(String id, String name, String phone, String specialization, double amount, String workingHours) {
        super(id, name, phone);
        this.specialization = specialization;
        this.amount = amount;
        WorkingHours = workingHours;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(String workingHours) {
        WorkingHours = workingHours;
    }

    public static boolean checkId(String id) throws FileNotFoundException {
        File file = new File("doctors.txt");
        if (!file.exists()) {
            return true;
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] data = line.split(",");
            if (data[0].equals(id)) {
                return false;
            }
        }
        return true;
    }

    public static void addDoctor() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Doctor's ID: ");
        String id = input.nextLine();
        while (!checkId(id)) {
            System.out.println("ID already exists, please enter another ID: ");
            id = input.nextLine();
        }
        System.out.println("Enter Doctor's name: ");
        String name = input.nextLine();
        while (!name.matches("[a-zA-Z ]+")) {
            System.out.println("Name can only contain letters and spaces, please enter another name: ");
            name = input.nextLine();
        }
        System.out.println("Enter Doctor's phone: ");
        String phone = input.nextLine();
        //should be 10 digits and start with 05
        while (!phone.matches("05[0-9]{8}")) {
            System.out.println("Phone number should be 10 digits and start with 05, please enter another phone number: ");
            phone = input.nextLine();
        }
        System.out.println("Enter Doctor's specialization: ");
        String specialization = input.nextLine();
        while (!specialization.matches("[a-zA-Z ]+")) {
            System.out.println("Specialization can only contain letters and spaces, please enter another specialization: ");
            specialization = input.nextLine();
        }
        System.out.println("Enter Amount of money Doctor's treatment cost for each patient: ");
        double salary = input.nextDouble();
        while (salary < 0) {
            System.out.println("Salary can't be negative, please enter another salary: ");
            salary = input.nextDouble();
        }
        System.out.println("Enter Doctor's working hours like this: 8:00-12:00");
        String workingHours = input.next();
        while (!workingHours.matches("[0-9]{1,2}:[0-9]{2}-[0-9]{1,2}:[0-9]{2}")) {
            System.out.println("Working hours should be like this: 8:00-12:00, please enter another working hours: ");
            workingHours = input.nextLine();
        }
        Doctor doctor = new Doctor(id, name, phone, specialization, salary, workingHours);
        File file = new File("doctors.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(id + "," + name + "," + phone + "," + specialization + "," + salary + "," + workingHours);
        writer.newLine();
        writer.close();
    }

    public static Doctor getDoctor() throws IOException {
        ArrayList<Doctor> doctors = new ArrayList<>();
        File file = new File("doctors.txt");
        if (!file.exists()) {
            System.out.println("There is no doctors in the system");
            System.out.println("Please add a doctor first");
            return null;
        }
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] data = line.split(",");
            Doctor doctor = new Doctor(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), data[5]);
            doctors.add(doctor);
        }
        System.out.println("Please choose a doctor from the list below: ");
        System.out.printf("%-5s%-20s%-20s%-20s%-20s%-20s%-20s%n", "No.", "ID", "Name", "Phone", "Specialization", "Amount", "Working Hours");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.printf("%-5d%-20s%-20s%-20s%-20s%-20s%-20s%n", i + 1, doctors.get(i).getId(), doctors.get(i).getName(), doctors.get(i).getPhone(), doctors.get(i).getSpecialization(), doctors.get(i).getAmount(), doctors.get(i).getWorkingHours());
        }
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            while (choice < 1 || choice > doctors.size()) {
                System.out.println("Invalid choice, please choose a doctor from the list: ");
                choice = in.nextInt();
            }
            return doctors.get(choice - 1);
        }




    @Override
    public String toString() {
        return "Doctor's ID: " + id + ", Doctor's name: " + name + ", Doctor's phone: " + phone + ", Doctor's specialization: " + specialization + ", Doctor's amount: " + amount + ", Doctor's working hours: " + WorkingHours;
    }

}