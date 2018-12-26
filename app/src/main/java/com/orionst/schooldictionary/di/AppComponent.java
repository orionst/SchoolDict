package com.orionst.schooldictionary.di;

import com.orionst.schooldictionary.di.modules.NavigationModule;
import com.orionst.schooldictionary.ui.MainActivity;
import com.orionst.schooldictionary.ui.screens.categories.CategoriesFragment;
import com.orionst.schooldictionary.ui.screens.categories.CategoriesPresenter;
import com.orionst.schooldictionary.ui.screens.wordlist.WordListFragment;
import com.orionst.schooldictionary.ui.screens.wordlist.WordListPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NavigationModule.class
})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(WordListPresenter presenter);
    void inject(CategoriesPresenter presenter);
}
