package appointment.booking;

public class Patient extends Person{
    private String disease;
    private int age;
    private String gender;

    public Patient() {
    }

    public Patient(String id, String name, String phone, String disease, int age, String gender) {
        super(id, name, phone);
        this.disease = disease;
        this.age = age;
        this.gender = gender;
    }
    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id: "+id+"\nname: "+name+"\ngender: "+gender+"\nage: "+age+"\ndisease: "+disease+"\nphone: "+phone;
    }
}
