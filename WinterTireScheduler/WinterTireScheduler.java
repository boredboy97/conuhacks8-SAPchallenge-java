import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WinterTireScheduler {

    public static void main(String[] args) {

        // CSV FILE SCAN

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

            for (int i = 0; i < listOfCustomers.size(); i++) {
                System.out.println(listOfCustomers.get(i));
            }

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

        Customer[] CustomerArray = new Customer[listOfCustomers.size()];

        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        LocalDateTime dateCalled, dateRes;
        String vehicleType;

        for (int i = 0; i < listOfCustomers.size(); i++) {

            dateCalled = LocalDateTime.parse(listOfCustomers.get(i).get(0), dateFormatted);
            dateRes = LocalDateTime.parse(listOfCustomers.get(i).get(1), dateFormatted);
            vehicleType = listOfCustomers.get(i).get(2);
            CustomerArray[i] = new Customer(dateCalled, dateRes, vehicleType);
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

        for (int i = 0; i < listOfCustomers.size(); i++) {
            System.out.println(CustomerArray[i]);
        }

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
    // QUICKSORT DATES CALLED
    // -----------------------------

    private static void quickSortCustomerCalled(Customer[] customers, int start, int end) {
        if (end <= start)
            return;

        int pivot = partitionCall(customers, start, end);
        quickSortCustomerCalled(customers, start, pivot - 1);
        quickSortCustomerCalled(customers, pivot + 1, end);
    }

    private static int partitionCall(Customer[] customers, int start, int end) {
        Customer pivot = customers[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
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

}

// DATES
