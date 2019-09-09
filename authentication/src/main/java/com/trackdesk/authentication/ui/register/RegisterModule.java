package com.trackdesk.authentication.ui.register;

import com.trackdesk.authentication.rx.SchedulersFacade;
import com.trackdesk.data.register.RegisterRepositoryImpl;
import com.trackdesk.domain.repositories.RegisterRepository;
import com.trackdesk.domain.usecases.RegisterUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterModule {
    @Provides
    RegisterRepository getRegisterRepository() {
        return new RegisterRepositoryImpl();
    }

    @Provides
    RegisterPresenter getRegisterPresenter(RegisterContract.RegisterView view,
                                           RegisterUseCase registerUseCase,
                                           SchedulersFacade schedulersFacade) {
        return new RegisterPresenter(view, registerUseCase, schedulersFacade);
    }
}
