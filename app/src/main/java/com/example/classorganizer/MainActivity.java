package com.example.classorganizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.classorganizer.fragments.calendarFragment;
import com.example.classorganizer.fragments.contactsFragment;
import com.example.classorganizer.fragments.homeFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.classorganizer.databinding.ActivityMainBinding;
import com.example.classorganizer.fragments.logoutFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private android.widget.Button button;

    public static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    //private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FragmentManager fragmentManager = getSupportFragmentManager();        //this needs to be called AFTER onCreate, not before.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        /*
        ParseUser parseUser = Parcels.unwrap(getIntent().getParcelableExtra("ParseUser"));
        User user = Parcels.unwrap(getIntent().getParcelableExtra("user"));
        binding.setUser(user);
         */

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
                        Toast.makeText(MainActivity.this, "log out", Toast.LENGTH_SHORT).show();
                        fragment = new logoutFragment();
                        logOut();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        //defaults to the homepage after logging in.
        binding.nvNavigation.setSelectedItemId(R.id.home);

        //querySchool();
        //queryuser();

        //ParseUser currentUser = ParseUser.getCurrentUser();
        //Log.i(TAG,"testing " + currentUser.getObjectId());

    }

    /*
        Conditional checks to prevent a nonvalid user from logging off and thus, crashing the app.
     */
        private void logOut () {
            ParseUser currentUser = ParseUser.getCurrentUser();
            if (currentUser != null){
                ParseUser.logOut();
            } else if (currentUser == null){
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }

/*
        private void querySchool(){
            ParseUser currentUser = ParseUser.getCurrentUser();
            ParseQuery<School> query = ParseQuery.getQuery(School.class);
            query.include(School.KEY_USER);
            //query.whereEqualTo(School.KEY_USER, currentUser.getObjectId());
            query.findInBackground(new FindCallback<School>() {
                @Override
                public void done(List<School> objects, ParseException e) {
                    if (e!=null){
                        Log.e(TAG, "issue with getting school", e);
                        return;
                    }
                    for (School school : objects){
                        Log.i(TAG, "School " + school.getSchool());
                        Log.i(TAG, "School " + school.getUser().getUsername());
                        Log.i(TAG, "School " + school.getUser().getEmail());

                    }
                }
            });
        }


        private void queryuser(){
            ParseUser currentUser = ParseUser.getCurrentUser();
            ParseQuery<User> query = ParseQuery.getQuery(User.class);
            //query.whereEqualTo(User.KEY_OBJECT_ID, currentUser.getObjectId());
            query.include(User.KEY_OBJECT_ID);
            query.findInBackground(new FindCallback<User>() {
                @Override
                public void done(List<User> objects, ParseException e) {
                    if (e!=null){
                        Log.e(TAG, "issue with getting school", e);
                        return;
                    }
                    for (User user : objects)
                        Log.i(TAG, "School " + user.getFirstName());
                }
            });

        }

 */
    }
