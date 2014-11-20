package ee.ut.tvt.refactoringDemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    
    private String firstName;
    
    private String lastName;
    
    private String personalCode;
    
    private String profession;

    public Patient(String fname, String lname, String code, String prof) {
        this.firstName = fname;
        this.lastName = lname;
        this.personalCode = code;
        this.profession = prof;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPersonalCode() {
        return personalCode;
    }

    public String getProfession() {
        return profession;
    }
    
    
    public static List<Patient> getAll() {
        List<Patient> patients = new ArrayList<Patient>();
        try {
            FileInputStream fstream = new FileInputStream("patients.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(",");
                patients.add(new Patient(tokens[0], tokens[1], tokens[2], tokens[3]));
            }
            
            in.close();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return patients;
    }
    
    
    public String toString() {
        return "Patsient [" +
            "eesnimi = " + firstName + "; " +
            "perenimi = " + lastName + "; " +
            "isikukood = " + personalCode + "; " +
            "amet = " + profession +
        "]";
    }
}
