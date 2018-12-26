package com.orionst.schooldictionary.navigation;

import android.support.v4.app.Fragment;

import com.orionst.schooldictionary.ui.screens.categories.CategoriesFragment;
import com.orionst.schooldictionary.ui.screens.wordlist.WordListFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class MainListScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return WordListFragment.newInstance();
        }
    }

    public static final class CategoryEditScreen extends SupportAppScreen {
        private final String categoryTitle;

        public CategoryEditScreen(String categoryTitle) {
            this.categoryTitle = categoryTitle;
        }

        @Override
        public Fragment getFragment() {
            return CategoriesFragment.newInstance(categoryTitle);
        }
    }
}
