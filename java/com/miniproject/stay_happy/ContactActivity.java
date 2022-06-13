package com.miniproject.stay_happy;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.miniproject.stay_happy.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarContact.toolbar);
        binding.appBarContact.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_contact);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i=item.getItemId();
                if(i==R.id.nav_dashboard)
                {
                    startActivity(new Intent(ContactActivity.this,DashboardActivity.class));
                    Toast.makeText(ContactActivity.this, "Support Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_support)
                {
                    startActivity(new Intent(ContactActivity.this,ContactActivity.class));
                    Toast.makeText(ContactActivity.this, "Support Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_feedback)
                {
                    startActivity(new Intent(ContactActivity.this,FeedbackActivity.class));
                    Toast.makeText(ContactActivity.this, "Feedback Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_logout)
                {
                    startActivity(new Intent(ContactActivity.this,LoginActivity.class));
                    Toast.makeText(ContactActivity.this, "Logout Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contact, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_contact);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}