package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivityAddAssignmentBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class AssignmentAdder extends AppCompatActivity {
    public static final String TAG = "AssignmentAdder";

    private ActivityAddAssignmentBinding binding;

    private Button btnSubmitAssignment;
    private TextInputLayout editAssignment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_assignment);

        editAssignment = binding.etAssignment;
        btnSubmitAssignment = binding.btnSubmit;

        //back button
        binding.topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AssignmentAdder.this, ClassDetailsActivity.class);
                startActivity(i);
                finish();
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call query button here to submit
                Intent j = new Intent(AssignmentAdder.this, ClassDetailsActivity.class);
                startActivity(j);
                finish();
            }
        });

    }

}