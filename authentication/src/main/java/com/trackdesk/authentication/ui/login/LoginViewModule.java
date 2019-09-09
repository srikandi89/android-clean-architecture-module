package com.trackdesk.authentication.ui.login;

import dagger.Binds;
import dagger.Module;

@Module
public interface LoginViewModule {
    @Binds
    LoginContract.LoginView provideLoginView(LoginActivity activity);
}
