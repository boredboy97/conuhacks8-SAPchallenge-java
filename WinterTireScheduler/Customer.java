public class Customer 
{
    private Date dateCalled;
    private Date dateRes;
    private String vehicleType;

    public Customer() //Default 
    {
        
    }

    public Customer (Date dateCalled, Date dateRes, String vehicleType ) 
    {
        this.dateCalled = dateCalled;
        this.dateRes = dateRes;
        this.vehicleType = vehicleType;
    }

    
    public String toString() {
        return dateCalled.toString() + " | " + dateRes.toString() + " | " + vehicleType;
    }


     
}
