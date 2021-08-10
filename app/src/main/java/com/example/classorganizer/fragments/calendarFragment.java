package com.example.classorganizer.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.EventLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.classorganizer.EditCourse;
import com.example.classorganizer.Event;
import com.example.classorganizer.EventAdapter;
import com.example.classorganizer.R;
import com.example.classorganizer.databinding.FragmentCalendarBinding;

import java.util.ArrayList;
import java.util.List;

public class calendarFragment extends Fragment {

    public static final String TAG = "calendarFragment";

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //vars
    protected EventAdapter adapter;
    protected List<Event> allEvents;
    private FragmentCalendarBinding binding;

    private String mParam1;
    private String mParam2;

    public calendarFragment() {
        // Required empty public constructor
    }

    public static calendarFragment newInstance(String param1, String param2) {
        calendarFragment fragment = new calendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = binding.bind(view);

        allEvents = new ArrayList<>();
        adapter = new EventAdapter(getContext(), allEvents);

/*        //we bind the adapter to the recyclerview so that things will actually show
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext() );
        binding.recyclerView.setLayoutManager(layoutManager);*/


        binding.ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvName.setText("Exam Week");
                binding.tvStart.setText("8/9/2021");
                binding.tvEnd.setText("8/13/2021");
            }
        });

        binding.btnAdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), EditCourse.class);
                startActivity(i);
            }
        });


    }

}