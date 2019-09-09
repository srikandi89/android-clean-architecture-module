package com.trackdesk.authentication.di;

import android.content.Context;

import com.trackdesk.authentication.App;

import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}