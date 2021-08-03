package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivitySearchCoursesBinding;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class SearchCourseActivity extends AppCompatActivity {

    public static final String TAG = "SearchCourseActivity";
    private ActivitySearchCoursesBinding binding;

      protected void onCreate(@Nullable Bundle savedInstance) {
          super.onCreate(savedInstance);
          binding = DataBindingUtil.setContentView(this,R.layout.activity_search_courses);


          //Exposed DropDown Menu using Spinner
          ArrayList<String> course_list = new ArrayList<>();
          ArrayAdapter<String> arrayAdapter_course;

          course_list.add("CS 499");
          course_list.add("CS 335");

          arrayAdapter_course = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,course_list);
          binding.autoCompleteTextView1.setAdapter(arrayAdapter_course);
          binding.autoCompleteTextView1.setThreshold(1);

          binding.autoCompleteTextView2.setAdapter(arrayAdapter_course);
          binding.autoCompleteTextView2.setThreshold(1);

          binding.autoCompleteTextView3.setAdapter(arrayAdapter_course);
          binding.autoCompleteTextView3.setThreshold(1);


          binding.btnDone.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  String schoolName1 = binding.autoCompleteTextView1.getText().toString();
                  String schoolName2 = binding.autoCompleteTextView2.getText().toString();
                  String schoolName3 = binding.autoCompleteTextView3.getText().toString();

                  if (schoolName1 != null){
                      saveCourse(schoolName1,ParseUser.getCurrentUser());
                  }
                  if (schoolName2 != null){
                      saveCourse(schoolName2,ParseUser.getCurrentUser());
                  }
                  if (schoolName3 != null){
                      saveCourse(schoolName3,ParseUser.getCurrentUser());
                  }

                  Intent i = new Intent(SearchCourseActivity.this, MainActivity.class);
                  startActivity(i);
                  finish();
              }
          });

      }

      private void saveCourse(String course, ParseUser currentUser){
          Course currentCourses = new Course();
          currentCourses.setCourseName(course);
          currentCourses.setAuthor(currentUser);
          currentCourses.saveInBackground(new SaveCallback() {
              @Override
              public void done(ParseException e) {
                  if (e != null){
                      Log.e(TAG,"Error with saving!", e);
                      Toast.makeText(SearchCourseActivity.this, "Error with saving", Toast.LENGTH_SHORT).show();
                  }
                  Log.i(TAG, "Save successful!");
              }
          });

      }
}
