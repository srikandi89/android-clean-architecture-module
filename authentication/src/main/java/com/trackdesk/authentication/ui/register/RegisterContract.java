package com.trackdesk.authentication.ui.register;

import com.trackdesk.domain.entities.register.RegisterRequestEntity;
import com.trackdesk.domain.entities.register.RegisterResponseEntity;

public interface RegisterContract {
    interface RegisterView {
        void onRegisterClicked();
        void onRegisterSuccess();
        void onRegisterFailed();
        void onRegisterError(Throwable throwable);
        void handleRegisterResponse(RegisterResponseEntity registerResponseEntity);
    }

    interface RegisterPresenter {
        void register(RegisterRequestEntity requestEntity);
    }
}
