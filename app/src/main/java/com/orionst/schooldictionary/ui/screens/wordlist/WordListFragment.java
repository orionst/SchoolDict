package com.orionst.schooldictionary.ui.screens.wordlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.orionst.schooldictionary.App;
import com.orionst.schooldictionary.R;
import com.orionst.schooldictionary.ui.MainActivity;
import com.orionst.schooldictionary.ui.common.BackButtonListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

public class WordListFragment extends MvpAppCompatFragment implements WordListView, BackButtonListener {

    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nvView) NavigationView nvDrawer;
    @BindView(R.id.root_container) CoordinatorLayout rootView;
    private ActionBarDrawerToggle drawerToggle;

    @InjectPresenter WordListPresenter presenter;

    public WordListFragment() {
        // Required empty public constructor
    }

    public static WordListFragment newInstance() {
        WordListFragment fragment = new WordListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    WordListPresenter providePresenter() {
        WordListPresenter presenter = new WordListPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.fragment_word_list, container, false);

        ButterKnife.bind(this, layout);

        setupDrawerContent(nvDrawer);

        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        return layout;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.top_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_item_app_bar_search:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_item_main:
                break;
//            case R.id.nav_second_fragment:
//                fragmentClass = SecondFragment.class;
//                break;
            case R.id.nav_item_add_category:
                presenter.moveToCategoryEditScreen(menuItem.getTitle());
                break;
        }
        menuItem.setChecked(true);
        drawer.closeDrawer(GravityCompat.START);
    }


    @Override
    public boolean onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            presenter.onBackCommandClick();
        }
        return true;
    }
}
