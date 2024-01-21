import java.time.LocalDateTime;

public class Customer 
{
    private LocalDateTime dateCalled;
    private LocalDateTime dateRes;
    private String vehicleType;
    private int pushStatus;

    public Customer() //Default 
    {
        dateCalled = null;
        dateRes = null;
        vehicleType = "";
        pushStatus = 0;
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

    public int getPushStatus ()
    {
        return(pushStatus);
    }

    public void setDateCalled(LocalDateTime date)
    {
        this.dateCalled = date;
    }

    public void setDateRes(LocalDateTime date)
    {
        this.dateRes = date;
    }

    public void setVehicleType(String type)
    {
        this.vehicleType = type;
    }

    public void setPushStatus(int pushStatus)
    {
        this.pushStatus = pushStatus;
    }

    public Customer (LocalDateTime dateCalled, LocalDateTime dateRes, String vehicleType, int pushStatus) 
    {
        this.dateCalled = dateCalled;
        this.dateRes = dateRes;
        this.vehicleType = vehicleType;
        this.pushStatus = pushStatus;
    }

    public String toString() {
        return dateCalled.toString() + " | " + dateRes.toString() + " | " + vehicleType;
    }


     
}
