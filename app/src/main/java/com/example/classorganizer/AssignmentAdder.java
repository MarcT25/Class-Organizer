package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.security.identity.IdentityCredential;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivityAddAssignmentBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class AssignmentAdder extends AppCompatActivity {
    public static final String TAG = "AssignmentAdder";

    private ActivityAddAssignmentBinding binding;

    private Button btnSubmitAssignment;
    private TextInputLayout editAssignment;

    ParseUser user = ParseUser.getCurrentUser();

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
                Log.d(TAG, "onClick: " + editAssignment.getEditText().getText().toString());

                saveAssignment(editAssignment.getEditText().getText().toString(),
                        user
                );
                Intent j = new Intent(AssignmentAdder.this, ClassDetailsActivity.class);
                startActivity(j);
                finish();
            }
        });

    }

    private void saveAssignment(String assignment,
                                ParseUser currentUser
    ){
        //using value inside
        Assignment whichAssignment = new Assignment();
        whichAssignment.setAssignment(assignment);
        whichAssignment.setAuthor(currentUser);

        whichAssignment.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.e(TAG,"Error with saving!", e);
                    Toast.makeText(AssignmentAdder.this, "Error with saving", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Save successful!");
                Toast toast = Toast.makeText(AssignmentAdder.this, "Saved!",Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}


