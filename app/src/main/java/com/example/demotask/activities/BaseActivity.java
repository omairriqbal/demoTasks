package com.example.demotask.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.demotask.R;
import com.example.demotask.fragments.homeModule.HomeFragment;
import com.example.demotask.fragments.serviceModule.ServiceFragment;
import com.example.demotask.fragments.postModule.PostFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        initializeView();
        initializeDefaultFragment(savedInstanceState,0);
        toggleDrawer();
    }


    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex).setChecked(true);
            onNavigationItemSelected(menuItem);
        }
    }

    private void initializeView() {
        toolbar = findViewById(R.id.toolbar_id);
        toolbar.setTitle(R.string.dashBoard);
        setSupportActionBar(toolbar);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        drawerLayout = findViewById(R.id.drawer_layout_id);



        navigationView = findViewById(R.id.navigationview_id);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public void onBackPressed() {
        //Checks if the navigation drawer is open -- If so, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        // If drawer is already close -- Do not override original functionality
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_home_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HomeFragment()).commit();
                toolbar.setTitle("Home Fragment");
               bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                closeDrawer();
                break;
            case R.id.nav_service_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ServiceFragment())
                        .commit();
                toolbar.setTitle("Service Fragment");
               bottomNavigationView.setSelectedItemId(R.id.navigation_service);
                closeDrawer();
                break;

            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HomeFragment())
                        .commit();
                toolbar.setTitle("Home Fragment");
                closeDrawer();
                break;
            case R.id.navigation_service:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new ServiceFragment())
                        .commit();
                toolbar.setTitle("Service Fragment");
                closeDrawer();
                break;
            case R.id.navigation_post:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new PostFragment())
                        .commit();
                toolbar.setTitle("Post Fragment");
                closeDrawer();
                break;

        }
        return true;
    }
}