package com.example.classorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivitySearchCoursesBinding;

public class SearchCourseActivity extends AppCompatActivity {

    public static final String TAG = "SearchCourseActivity";
    private ActivitySearchCoursesBinding binding;

      protected void onCreate(@Nullable Bundle savedInstance) {
          super.onCreate(savedInstance);
          binding = DataBindingUtil.setContentView(this,R.layout.activity_search_courses);


          binding.btnDone.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(SearchCourseActivity.this, MainActivity.class);
                  startActivity(i);
                  finish();
              }
          });

      }
}
