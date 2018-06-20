package logger.weight;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
    public static final String DATE_FORMAT_NOW = "dd-MM-yyyy";

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        String date = sdf.format(cal.getTime());
        System.out.println(date);

        // String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        // System.out.println(date);
    }



}
