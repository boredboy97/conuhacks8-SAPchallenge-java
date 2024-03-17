import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WinterTireScheduler {

    public static void main(String[] args) {

        // ---------------
        // CSV FILE SCAN
        // ---------------

        String file = "WinterTireScheduler//datafile.csv";
        BufferedReader reader = null;
        String line = "";
        ArrayList<List<String>> listOfCustomers = new ArrayList<>();
        List<String> fixedLengthList = new LinkedList<>();

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                fixedLengthList = Arrays.asList(row);
                listOfCustomers.add(listOfCustomers.size(), fixedLengthList);
            }

            // for (int i = 0; i < listOfCustomers.size(); i++) {
            // System.out.println(listOfCustomers.get(i));
            // }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // CSV FILE SCAN DONE

        // CUSTOMER OBJECT ARRAYS

        Customer[] customerArray = new Customer[listOfCustomers.size()];

        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        LocalDateTime dateCalled, dateRes;
        String vehicleType;

        for (int i = 0; i < listOfCustomers.size(); i++) {

            dateCalled = LocalDateTime.parse(listOfCustomers.get(i).get(0), dateFormatted);
            dateRes = LocalDateTime.parse(listOfCustomers.get(i).get(1), dateFormatted);
            vehicleType = listOfCustomers.get(i).get(2);
            customerArray[i] = new Customer(dateCalled, dateRes, vehicleType);
        }

        // CUSTOMER ARRAYS DONE

        // QUICKSORTING

        // quickSortCustomerCalled(CustomerArray, 0, listOfCustomers.size() - 1);

        // for (int i = 0; i < CustomerArray.length; i++) {
        // while (CustomerArray[i].getDateRes().isEqual(CustomerArray[i +
        // 1].getDateRes())) {
        // if (CustomerArray[i].getDateCalled().isBefore(CustomerArray[i +
        // 1].getDateCalled())) {
        // Customer temp = CustomerArray[i];
        // CustomerArray[i] = CustomerArray[i + 1];
        // CustomerArray[i + 1] = temp;
        // break;
        // } else if (CustomerArray[i].getDateCalled().isAfter(CustomerArray[i +
        // 1].getDateCalled())) {
        // Customer temp = CustomerArray[i + 1];
        // CustomerArray[i + 1] = CustomerArray[i];
        // CustomerArray[i] = temp;
        // break;
        // }
        // }

        // }

        // QUICKSORT CUSTOMERS ACCORDING TO DATE CALLED
        quickSortCustomerCalled(customerArray, 0, customerArray.length - 1);

        // Printing out the sorted array
        // for (int i = 0; i < customerArray.length; i++) {
        // System.out.println(customerArray[i]);
        // }

        ArrayList<Customer> carsRoundedAppts = new ArrayList<Customer>();
        ArrayList<Customer> trucksRoundedAppts = new ArrayList<Customer>();

        // Tested rounding
        // System.out.println(customerArray[0].getDateRes());
        // customerArray[0].setDateRes(customerArray[0].getDateRes().withMinute(0));
        // System.out.println(customerArray[0].getDateRes());

        // ADDING CARS/TRUCKS TO THEIR RESPECTIVE ARRAY LIST OF ROUNDED TIMES
        for (int i = 0; i < customerArray.length; i++) {
            if (customerArray[i].getVehicleType().equals("compact")
                    || customerArray[i].getVehicleType().equals("medium")
                    || customerArray[i].getVehicleType().equals("full-size")) {
                carsRoundedAppts.add(customerArray[i]);
            } else if (customerArray[i].getVehicleType().equals("class 1 truck")
                    || customerArray[i].getVehicleType().equals("class 2 truck")) {
                trucksRoundedAppts.add(customerArray[i]);
            }
        }

        roundCars(carsRoundedAppts);
        roundTrucks(trucksRoundedAppts);

        ArrayList<Customer> bay1 = new ArrayList<Customer>();
        final int workHours = 12;

        for (int i = 0 ; i < carsRoundedAppts.size() ; i++ ) {
            if (carsRoundedAppts.get(i).getVehicleType().equals("compact")) {
                if (bay1.size() < 24) { 
                 bay1.add(carsRoundedAppts.get(i));   
                } 
            }
        }
        

        // for (Customer customer : trucksRoundedAppts) {
        // System.out.println(customer);
        // }

    }

    // ------------------------------------------
    // // QUICKSORT METHOD FOR DATES RESERVED
    // ------------------------------------------

    // private static void quickSortCustomerRes(Customer[] customers, int start, int
    // end) {
    // if (end <= start)
    // return;

    // int pivot = partitionRes(customers, start, end);
    // quickSortCustomerRes(customers, start, pivot - 1);
    // quickSortCustomerRes(customers, pivot + 1, end);
    // }

    // private static int partitionRes(Customer[] customers, int start, int end) {
    // Customer pivot = customers[end];
    // int i = start - 1;

    // for (int j = start; j <= end - 1; j++) {
    // if (customers[j].getDateRes().isBefore(pivot.getDateRes())) {
    // i++;
    // Customer temp = customers[i];
    // customers[i] = customers[j];
    // customers[j] = temp;
    // }
    // }
    // i++;
    // Customer temp = customers[i];
    // customers[i] = customers[end];
    // customers[end] = temp;

    // return i;
    // }

    // -----------------------------
    // Fuck quicksort im sorting //stop ur mentally ill
    // -----------------------------
    private static void sortCallDate(Customer[] customers) {

        for (int i = 0; i < customers.length; i++) {

        }

    }

    // -----------------------------
    // QUICKSORT DATES CALLED
    // -----------------------------

    private static void quickSortCustomerCalled(Customer[] customers, int start, int end) {
        if (start < end) {
            int pivot = partitionCall(customers, start, end);
            quickSortCustomerCalled(customers, start, pivot - 1);
            quickSortCustomerCalled(customers, pivot + 1, end);
        }

    }

    private static int partitionCall(Customer[] customers, int start, int end) {
        Customer pivot = customers[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {

            if (customers[j].getDateCalled().isBefore(pivot.getDateCalled())) {
                i++;
                Customer temp = customers[i];
                customers[i] = customers[j];
                customers[j] = temp;
            }
        }

        Customer temp = customers[i + 1];
        customers[i + 1] = customers[end];
        customers[end] = temp;

        return i + 1;
    }

    // METHOD TO ROUND APPOINTMENT TIMES TO NEAREST HALF HOUR FOR CARS
    private static void roundCars(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getDateRes().getMinute() < 15) {
                customers.get(i).setDateRes(customers.get(i).getDateRes().withMinute(0));
            } else if (customers.get(i).getDateRes().getMinute() < 45
                    && customers.get(i).getDateRes().getMinute() >= 15) {
                customers.get(i).setDateRes(
                        customers.get(i).getDateRes().withMinute(30));
            } else if (customers.get(i).getDateRes().getMinute() >= 45) {
                customers.get(i).setDateRes(
                        customers.get(i).getDateRes().withHour(customers.get(i).getDateRes().getHour() + 1));
                customers.get(i).setDateRes(customers.get(i).getDateRes().withMinute(0));
            }
        }
    }

    // BASICALLY SAME SHIT BUT FOR TRUCKS ROUNDED TO NEAREST HOUR
    private static void roundTrucks(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getDateRes().getMinute() < 30) {
                customers.get(i).setDateRes(customers.get(i).getDateRes().withMinute(0));
            } else if (customers.get(i).getDateRes().getMinute() >= 30) {
                customers.get(i).setDateRes(
                        customers.get(i).getDateRes().withHour(customers.get(i).getDateRes().getHour() + 1));
                customers.get(i).setDateRes(customers.get(i).getDateRes().withMinute(0));
            }
        }
    }

}

// DATES
