package com.trackdesk.authentication.ui.login;

import android.util.Log;

import com.trackdesk.authentication.base.BasePresenter;
import com.trackdesk.authentication.rx.SchedulersFacade;
import com.trackdesk.domain.entities.login.LoginRequestEntity;
import com.trackdesk.domain.entities.login.LoginResponseEntity;
import com.trackdesk.domain.usecases.LoginUseCase;

import io.reactivex.Single;

public class LoginPresenter
        extends BasePresenter<LoginContract.LoginView>
        implements LoginContract.LoginPresenter {

    private static final String TAG = "LOGIN_PRESENTER";

    private final LoginUseCase loginUseCase;
    private final SchedulersFacade schedulersFacade;

    protected LoginPresenter(LoginContract.LoginView view, LoginUseCase loginUseCase, SchedulersFacade schedulersFacade) {
        super(view);

        this.loginUseCase = loginUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    public void authenticate(LoginRequestEntity requestEntity) {
        Log.d(TAG, "Authentication triggered");
        Log.d(TAG, "Username: "+requestEntity.getUsername());
        Log.d(TAG, "Password: "+requestEntity.getPassword());

        loadAuthenticationResult(loginUseCase.execute(requestEntity));
    }

    private void loadAuthenticationResult(Single<LoginResponseEntity> loginResponseSingle) {
        addDisposable(loginResponseSingle
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .subscribe(view::handleLoginResponse, view::onLoginError)
        );
    }

}
