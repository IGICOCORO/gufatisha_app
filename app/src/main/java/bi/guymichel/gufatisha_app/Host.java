package bi.guymichel.gufatisha_app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class Host {
    public static String URL = "http://192.168.32.218:8000";
    private static SharedPreferences sessionPreference;


    public static void logOut(Activity context){
        sessionPreference = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
        SharedPreferences.Editor session = sessionPreference.edit();
        session.clear();
        session.apply();
        context.finish();
    }
}