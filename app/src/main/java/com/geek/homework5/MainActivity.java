package com.geek.homework5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.geek.homework5.databinding.ActivityMainBinding;
import com.geek.homework5.fragments.DashFragment;
import com.geek.homework5.fragments.HomeFragment;
import com.geek.homework5.fragments.NotifFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private HomeFragment homeFragment = new HomeFragment();
    private DashFragment dashFragment = new DashFragment();
    private NotifFragment notifFragment = new NotifFragment();

    private FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        setSupportActionBar(binding.toolbar);
        binding.btnNav.setOnNavigationItemSelectedListener(listener);

        fm.beginTransaction().add(R.id.fm_container, notifFragment, "Notification").hide(notifFragment).commit();
        fm.beginTransaction().add(R.id.fm_container, dashFragment, "Dashboard").hide(dashFragment).commit();
        fm.beginTransaction().add(R.id.fm_container, homeFragment).hide(notifFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            item -> {
                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        fm.beginTransaction().hide(active).show(homeFragment).commit();
                        active = homeFragment;
                        return true;
                    case R.id.dashboard_fragment:
                        fm.beginTransaction().hide(active).show(dashFragment).commit();
                        active = dashFragment;
                        return true;
                    case R.id.natification_fragment:
                        fm.beginTransaction().hide(active).show(notifFragment).commit();
                        active = notifFragment;
                        return true;
                }

                return false;
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tullbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void hideBottonNav() {
        binding.btnNav.setVisibility(View.GONE);

    }

    public void showBottonNav() {
        binding.btnNav.setVisibility(View.VISIBLE);

    }

}