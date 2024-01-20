import java.io.*;
import java.util.*;

public class WinterTireScheduler {


    public static void main(String[] args) 
    {
        //CSV File Scan
        
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

            for(int i=0;i<listOfCustomers.size();i++)
            {
                System.out.println(listOfCustomers.get(i));
            }
            
            
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

