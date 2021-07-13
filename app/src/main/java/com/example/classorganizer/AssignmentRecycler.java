package com.example.classorganizer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AssignmentRecycler extends RecyclerView.Adapter<AssignmentRecycler.ViewHolder> {
    private static final String TAG = "AssignmentRecycler"; //for debugging

    private ArrayList<String> courseNames = new ArrayList<>();
    private ArrayList<String> courseAssignmentsContent = new ArrayList<>();
    private android.content.Context mContext;

    public AssignmentRecycler(ArrayList<String> titles, ArrayList<String> classAssignment, android.content.Context context){
        courseNames = titles;
        courseAssignmentsContent = classAssignment;
        mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AssignmentRecycler.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called"); // called everytime a new item is added to list

        holder.courseName.setText(courseNames.get(position));
        holder.courseAssignment.setText(courseAssignmentsContent.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked an assignment.");
                Toast.makeText(mContext, courseNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseAssignmentsContent.size();
    }


    //view holder class
    public class ViewHolder extends RecyclerView.ViewHolder {
        //declare all widgets here
        TextView courseName;
        TextView courseAssignment;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            //attach widgets to their ids
            courseName =  itemView.findViewById(R.id.courseTitle);
            courseAssignment = itemView.findViewById(R.id.courseAssignments);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
