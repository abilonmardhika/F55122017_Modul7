package com.example.sqlite_f55122017.sqlite_f55122017;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sqlite_f55122017.AccountFragment;
import com.example.sqlite_f55122017.DashboardFragment;
import com.example.sqlite_f55122017.HomeFragment;
import com.example.sqlite_f55122017.R;
import com.example.sqlite_f55122017.databinding.ActivityContentBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContentActivity extends AppCompatActivity {
    private ActivityContentBinding binding;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    int itemId = item.getItemId();

                    if (itemId == R.id.navigation_home) {
                        fragment = new HomeFragment();
                    } else if (itemId == R.id.navigation_dashboard) {
                        fragment = new DashboardFragment();
                    } else if (itemId == R.id.navigation_account) {
                        fragment = new AccountFragment();
                    }
                    if (fragment != null) {
                        switchFragment(fragment);
                        return true;
                    }
                    return false;
                }
            };
                protected void OnCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    binding = ActivityContentBinding.inflate(getLayoutInflater());
                    setContentView(binding.getRoot());

                    binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

                    if (savedInstanceState == null) {
                        if (binding.navigation != null) {
                            binding.navigation.setSelectedItemId(R.id.navigation_home);
                        }
                    }
                }

    private void switchFragment(Fragment fragment) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_layout, fragment,
                                    fragment.getClass().getSimpleName()).
                            commit();
    }
}
