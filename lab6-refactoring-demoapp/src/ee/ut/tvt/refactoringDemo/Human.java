package ee.ut.tvt.refactoringDemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Human {
	
	private String firstName;
    
    private String lastName;
    
    public static List<Human> getAll(String filename) {
        List<Human> people = new ArrayList<Human>();
        try {
            FileInputStream fstream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
            while ((strLine = br.readLine()) != null)   {
                String[] tokens = strLine.split(",");
                people.add(new Human(tokens[0], tokens[1], tokens[2], tokens[3]));
            }
            
            in.close();
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return people;
    }
}
