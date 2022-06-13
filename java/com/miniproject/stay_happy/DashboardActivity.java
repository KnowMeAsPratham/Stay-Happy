package com.miniproject.stay_happy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
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

import com.miniproject.stay_happy.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityDashboardBinding binding;
    ImageButton ib,ib2,ib1,ib3,ib4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarDashboard.toolbar);
        binding.appBarDashboard.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ib = findViewById(R.id.exercise);
        ib2 = findViewById(R.id.btn_psy);
        ib1 = findViewById(R.id.chat_btn);
        ib3 = findViewById(R.id.btn_music);
        ib4 = findViewById(R.id.btn_tt);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,ExerciseActivity.class);
                startActivity(intent);
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,PsycatristActivity.class);
                startActivity(intent);
            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://play.google.com/store/apps/details?id=com.woebot&referrer=utm_source%3D[%ref%]%26utm_medium%3Dwebsite");
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MusicActivity.class);
                startActivity(intent);
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,TtActivity.class);
                startActivity(intent);
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
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int i=item.getItemId();
                if(i==R.id.nav_support)
                {
                    startActivity(new Intent(DashboardActivity.this,ContactActivity.class));
                    Toast.makeText(DashboardActivity.this, "Support Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_dashboard)
                {
                    startActivity(new Intent(DashboardActivity.this,DashboardActivity.class));
                    Toast.makeText(DashboardActivity.this, "Dashboard Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_feedback)
                {
                    startActivity(new Intent(DashboardActivity.this,FeedbackActivity.class));
                    Toast.makeText(DashboardActivity.this, "Feedback Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_logout)
                {
                    startActivity(new Intent(DashboardActivity.this,LoginActivity.class));
                    Toast.makeText(DashboardActivity.this, "Logout Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }
                else if(i==R.id.nav_books)
                {
                    startActivity(new Intent(DashboardActivity.this,BooksActivity.class));
                    Toast.makeText(DashboardActivity.this, "Books Page", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}