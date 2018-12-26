package com.orionst.schooldictionary.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {
    private Cicerone<Router> cicerone;

    public NavigationModule() {
        this.cicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    public NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    public Router provideRouter() {
        return cicerone.getRouter();
    }

}
