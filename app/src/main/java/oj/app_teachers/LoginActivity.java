package oj.app_teachers;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLogin = (EditText) findViewById(R.id.editText);
        editPassword = (EditText) findViewById(R.id.editText1);
    }

    public void login() {
        String loginId = editLogin.getText().toString().toLowerCase();
        String password = editPassword.getText().toString().toLowerCase();
        /*Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/
    }

}