package com.example.classorganizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.view.LayoutInflater;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import com.example.classorganizer.databinding.ActivityDetailsBinding;
import com.example.classorganizer.Course;
import com.example.classorganizer.Assignment;
import com.example.classorganizer.AssignmentAdapter;
import com.example.classorganizer.R;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ClassDetailsActivity extends AppCompatActivity {

    public static final String TAG = "ClassDetailsActivity";

    private ActivityDetailsBinding binding;

    //vars
    protected AssignmentAdapter adapter;
    protected List<Assignment> allAssignments;
    //protected List<Course> allCourses;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        // Inflate the layout for this
//        return inflater.inflate(R.layout.assignment_list_item, container, false);
//    }

    //protected void onViewCreated()

    //BACK BUTTON
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);


        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackHome();
            }
        });

        //instantiate all courses to be a new 'arraylist'
        //adapter will now be 'matched' with the assignmentAdapter to the new list
        allAssignments = new ArrayList<>();
        adapter = new AssignmentAdapter(this, allAssignments);

        //we bind the adapter to the recyclerview so that things will actually show
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this );
        binding.recyclerView.setLayoutManager(layoutManager);

    }

    public void goBackHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    
}