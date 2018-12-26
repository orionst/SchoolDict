package com.orionst.schooldictionary;

import android.app.Application;

import com.orionst.schooldictionary.di.AppComponent;
import com.orionst.schooldictionary.di.DaggerAppComponent;

public final class App extends Application {
    private static App INSTANCE;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().
                    build();
        }
        return appComponent;
    }

    public static App getApp() {
        return INSTANCE;
    }
}
