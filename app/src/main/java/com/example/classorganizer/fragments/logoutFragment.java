package com.example.classorganizer.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classorganizer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link logoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class logoutFragment extends Fragment {

    public logoutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logout, container, false);
    }
}