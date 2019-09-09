package com.trackdesk.authentication.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trackdesk.domain.entities.register.RegisterResponseEntity;
import com.trackdesk.authentication.R;

import javax.inject.Inject;

//import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView {

    private static final String TAG = "LOGIN_ACTIVITY";

    @Inject
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        ButterKnife.bind(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        registerPresenter.stop();
    }

    @Override
    public void onRegisterClicked() {

    }

    @Override
    public void onRegisterSuccess() {

    }

    @Override
    public void onRegisterFailed() {

    }

    @Override
    public void onRegisterError(Throwable throwable) {

    }

    @Override
    public void handleRegisterResponse(RegisterResponseEntity registerResponseEntity) {

    }
}
