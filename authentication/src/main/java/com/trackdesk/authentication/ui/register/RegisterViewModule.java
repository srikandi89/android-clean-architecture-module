package com.trackdesk.authentication.ui.register;

import dagger.Binds;
import dagger.Module;

@Module
public interface RegisterViewModule {
    @Binds
    RegisterContract.RegisterView provideRegisterView(RegisterActivity activity);
}
