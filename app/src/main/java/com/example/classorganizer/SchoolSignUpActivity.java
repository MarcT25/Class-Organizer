package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivitySignUpSchoolBinding;

public class SchoolSignUpActivity extends AppCompatActivity {

    public static final String TAG = "SchoolSignUpActivity";
    private ActivitySignUpSchoolBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up_school);

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
                Intent i = new Intent(SchoolSignUpActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
