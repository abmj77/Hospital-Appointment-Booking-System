package appointment.booking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Appointment {

   
    private String ReservationId;
    private String date;
    private Doctor doctor;
    private Patient patient;

    public Appointment() {
    }

    public Appointment(String reservationId, String date, Doctor doctor, Patient patient) {
        ReservationId = reservationId;
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getReservationId() {
        return ReservationId;
    }

    public void setReservationId(String reservationId) {
        ReservationId = reservationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void saveAppointment() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(ReservationId+".txt");
        pw.println(toString());
        pw.close();
    }
    public static void deleteAppointment(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the reservation id of the appointment you want to delete");
        String id = in.nextLine();
        File file = new File(id+".txt");
        if (file.exists()){
            file.delete();
            System.out.println("Appointment deleted");
        }else {
            System.out.println("Appointment not found");
        }

    }
    public static void searchAppointment() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the reservation id of the appointment you want to search");
        String id = in.nextLine();
        File file = new File(id+".txt");
        if (file.exists()){
            Scanner input = new Scanner(file);
            while (input.hasNext()){
                System.out.println(input.nextLine());
            }
            input.close();
        }else {
            System.out.println("Appointment not found");
        }
    }

    @Override
    public String toString() {
        return "\t\tAppointment Details\n"+
                "Reservation Id: "+ReservationId+"\n"+
                patient.toString()+"\n"+
                doctor.toString()+"\n"+
                "Date: "+date;

    }
}
