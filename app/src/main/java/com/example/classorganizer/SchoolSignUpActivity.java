package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivitySignUpSchoolBinding;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class SchoolSignUpActivity extends AppCompatActivity {

    public static final String TAG = "SchoolSignUpActivity";
    private ActivitySignUpSchoolBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up_school);

        //ParseUser currentUser = ParseUser.getCurrentUser();

        //Exposed DropDown Menu using Spinner
        ArrayList<String> school_list = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter_school;

        school_list.add("Hunter");
        school_list.add("LaGuardia");

        arrayAdapter_school = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,school_list);
        binding.autoCompleteTextView.setAdapter(arrayAdapter_school);
        binding.autoCompleteTextView.setThreshold(1);

        //Log.i(TAG, "school name is " + schoolName);
        //Log.i(TAG, "Current ID is " + ParseUser.getCurrentUser().getObjectId());

        binding.topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SchoolSignUpActivity.this, SignUpActivity.class);
                startActivity(i);
                finish();
            }
        });


        // TOGGLE
        binding.etSchoolName.setVisibility(binding.etSchoolName.GONE);
        binding.etSchoolAddress.setVisibility(binding.etSchoolAddress.GONE);

        binding.smSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    binding.etSchoolName.setVisibility(binding.etSchoolName.GONE);
                    binding.etSchoolAddress.setVisibility(binding.etSchoolAddress.GONE);
                } else{
                    binding.etSchoolName.setVisibility(binding.etSchoolName.VISIBLE);
                    binding.etSchoolAddress.setVisibility(binding.etSchoolAddress.VISIBLE);
                }
            }
        });

        // SIGNUP CONTINUE
        binding.btnUserSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String schoolName = binding.autoCompleteTextView.getText().toString();
                //saveSchool(schoolName,currentUser);
                Intent i = new Intent(SchoolSignUpActivity.this, SearchCourseActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void saveSchool(String school, ParseUser currentUser){
        School whichSchool = new School();
        whichSchool.setSchool(school);
        whichSchool.setUser(currentUser);
        whichSchool.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.e(TAG,"Error with saving!", e);
                    Toast.makeText(SchoolSignUpActivity.this, "Error with saving", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Save successful!");
            }
        });
    }

}
