package com.example.classorganizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.classorganizer.databinding.ActivityDetailsBinding;

import java.lang.reflect.Array;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.util.ArrayList;

public class ClassDetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    //vars
    private ArrayList<String> nameOfCourses = new ArrayList<>();
    private ArrayList<String> nameOfAssignments = new ArrayList<>();


    //BACK BUTTON
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackHome();
            }
        });

        initRecyclerView();

        //call the function that uses Parse server here
        // Call initRecyclerView function inside this function that takes from Parse server
    }

    public void goBackHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //Get from Parse server Assignments here into these lists.


    //set up the actual Recycler View to appear on Assignments
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        AssignmentRecycler adapter = new AssignmentRecycler(nameOfCourses, nameOfAssignments, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
    }

}