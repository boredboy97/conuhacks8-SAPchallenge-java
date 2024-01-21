import java.time.LocalDateTime;

public class Customer 
{
    private LocalDateTime dateCalled;
    private LocalDateTime dateRes;
    private String vehicleType;

    public Customer() //Default 
    {
        dateCalled = null;
        dateRes = null;
        vehicleType = "";
    }

    public LocalDateTime getDateCalled ()
    {
        return(dateCalled);

    }

    public LocalDateTime getDateRes ()
    {
        return(dateRes);

    }

    public String getVehicleType ()
    {
        return(vehicleType);

    }

    public Customer (LocalDateTime dateCalled, LocalDateTime dateRes, String vehicleType) 
    {
        this.dateCalled = dateCalled;
        this.dateRes = dateRes;
        this.vehicleType = vehicleType;
    }

    public String toString() {
        return dateCalled.toString() + " | " + dateRes.toString() + " | " + vehicleType;
    }


     
}
