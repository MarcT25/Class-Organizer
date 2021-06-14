package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivityLoginBinding;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";       //TESTING PURPOSES

    ParseUser user = new ParseUser();

    //This is databinding, if you are unfamiliar how to use this then refer to boilerplate
    private ActivityLoginBinding binding;
    /*
        To call a specific layout variable, simply do binding.*   with * being whatever the layout variable is called
        Example:  binding.etUsername.getText().toString();
               --> gets the text in string form from etUsername
     */

    //CREATES THE ACTUAL VIEW SO YOU CAN SEE IT
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //THIS IS JUST FOR DATA BINDING, IF YOU ARE NOT USING DATA BINDING THEN YOU CAN FORGO THE PREFIX
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        //If the current user is 'signed in', then go straight to the main page
        if (ParseUser.getCurrentUser() != null){
            goMainActivity();
            return;
        }

        binding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Login works");

                String username = binding.etUsername.getText().toString();
                String password = binding.etPassword.getText().toString();

                loginUser(username, password);

            }
        });


    }


    //Call function to go to the main activity page
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    //Login Function
    private void loginUser(String username, String password){
        Log.i(TAG, "Login works!");

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    Log.i(TAG, "Login failed!", e);
                    Toast.makeText(LoginActivity.this, "PLEASE CHECK LOGIN FOR ISSUE", Toast.LENGTH_SHORT).show();
                    return;
                }
                //on success
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }

}
