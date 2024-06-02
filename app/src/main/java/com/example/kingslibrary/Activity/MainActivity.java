package com.example.kingslibrary.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kingslibrary.Fragment.BookmarkFragment;
import com.example.kingslibrary.Fragment.HomeFragment;
import com.example.kingslibrary.Fragment.AboutFragment;
import com.example.kingslibrary.Fragment.SearchFragment;
import com.example.kingslibrary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private BottomNavigationView bottomnav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.frame);
        bottomnav = findViewById(R.id.bottomnav);

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if (itemId == R.id.home) {
                    loadFragment(new HomeFragment(), false);

                } else if (itemId == R.id.bookmark) {
                    loadFragment(new BookmarkFragment(), false);

                }  else if (itemId == R.id.search) {
                    loadFragment(new SearchFragment(), false);

                } else {
                    loadFragment(new AboutFragment(), false);
                }

                return true;
            }
        });

        loadFragment(new HomeFragment(), true);

    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frame, fragment);
        } else {
            fragmentTransaction.replace(R.id.frame, fragment);
        }

        fragmentTransaction.commit();
    }
}