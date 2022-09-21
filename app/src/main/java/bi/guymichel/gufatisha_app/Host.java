package bi.guymichel.gufatisha_app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class Host {
    public static String URL = "http://192.168.164.218:8000";
    private static SharedPreferences sessionPreference;


    public static Date getDate(String str_date) {
        Date date;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:S'Z'");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            date = formatter.parse(str_date);
        }catch (Exception e) {
            e.printStackTrace();
            date = null;
        }
        return date;
    }
    public static String getStrDate(Date date) {
        String str_date;
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm"); //this format changeable
            dateFormatter.setTimeZone(TimeZone.getDefault());
            str_date = "Le "+ dateFormatter.format(date);
        }catch (Exception e) {
            str_date = null;
        }
        return str_date;
    }


    public static void logOut(Activity context){
        sessionPreference = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
        SharedPreferences.Editor session = sessionPreference.edit();
        session.clear();
        session.apply();
        context.finish();
    }
}