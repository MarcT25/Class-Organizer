package com.example.classorganizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import fragments.calendarFragment;
import fragments.contactsFragment;
import fragments.homeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.classorganizer.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Button classDetails;

    private ActivityMainBinding binding;


    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        classDetails = (Button) findViewById(R.id.button);
        classDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClassDetails();
            }
        });
       /*
       binding.btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               logOut();
           }
       }); */

        //listener for navigation bar, will switch to a new fragment depending on what menu item bottom is pressed, if logout is pressed it will logout the section.
        binding.nvNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch(item.getItemId()) {
                    //TODO: update fragment.
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        fragment = new homeFragment();
                        break;
                    case R.id.contacts:
                        Toast.makeText(MainActivity.this, "Contacts", Toast.LENGTH_SHORT).show();
                        fragment = new contactsFragment();
                        break;
                    case R.id.calendar:
                        Toast.makeText(MainActivity.this, "Calendar", Toast.LENGTH_SHORT).show();
                        fragment = new calendarFragment();
                        break;
                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                        logOut();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        //defaults to the homepage after logging in.
        binding.nvNavigation.setSelectedItemId(R.id.home);

    }

        private void logOut () {
            ParseUser.logOut();
            ParseUser currentUser = ParseUser.getCurrentUser();

            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }

        public void openClassDetails() {
            Intent intent = new Intent(this, ClassDetailsActivity.class);
            startActivity(intent);
        }


    }
