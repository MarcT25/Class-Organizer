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
        //this.users = users;
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
        ParseUser parseUser = course.getAuthor();

        user.setObjectID(ParseUser.getCurrentUser().getObjectId());
        user.setFirstName(parseUser.getString(User.KEY_FIRST_NAME));
        user.setLastName(parseUser.getString(User.KEY_LAST_NAME));
        //Log.i(TAG,"first name test "+ user.getFirstName());

        Toast.makeText(context,"Welcome " + user.getFirstName() + " " + user.getLastName() + "!", Toast.LENGTH_SHORT).show();

        //Intent i = new Intent(context, MainActivity.class);
        //i.putExtra("user", Parcels.wrap(user));

        holder.binding.setUser(user);
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
