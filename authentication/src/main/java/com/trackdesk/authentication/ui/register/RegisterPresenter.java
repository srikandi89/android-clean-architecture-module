package com.trackdesk.authentication.ui.register;

import android.util.Log;

import com.trackdesk.authentication.base.BasePresenter;
import com.trackdesk.authentication.rx.SchedulersFacade;
import com.trackdesk.domain.entities.register.RegisterRequestEntity;
import com.trackdesk.domain.entities.register.RegisterResponseEntity;
import com.trackdesk.domain.usecases.RegisterUseCase;

import io.reactivex.Single;

public class RegisterPresenter
        extends BasePresenter<RegisterContract.RegisterView>
        implements RegisterContract.RegisterPresenter {

    private static final String TAG = "LOGIN_PRESENTER";

    private final RegisterUseCase registerUseCase;
    private final SchedulersFacade schedulersFacade;

    protected RegisterPresenter(
            RegisterContract.RegisterView view,
            RegisterUseCase registerUseCase,
            SchedulersFacade schedulersFacade) {
        super(view);

        this.registerUseCase = registerUseCase;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    public void register(RegisterRequestEntity requestEntity) {
        Log.d(TAG, "Registration triggered");
        Log.d(TAG, "Username: "+requestEntity.getUsername());
        Log.d(TAG, "Password: "+requestEntity.getPassword());

        loadRegistrationResult(registerUseCase.execute(requestEntity));
    }

    private void loadRegistrationResult(Single<RegisterResponseEntity> registerResponseSingle) {
        addDisposable(registerResponseSingle
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .subscribe(view::handleRegisterResponse, view::onRegisterError)
        );
    }
}
