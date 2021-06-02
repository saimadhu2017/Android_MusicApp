package com.saimadhukalluri.music.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.saimadhukalluri.music.R;
import com.saimadhukalluri.music.fragment.AboutFragment;
import com.saimadhukalluri.music.fragment.FavouriteFragment;
import com.saimadhukalluri.music.fragment.HomeFragment;
import com.saimadhukalluri.music.fragment.ProfileFragment;

public class Home extends AppCompatActivity {
    DrawerLayout drawer_layout;
    CoordinatorLayout coordinator_layout;
    Toolbar tool_bar;
    FrameLayout frame_layout;
    NavigationView navigation_drawer;
    MenuItem prevItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        drawer_layout = findViewById(R.id.drawer_layout);
        coordinator_layout = findViewById(R.id.coordinator_layout);
        tool_bar = findViewById(R.id.tool_bar);
        frame_layout = findViewById(R.id.frame_layout);
        navigation_drawer = findViewById(R.id.navigation_drawer);

        setUpToolBar();
        openHome();


        ActionBarDrawerToggle hamburgerIcon = new ActionBarDrawerToggle(this, drawer_layout, R.string.open_Drawer, R.string.close_Drawer);
        drawer_layout.addDrawerListener(hamburgerIcon);
        hamburgerIcon.syncState();

        navigation_drawer.setNavigationItemSelectedListener(item -> {
            if (prevItem != null) {
                prevItem.setChecked(false);
            }
            item.setChecked(true);
            prevItem = item;

            switch (item.getItemId()) {
                case R.id.menu_item_home:
                    openHome();
                    break;
                case R.id.menu_item_favourite:
                    openFavourites();
                    break;
                case R.id.menu_item_profile:
                    openProfile();
                    break;
                case R.id.menu_item_about:
                    openAbout();
                    break;
            }
            return (true);
        });
    }

    //setting up the toolbar as actionbar
    void setUpToolBar() {
        setSupportActionBar(tool_bar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //setting on click listener on hamburger Icon
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawer_layout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    //setting up onBack function when clicked on back button which is home button
    @Override
    public void onBackPressed() {
        Fragment fragId = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (fragId instanceof HomeFragment) {
            super.onBackPressed();
        } else {
            prevItem.setChecked(false);
            openHome();
        }
    }

    //creating or opening the fragments
    void openHome() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new HomeFragment())
                .commit();
        drawer_layout.closeDrawers();
        getSupportActionBar().setTitle("Home");
        navigation_drawer.setCheckedItem(R.id.menu_item_home);
        prevItem = navigation_drawer.getCheckedItem();
    }

    void openFavourites() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new FavouriteFragment())
                .commit();
        drawer_layout.closeDrawers();
        getSupportActionBar().setTitle("Favourites");
    }

    void openProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new ProfileFragment())
                .commit();
        drawer_layout.closeDrawers();
        getSupportActionBar().setTitle("Profile");
    }

    void openAbout() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new AboutFragment())
                .commit();
        drawer_layout.closeDrawers();
        getSupportActionBar().setTitle("About");
    }
}