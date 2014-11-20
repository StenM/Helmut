package ee.ut.tvt.refactoringDemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    
    private String firstName;
    
    private String familyName;
    
    private String personalCode;

    private String speciality;

    public Doctor(String fname, String lname, String code, String spec) {
        this.firstName = fname;
        this.familyName = lname;
        this.personalCode = code;
        this.speciality = spec;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }
    
    public String getPersonalCode() {
        return personalCode;
    }

    public String getSpeciality() {
        return speciality;
    }
    
    public static List<Doctor> getAll() {
        List<Doctor> doctors = new ArrayList<Doctor>();
        try {
            FileInputStream fstream = new FileInputStream("doctors.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(",");
                doctors.add(new Doctor(tokens[0], tokens[1], tokens[2], tokens[3]));
            }
            
            in.close();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return doctors;
    }
    
    
    public String toString() {
        return "Arst [" +
            "eesnimi = " + firstName + "; " +
            "perenimi = " + familyName + "; " +
            "isikukood = " + personalCode + "; " +
            "eriala = " + personalCode +
        "]";
    }
    
}
