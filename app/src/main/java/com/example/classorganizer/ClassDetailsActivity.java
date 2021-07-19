package com.example.classorganizer;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.classorganizer.databinding.ActivityDetailsBinding;

import java.lang.reflect.Array;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class ClassDetailsActivity extends AppCompatActivity {

    public static final String TAG = "ClassDetailsActivity";

    private ActivityDetailsBinding binding;

    //vars
    private ArrayList<String> nameOfCourses = new ArrayList<>();
    private ArrayList<String> nameOfAssignments = new ArrayList<>();
    protected List<Course> allCourses;

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

        //Line 115 seems to be an issue with null object reference, I probably did something wrong.
        queryAssignments();
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

    private void queryAssignments() {
        ParseQuery<Assignment> query = ParseQuery.getQuery(Assignment.class);
        ParseQuery<Course> courseQuery = ParseQuery.getQuery(Course.class);

        query.include(Assignment.KEY_USER);
        courseQuery.include(Course.KEY_USER);

        //I borrowed this query method to get all courses into the allCourses.
        courseQuery.findInBackground(new FindCallback<Course>() {
            @Override
            public void done(List<Course> objects, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "error with fetching courses", e);
                    return;
                }
                for (Course course : objects) {
                    Log.i(TAG, "ITS WORKINGS: " + course.getKeyObjectID());
                }
                allCourses.addAll(objects);
            }
        });

        query.findInBackground(new FindCallback<Assignment>() {
            @Override
            public void done(List<Assignment> objects, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "error with fetching courses", e);
                    return;
                }
                for (Assignment assignment : objects) {
                    Log.i(TAG, "ITS WORKINGS: " + assignment.getAssignment());
                    nameOfAssignments.add(assignment.getAssignment());

                    //This for-loop is the lazy workaround to get the correct courseID to the Assignment's courseID.
                    for(Course course : allCourses){
                        if(assignment.getKeyCourseID() == course.getKeyObjectID()){
                           nameOfCourses.add(course.getCourseName());
                        }
                    }
                }

            }
        });
    }

}