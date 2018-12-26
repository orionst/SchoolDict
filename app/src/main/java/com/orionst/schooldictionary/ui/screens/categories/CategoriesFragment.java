package com.orionst.schooldictionary.ui.screens.categories;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.orionst.schooldictionary.App;
import com.orionst.schooldictionary.R;
import com.orionst.schooldictionary.ui.common.BackButtonListener;

public class CategoriesFragment extends MvpAppCompatFragment implements CategoriesView, BackButtonListener {
    private static final String PARAM_EDIT_CATEGORY = "editable_category";

    private String mEditGategory;

    @InjectPresenter CategoriesPresenter presenter;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    public static CategoriesFragment newInstance(String edit_category) {
        CategoriesFragment fragment = new CategoriesFragment();
        Bundle args = new Bundle();
        args.putString(PARAM_EDIT_CATEGORY, edit_category);
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    CategoriesPresenter providePresenter() {
        CategoriesPresenter presenter = new CategoriesPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEditGategory = getArguments().getString(PARAM_EDIT_CATEGORY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_categories, container, false);
        return layout;
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
