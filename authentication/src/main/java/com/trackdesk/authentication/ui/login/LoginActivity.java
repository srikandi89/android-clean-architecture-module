package com.trackdesk.authentication.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trackdesk.authentication.R;
import com.trackdesk.authentication.R2;
import com.trackdesk.authentication.ui.register.RegisterActivity;
import com.trackdesk.domain.entities.login.LoginRequestEntity;
import com.trackdesk.domain.entities.login.LoginResponseEntity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView{

    private static final String TAG = "LOGIN_ACTIVITY";

    @BindView(R2.id.et_username)
    EditText etUsername;

    @BindView(R2.id.et_password)
    EditText etPassword;

    @BindView(R2.id.btn_sign_in)
    Button btnLogin;

    @BindView(R2.id.btn_register)
    Button btnRegister;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        loginPresenter.stop();
    }

    @OnClick(R2.id.btn_sign_in)
    @Override
    public void onLoginClicked() {
        // Show progress dialog

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        loginPresenter.authenticate(new LoginRequestEntity(username, password));
    }

    @OnClick(R2.id.btn_register)
    @Override
    public void onSwitchToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginSuccess() {
        // goto main activity

        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed() {
        // display failure message dialog

        Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void handleLoginResponse(LoginResponseEntity loginResponseSingle) {
        // decide what kind of ui action should be performed

        Log.d(TAG, "Retrieved from rxjava stream");
        Log.d(TAG, "Status Code : "+loginResponseSingle.getStatusCode());

        if (loginResponseSingle.getStatusCode() != 200) {
            onLoginFailed();
        }
        else {
            onLoginSuccess();
        }
    }

    @Override
    public void onLoginError(Throwable throwable) {
        // if something unknown happened, notification goes here
    }
}
