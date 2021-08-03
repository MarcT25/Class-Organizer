package com.example.classorganizer.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.classorganizer.Contact;
import com.example.classorganizer.ContactAdapter;
import com.example.classorganizer.Course;
import com.example.classorganizer.R;
import com.example.classorganizer.databinding.FragmentContactsBinding;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link contactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class contactsFragment extends Fragment {

    public static final String TAG = "contactsFragment";

    protected ContactAdapter adapter;
    protected List<Contact> allContacts;
    private FragmentContactsBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public contactsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment contactsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static contactsFragment newInstance(String param1, String param2) {
        contactsFragment fragment = new contactsFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    // -------------------------------

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = binding.bind(view);


        //instantiate all courses to be a new 'arraylist'
        //adapter will now be 'matched' with the homeadapter to the new list
        allContacts = new ArrayList<>();
        adapter = new ContactAdapter(getContext(), allContacts);

        //we bind the adapter to the recyclerview so that things will actually show
        binding.rvContact.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rvContact.setLayoutManager(layoutManager);

        queryContacts();
    }

    private void queryContacts(){
        ParseQuery<Contact> query = ParseQuery.getQuery(Contact.class);
        query.include(Contact.KEY_NAME);
        query.include(Contact.KEY_EMAIL);
        //query.include(User.KEY_FIRST_NAME);

        query.findInBackground(new FindCallback<Contact>() {
            @Override
            public void done(List<Contact> objects, ParseException e) {
                if (e!= null){
                    Log.e(TAG,"error with fetching courses", e);
                    return;
                }
                for (Contact contact : objects){
                    Log.i(TAG, "ITS WORKINGS: " + contact.getContactName() + " " + contact.getEmail());
                }
                allContacts.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        });
    }
}