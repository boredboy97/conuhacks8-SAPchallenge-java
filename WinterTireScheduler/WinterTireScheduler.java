import java.io.*;
import java.util.*;

public class WinterTireScheduler {


    public static void main(String[] args) 
    {

        //------------------------------------------------------
        //BOATY TESTING DATE CLASS


        Date date1 = new Date(1,1,2022,5,5);
        Date date2 = new Date(23,9,2022,13,7);

        System.out.println(date1);
        System.out.println(date2);



         //------------------------------------------------------
        //CSV File Scan
        

        /*  BOATY TESTING START
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
       BOATY TESTING END     */

        

    }
}

