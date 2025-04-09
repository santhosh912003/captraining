// Description: Design a system to manage patients in a hospital:
// Create an abstract class Patient with fields like patientId, name, and age.
// Add an abstract method calculateBill() and a concrete method getPatientDetails().
// Extend it into subclasses InPatient and OutPatient, implementing calculateBill() with different billing logic.
// Implement an interface MedicalRecord with methods addRecord() and viewRecords().
// Use encapsulation to protect sensitive patient data like diagnosis and medical history.
// Use polymorphism to handle different patient types and display their billing details dynamically.

import java.util.ArrayList;
import java.util.List;


class encap7{
	    public static void main(String[] args) {
        HospitalPatientManagement hospital = new HospitalPatientManagement();
        Patient inPatient = new InPatient(1, "John Doe", 30, "Flu", "No previous history", 1000);
        Patient outPatient = new OutPatient(2, "Jane Smith", 25, 200);

        hospital.addRecord(inPatient.getPatientDetails());
        hospital.addRecord(outPatient.getPatientDetails());

        System.out.println("In-Patient Bill: " + inPatient.calculateBill());
        System.out.println("Out-Patient Bill: " + outPatient.calculateBill());

        hospital.viewRecords();
    }
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class InPatient extends Patient {
    private String diagnosis;
    private String medicalHistory;
    private double treatmentCharge;

    public InPatient(int patientId, String name, int age, String diagnosis, String medicalHistory,
            double treatmentCharge) {
        super(patientId, name, age);
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
        this.treatmentCharge = treatmentCharge;
    }

    @Override
    public double calculateBill() {
        return treatmentCharge + (0.1 * treatmentCharge);
    }

    @Override
    public String getPatientDetails() {
        return super.getPatientDetails() + ", Diagnosis: " + diagnosis + ", Medical History: " + medicalHistory;
    }

}

class OutPatient extends Patient {
    private double consultationCharge;

    public OutPatient(int patientId, String name, int age, double consultationCharge) {
        super(patientId, name, age);
        this.consultationCharge = consultationCharge;
    }

    @Override
    public double calculateBill() {
        return consultationCharge + (0.05 * consultationCharge);
    }

    @Override
    public String getPatientDetails() {
        return super.getPatientDetails() + ", Consultation Charge: " + consultationCharge;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

public class HospitalPatientManagement implements MedicalRecord {
    private List<String> medicalRecords;

    public HospitalPatientManagement() {
        medicalRecords = new ArrayList<>();
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : medicalRecords) {
            System.out.println(record);
        }
    }


}