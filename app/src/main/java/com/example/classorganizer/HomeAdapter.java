package com.example.classorganizer;

import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classorganizer.databinding.ItemHomeBinding;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcels;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    public static final String TAG = "HomeAdapter";

    private ItemHomeBinding binding;

    private Context context;
    private List<Course> courses;

    public HomeAdapter(Context context, List<Course> courses){
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = ItemHomeBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Course course = courses.get(position);
        holder.binding.setCourse(course);

        //  ITS WORKING
        User user = new User();
        School school = new School();
        ParseUser parseUser = course.getAuthor();

        //school.setObjectId(ParseUser.getCurrentUser().getObjectId());

        //school.setSchool(parseUser.getString(School.KEY_SCHOOL));


        //THIS WILL GET THE OBJECTID FROM COURSE
        //school.setObjectId(course.getObjectId());
        //Log.i(TAG,"School test "+ school.getObjectId());

        //Log.i(TAG,"Course test "+ course.getAuthor().getObjectId());


        //Log.i(TAG,"School test "+ school.getSchool());

        user.setObjectID(ParseUser.getCurrentUser().getObjectId());
        user.setFirstName(parseUser.getString(User.KEY_FIRST_NAME));
        user.setLastName(parseUser.getString(User.KEY_LAST_NAME));
        //user.setSchoolID(parseUser.getString(User.KEY_SCHOOL_ID));
        //Log.i(TAG, "testing id " + ParseUser.getCurrentUser().getObjectId());

        Log.i(TAG,"User ID test "+ user.getKeyObjectID());


        //THIS WILL GET THE SCHOOLID FROM COURSE
        ParseObject testschool = course.getParseObject("SchoolID");
        Log.i(TAG,"Course to school pointer test "+ testschool.getObjectId());

        Toast.makeText(context,"Welcome " + user.getFirstName() + " " + user.getLastName() + "!", Toast.LENGTH_SHORT).show();

        //Intent i = new Intent(context, MainActivity.class);
        //i.putExtra("user", Parcels.wrap(user));

        holder.binding.setUser(user);

        //COMPARISON, THIS WILL ONLY RETURN THE COURSES LINKED TO THE USER ID
        String userKey = user.getKeyObjectID();
        String courseKey = course.getAuthor().getObjectId();
        Log.i(TAG, "userKey " + userKey + " courseKey " + courseKey);
        if (userKey.equals(courseKey)){
            binding.tvCourse.setText(course.getCourseName());
        }

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ItemHomeBinding binding;

        public ViewHolder(ItemHomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void clear(){
            courses.clear();
            notifyDataSetChanged();
        }

        public void addAll(List<Course> list){
            courses.addAll(list);
            notifyDataSetChanged();
        }
    }


}
