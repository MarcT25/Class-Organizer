package com.example.classorganizer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classorganizer.databinding.AssignmentListItemBinding;

import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {

    public static final String TAG = "AssignmentAdapter";

    private AssignmentListItemBinding binding;

    private Context context;
    private List<Assignment> assignments;


    public AssignmentAdapter(Context context, List<Assignment> assignments){
        this.context = context;
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = AssignmentListItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Assignment assignment = assignments.get(position);
        Log.d(TAG, "onBindViewHolder: " + assignment);
        holder.binding.setAssignment(assignment);
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        AssignmentListItemBinding binding;

        public ViewHolder(AssignmentListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void clear(){
            assignments.clear();
            notifyDataSetChanged();
        }

        public void addAll(List<Assignment> list){
            assignments.addAll(list);
            notifyDataSetChanged();
        }
    }
}