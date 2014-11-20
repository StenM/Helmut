package ee.ut.tvt.refactoringDemo;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<Doctor> doctors = Doctor.getAll();
        List<Patient> patients = Patient.getAll();
        
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
        
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
    
}