package com.example.classorganizer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classorganizer.databinding.EventListItemBinding;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    public static final String TAG = "EventAdapter";

    private EventListItemBinding binding;

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
        binding = EventListItemBinding.inflate(layoutInflater,parent,false);
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

        EventListItemBinding binding;

        public ViewHolder(EventListItemBinding binding) {
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
