package bi.guymichel.gufatisha_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Host {
    public static String URL = "http://192.168.126.218:8000";
    private static SharedPreferences sessionPreference;


    public static void logOut(Activity context){
        sessionPreference = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
        SharedPreferences.Editor session = sessionPreference.edit();
        session.clear();
        session.apply();
        context.finish();
    }
}