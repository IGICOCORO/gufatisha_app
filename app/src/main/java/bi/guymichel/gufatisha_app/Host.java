package bi.guymichel.gufatisha_app;
import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class Host {
    public static String URL = "http://192.168.43.135:8000";


    public static Date getDate(String str_date) {
        Date date;
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:S'Z'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            date = formatter.parse(str_date);
        } catch (Exception e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }
    public static String getStrDate(Date date) {
        String str_date;
        try {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            str_date = "Le "+ dateFormatter.format(date);
        }catch (Exception e) {
            str_date = null;
        }
        return str_date;
    }
}