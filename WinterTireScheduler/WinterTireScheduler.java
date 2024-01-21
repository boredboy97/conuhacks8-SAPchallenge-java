import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class WinterTireScheduler 
{


    public static void main(String[] args) 
    {

        //CSV FILE SCAN

        String file = "WinterTireScheduler//datafile.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<List<String>> listOfCustomers = new ArrayList<>();
        List<String> fixedLengthList = new LinkedList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine())!= null) {
                
                String[] row = line.split(",");
                fixedLengthList = Arrays.asList(row);
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

        //CSV FILE SCAN DONE

        //CUSTOMER OBJECT ARRAYS
        
        Customer[] CustomerArray = new Customer[listOfCustomers.size()];

        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        LocalDateTime dateCalled, dateRes;
        String vehicleType;
         
        for(int i = 0 ; i<listOfCustomers.size() ; i++)
        {
            
            dateCalled = LocalDateTime.parse(listOfCustomers.get(i).get(0), dateFormatted);
            dateRes = LocalDateTime.parse(listOfCustomers.get(i).get(1), dateFormatted);
            vehicleType = listOfCustomers.get(i).get(2);
            CustomerArray[i] = new Customer (dateCalled, dateRes, vehicleType);
        }
        
        //CUSTOMER ARRAYS DONE

        //INDIVIDUAL DATE AND VEHICLE ATTRIBUTE ARRAYS

        LocalDateTime[] DCArray = new LocalDateTime[listOfCustomers.size()];
        LocalDateTime[] RESArray = new LocalDateTime[listOfCustomers.size()];
        String[] VEHArray = new String[listOfCustomers.size()];

        for(int i=0;i<listOfCustomers.size();i++)
        {
            DCArray[i] = CustomerArray[i].getDateCalled();
            RESArray[i] = CustomerArray[i].getDateRes();
            VEHArray[i] = CustomerArray[i].getVehicleType();
        }

        //DONE

        //QUICKSORTING

        quickSortDate(RESArray, 0, listOfCustomers.size()-1); 

        quickSortDate(DCArray, 0, listOfCustomers.size()-1); 

        


    }


    //QUICKSORT METHOD FOR DATES
private static void quickSortDate (LocalDateTime[] dates,int start,int end)
        {
            if(end <= start) 
                return;

            int pivot = partition(dates, start ,end);
            quickSortDate(dates, start, pivot-1);
            quickSortDate(dates, pivot+1,end);
        }

        private static int partition(LocalDateTime[] dates, int start, int end)
        {
            LocalDateTime pivot = dates[end];
            int i = start-1;

            for(int j=start; j<= end-1;j++)
            {
                if(dates[j].isBefore(pivot))
                {
                    i++;
                    LocalDateTime temp = dates[i];
                    dates[i]=dates[j];
                    dates[j]=temp;
                }
            }
            i++;
            LocalDateTime temp = dates[i];
            dates[i]=dates[end];
            dates[end]=temp;

            return i;
        }
    }

    //DATES

