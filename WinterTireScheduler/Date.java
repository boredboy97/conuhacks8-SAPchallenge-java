public class Date {

    // Attributes:

    private int day;
    private int month;
    private int year;

    private int hour;
    private int min;

    // Constructors:

    // Default constructor:
    public Date() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.hour = 0;
        this.min = 0;
    }

    // Custom constructor:
    public Date(int day, int month, int year, int hour, int min) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }

    // toString method:
    public String toString() {
        if (day < 10 && day >= 0 && month < 10 && month >= 0 && hour < 10 && hour >= 0 && min < 10 && min >= 0)
			return "0" + day + "/0" + month + "/" + year + " - 0" + hour + ":0" + min;
		else
			return day + "/" + month + "/" + year + " - " + hour + ":" + min;
    }

}