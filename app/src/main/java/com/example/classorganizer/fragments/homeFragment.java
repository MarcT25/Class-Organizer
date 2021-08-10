package com.example.classorganizer.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classorganizer.ClassDetailsActivity;
import com.example.classorganizer.Course;
import com.example.classorganizer.EditCourse;
import com.example.classorganizer.HomeAdapter;
import com.example.classorganizer.R;
import com.example.classorganizer.User;
import com.example.classorganizer.databinding.FragmentHomeBinding;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {

    public static final String TAG = "homeFragment";

    protected HomeAdapter adapter;
    protected List<Course> allCourses;
    protected List<User> allUsers;
    private FragmentHomeBinding binding;

    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = binding.bind(view);

        //instantiate all courses to be a new 'arraylist'
        //adapter will now be 'matched' with the homeadapter to the new list
        allCourses = new ArrayList<>();
        adapter = new HomeAdapter(getContext(), allCourses);

        //we bind the adapter to the recyclerview so that things will actually show
        binding.rvCourse.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rvCourse.setLayoutManager(layoutManager);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ClassDetailsActivity.class);
                startActivity(i);
                //finish();             //Since this is a fragment, it will automatically 'finish' for us.
            }
        });
        queryCourse();
    }

    private void queryCourse(){
        ParseQuery<Course> query = ParseQuery.getQuery(Course.class);
        query.include(Course.KEY_USER);
        query.include(User.KEY_FIRST_NAME);

        query.findInBackground(new FindCallback<Course>() {
            @Override
            public void done(List<Course> objects, ParseException e) {
                if (e!= null){
                    Log.e(TAG,"error with fetching courses", e);
                    return;
                }
                for (Course course : objects){
                    Log.i(TAG, "ITS WORKINGS: " + course.getCourseName() + " " + course.getAuthor().getUsername());
                }
                allCourses.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        });
    }
}