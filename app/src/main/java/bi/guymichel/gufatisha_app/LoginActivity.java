package bi.guymichel.gufatisha_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import bi.guymichel.gufatisha_app.Dialogs.Dialog_login;

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
               phone.setError("please input");
               phone.requestFocus();
               return;
           } else {
               saveData("key",phone.getText().toString());
               Intent i = new Intent(LoginActivity.this,MainActivity.class);
               startActivity(i);
               finish();
           }

        });
    }

    private void saveData(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("phoneNum",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    private String getData(String key){
        SharedPreferences sharedPreferences = getSharedPreferences("phoneNum",0);
        if (sharedPreferences.contains(key)){
            String data = sharedPreferences.getString(key,null);
            return data;
        }else {
            return null;
        }

    }
}