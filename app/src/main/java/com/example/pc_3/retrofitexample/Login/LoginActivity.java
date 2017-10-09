package com.example.pc_3.retrofitexample.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc_3.retrofitexample.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private TextView tvEmail;
    private TextView tvPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUI();
        init();
    }

    private void init() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void linkUI() {
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvPassword = (TextView) findViewById(R.id.tv_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void showMessage(String message) {
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void userLogged() {

    }
}
