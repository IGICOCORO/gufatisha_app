package bi.guymichel.gufatisha_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText phone;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone = findViewById(R.id.phone);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(v -> {
           if (phone.getText().toString().isEmpty()){
               Toast.makeText(LoginActivity.this,"Please enter Data",Toast.LENGTH_SHORT);
               phone.setError("Please input");
               phone.requestFocus();
               return;
           } else {
               saveData("TEL",phone.getText().toString());
               Intent i = new Intent(LoginActivity.this,MainActivity.class);
               startActivity(i);
               finish();
           }

        });
        getData("TEL");
    }

    private void saveData(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("session",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    private String getData(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("session",0);
        if (sharedPreferences.contains(key)){
            String data = sharedPreferences.getString(key,null);
            Log.i("====PHONE NUMBER====",data);
            return data;
        }else {
            return null;
        }

    }
}