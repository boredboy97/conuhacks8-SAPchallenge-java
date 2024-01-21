import java.text.SimpleDateFormat;

public class Date {

    // Attributes:

    private int d;
    private int M;
    private int y;

    private int h;
    private int m;

    // Constructors:

    // Default constructor:
    public Date() {
        this.d = 0;
        this.M = 0;
        this.y = 0;
        this.h = 0;
        this.m = 0;
    }

    // Custom constructor:
    public Date(int y, int M, int d, int h, int m) {
        this.d = d;
        this.M = M;
        this.y = y;
        this.h = h;
        this.m = m;
    }


    // toString method:
    public String toString() {
       
            // Format the variables that might need a 0 infront
            String formattedMonth = String.format("%02d", M);
            String formattedDay = String.format("%02d", d);
            String formattedHour = String.format("%02d", h);
            String formattedMin = String.format("%02d", m);
    
            
            return y + "/" + formattedDay + "/" + formattedMonth + " - " + formattedHour + ":" + formattedMin;
        }
    
 }

