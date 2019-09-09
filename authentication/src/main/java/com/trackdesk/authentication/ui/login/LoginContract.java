package com.trackdesk.authentication.ui.login;

import com.trackdesk.domain.entities.login.LoginRequestEntity;
import com.trackdesk.domain.entities.login.LoginResponseEntity;

public interface LoginContract {
    interface LoginView {
        void onLoginClicked();
        void onLoginSuccess();
        void onLoginFailed();
        void onSwitchToRegister();
        void onLoginError(Throwable throwable);
        void handleLoginResponse(LoginResponseEntity loginResponseSingle);
    }

    interface LoginPresenter {
        void authenticate(LoginRequestEntity requestEntity);
    }
}
