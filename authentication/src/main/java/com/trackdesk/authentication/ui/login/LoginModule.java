package com.trackdesk.authentication.ui.login;

import com.trackdesk.authentication.rx.SchedulersFacade;
import com.trackdesk.data.login.LoginRepositoryImpl;
import com.trackdesk.domain.repositories.LoginRepository;
import com.trackdesk.domain.usecases.LoginUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {
    @Provides
    LoginRepository getLoginRepository() {
        return new LoginRepositoryImpl();
    }

    @Provides
    LoginPresenter getLoginPresenter(LoginContract.LoginView view,
                                     LoginUseCase loginUseCase,
                                     SchedulersFacade schedulersFacade) {
        return new LoginPresenter(view, loginUseCase, schedulersFacade);
    }
}
