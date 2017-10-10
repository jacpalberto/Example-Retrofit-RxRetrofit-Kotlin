package com.example.pc_3.retrofitexample.Login;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc_3.retrofitexample.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter presenter;
    private TextView tvEmail;
    private TextView tvPassword;
    private Button btnLogin;
    private ContentLoadingProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkUI();
        init();
    }

    private void init() {
        presenter = new LoginPresenter(this, new LoginModel());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.requestLogin(tvEmail.getText().toString().trim(), tvPassword.getText().toString().trim());
            }
        });
    }

    private void linkUI() {
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvPassword = (TextView) findViewById(R.id.tv_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        progressBar = (ContentLoadingProgressBar) findViewById(R.id.progress_bar);
    }

    @Override
    public void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showProgress() {
        progressBar.show();
    }

    @Override
    public void dismissProgress() {
        progressBar.hide();
    }

    @Override
    public void userLogged() {
        tvPassword.setText("");
        tvEmail.setText("");
        Toast.makeText(this, "Log in Successful", Toast.LENGTH_SHORT).show();
    }
}
