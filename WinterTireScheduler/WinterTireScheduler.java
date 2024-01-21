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
        List<String> fixedLengthList = new LinkedList();

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine())!= null) {
                
                String[] row = line.split(",");
                listOfCustomers.add(listOfCustomers.size(), fixedLengthList);
                fixedLengthList = Arrays.asList(row);
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

        Customer[] CustomerArray = new Customer[listOfCustomers.size()];

       



    }
}

