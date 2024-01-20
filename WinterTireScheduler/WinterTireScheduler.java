public class WinterTireScheduler {

    public static void main(String[] args) 
    {

        Date date1 = new Date(1,1,2001,5,5);

        Date date2 = new Date(2,2,2023,2,7);
    
        System.out.println(date1);

        Customer Boaty = new Customer(date1,date2,"Car");

        System.out.println(Boaty);
    }
}

