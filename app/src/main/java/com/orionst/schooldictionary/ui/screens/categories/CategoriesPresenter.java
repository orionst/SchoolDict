package com.orionst.schooldictionary.ui.screens.categories;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class CategoriesPresenter extends MvpPresenter<CategoriesView> {

    @Inject Router router;

    public void onBackPressed() {
        router.exit();
    }
}
