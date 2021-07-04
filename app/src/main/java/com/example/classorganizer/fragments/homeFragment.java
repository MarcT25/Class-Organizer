package com.example.classorganizer.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classorganizer.ClassDetailsActivity;
import com.example.classorganizer.R;
import com.example.classorganizer.databinding.FragmentHomeBinding;

public class homeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = binding.bind(view);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ClassDetailsActivity.class);
                startActivity(i);
                //finish();             //Since this is a fragment, it will automatically 'finish' for us.
            }
        });
    }
}