package com.example.classorganizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.classorganizer.databinding.ActivityMainBinding;
import com.parse.ParseUser;


//marcos
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.nvNavigation.getMenu().findItem(R.id.logout).setOnMenuItemClickListener(menuItem -> {
            logOut();
            return true;

        });
    }

        private void logOut () {
            ParseUser.logOut();
            ParseUser currentUser = ParseUser.getCurrentUser();

            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        }


    }