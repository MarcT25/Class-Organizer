package com.example.classorganizer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivityEditCourseBinding;
import com.example.classorganizer.fragments.calendarFragment;

import java.util.Calendar;

public class EditCourse extends AppCompatActivity {

    private ActivityEditCourseBinding binding;

    int t1Hour,t1Minute,t2Hour,t2Minute;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_course);

        binding.tvTimer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        EditCourse.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t1Hour, t1Minute);
                                binding.tvTimer1.setText(DateFormat.format("hh:mm:aa", calendar));

                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });


        binding.tvTimer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(EditCourse.this,"On Click!",Toast.LENGTH_SHORT).show();
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        EditCourse.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(0, 0, 0, t1Hour, t1Minute);
                                binding.tvTimer2.setText(DateFormat.format("hh:mm:aa", calendar));

                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        binding.etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        EditCourse.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        binding.etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        binding.etDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        EditCourse.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        binding.etDate1.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to the Event Class
                Intent i = new Intent(EditCourse.this, calendarFragment.class);
                finish();
            }
        });
    }



}
