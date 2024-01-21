import java.io.*;
import java.util.*;

public class TestCSVreader {
    public static void main(String[] args) {
        
        String file = "WinterTireScheduler//datafile.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<List<String>> listOfCustomers = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine())!= null) {
                
                String[] row = line.split(",");
                List<String> fixedLengthList = Arrays.asList(row);
                listOfCustomers.add(listOfCustomers.size(), fixedLengthList);
                
            }
            System.out.println(listOfCustomers.get(0).get(0));
            System.out.println(listOfCustomers.size());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    
}
