package com.orionst.schooldictionary.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.orionst.schooldictionary.App;
import com.orionst.schooldictionary.R;
import com.orionst.schooldictionary.navigation.Screens;
import com.orionst.schooldictionary.ui.common.BackButtonListener;
import com.orionst.schooldictionary.ui.screens.wordlist.WordListView;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

public class MainActivity extends AppCompatActivity {

    @Inject Router router;
    @Inject NavigatorHolder navigatorHolder;

    private Navigator navigator = new SupportAppNavigator(this, R.id.main_container) {
        @Override
        public void applyCommands(Command[] commands) {
            super.applyCommands(commands);
            getSupportFragmentManager().executePendingTransactions();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getApp().getAppComponent().inject(this);

        if (savedInstanceState == null) {
            navigator.applyCommands(new Command[]{new Replace(new Screens.MainListScreen())});
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
        if (fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            super.onBackPressed();
        }
    }

}
