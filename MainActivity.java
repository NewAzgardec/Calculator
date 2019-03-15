package com.example.vkpage;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(navigationListener);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final HeaderView headerView = navigationView.getHeaderView(0).findViewById(R.id.header_view);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = generateColor();
                headerView.updateImage(color);
            }
        });


    }

    private String generateColor() {
        Random random = new Random();
        int colorCode = random.nextInt(0xffffff + 1);
        String color = String.format("#%06x", colorCode);

        return color;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }

    protected NavigationView.OnNavigationItemSelectedListener navigationListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.navigation_messages:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MessageFragment());
                    break;

                case R.id.navigation_friends:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FriendsFragment()).commit();
                    break;

                case R.id.navigation_gallery:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new GalleryFragment()).commit();
                    break;
                case R.id.navigation_settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new GalleryFragment()).commit();
                    break;
                default:
                    break;
            }

            drawer.closeDrawer(GravityCompat.START);

            return true;
        }
    };
}





