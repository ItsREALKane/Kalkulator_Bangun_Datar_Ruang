package com.example.kalbangun;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.kalbangun.fragment.fragment_datar;
import com.example.kalbangun.fragment.fragment_profile;
import com.example.kalbangun.fragment.fragment_ruang;
import com.example.kalbangun.fragment.profile1;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


            bottomNavigationView = findViewById(R.id.bottom_navigation_view);
            bottomNavigationView.setOnItemSelectedListener(navListener);

            // Load the default fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new fragment_datar())
                    .commit();
        }
        private com.google.android.material.bottomnavigation.BottomNavigationView.OnItemSelectedListener navListener =
                new BottomNavigationView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        if (item.getItemId() == R.id.menu_item1) {
                            selectedFragment = new fragment_datar();
                        } else if (item.getItemId() == R.id.menu_item2) {
                            selectedFragment = new fragment_ruang();
                        } else if (item.getItemId() == R.id.menu_item3) {
                            selectedFragment = new profile1();
                        }

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container, selectedFragment)
                                .commit();

                        return true;
                    }
                };
}