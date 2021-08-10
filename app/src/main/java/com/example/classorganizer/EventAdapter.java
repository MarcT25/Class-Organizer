package com.example.classorganizer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classorganizer.databinding.FragmentCalendarBinding;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    public static final String TAG = "EventAdapter";

    private FragmentCalendarBinding binding;

    private Context context;
    private List<Event> events;


    public EventAdapter(Context context, List<Event> events){
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = FragmentCalendarBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Event event = events.get(position);
        Log.d(TAG, "onBindViewHolder: " + event);
        holder.binding.setEvent(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        FragmentCalendarBinding binding;

        public ViewHolder(FragmentCalendarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void clear(){
            events.clear();
            notifyDataSetChanged();
        }

        public void addAll(List<Event> list){
            events.addAll(list);
            notifyDataSetChanged();
        }
    }
}