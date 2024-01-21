import java.text.SimpleDateFormat;

public class Date {

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy - hh:mm");

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
    public Date(int d, int M, int y, int h, int m) {
        this.d = d;
        this.M = M;
        this.y = y;
        this.h = h;
        this.m = m;
    }

    // toString method:
    public String toString() {
        return sdf.format(new Date());
    }

}