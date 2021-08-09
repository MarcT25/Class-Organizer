package com.example.classorganizer;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.classorganizer.databinding.ActivityEditCourseBinding;
import com.example.classorganizer.fragments.calendarFragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.Calendar;

public class EditCourse extends AppCompatActivity {

    public static final String TAG = "EditCourse";

    private ActivityEditCourseBinding binding;

    DatePickerDialog.OnDateSetListener setListener;
    ParseUser user = ParseUser.getCurrentUser();

    private TextInputEditText event;
    private TextInputEditText date1;
    private TextInputEditText date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_course);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        event = binding.etEventNameField;

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

        date1 = binding.etDate;
        date2 = binding.etDate1;

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to the Event Class
                saveEvent(event.getText().toString(), date1.getText().toString(), date2.getText().toString(),
                        user
                );
                Intent i = new Intent(EditCourse.this, calendarFragment.class);
                finish();
            }
        });
    }

    private void saveEvent(String eventText, String dateStart, String dateEnd,
                           ParseUser currentUser
    ){
        //using value inside
        Event whichEvent = new Event();
        whichEvent.setKeyEventTitle(eventText);
        whichEvent.setKeyEventStart(dateStart);
        whichEvent.setKeyEventEnd(dateEnd);
        whichEvent.setAuthor(currentUser);

        whichEvent.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                    Log.e(TAG,"Error with saving!", e);
                    Toast.makeText(EditCourse.this, "Error with saving", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Save successful!");
                Toast toast = Toast.makeText(EditCourse.this, "Saved!",Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }


}


