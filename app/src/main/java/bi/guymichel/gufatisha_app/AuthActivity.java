package bi.guymichel.gufatisha_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        Button btn_login = findViewById(R.id.btn_login);
        ProgressBar login_progressBar = findViewById(R.id.login_progressBar);
        btn_login.setOnClickListener(v -> {
            login_progressBar.setVisibility(View.VISIBLE);
            Intent i = new Intent(AuthActivity.this,MainActivity.class);
            startActivity(i);
        });
    }
}