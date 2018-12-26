package com.orionst.schooldictionary.ui.screens.wordlist;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.orionst.schooldictionary.navigation.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class WordListPresenter extends MvpPresenter<WordListView> {

    @Inject Router router;

    void onBackCommandClick() {
        router.exit();
    }

    public void moveToCategoryEditScreen(CharSequence categoryTitle) {
        router.navigateTo(new Screens.CategoryEditScreen(categoryTitle.toString()));
    }
}
