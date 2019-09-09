package com.trackdesk.authentication.di;

import com.trackdesk.authentication.ui.login.LoginActivity;
import com.trackdesk.authentication.ui.login.LoginModule;
import com.trackdesk.authentication.ui.login.LoginViewModule;
import com.trackdesk.authentication.ui.register.RegisterActivity;
import com.trackdesk.authentication.ui.register.RegisterModule;
import com.trackdesk.authentication.ui.register.RegisterViewModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuilderModule {
    @ContributesAndroidInjector(modules = {LoginViewModule.class, LoginModule.class})
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {RegisterViewModule.class, RegisterModule.class})
    abstract RegisterActivity bindRegisterActivity();
}
