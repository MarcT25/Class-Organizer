package com.example.classorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classorganizer.databinding.ContactListItemBinding;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public static final String TAG = "ContactAdapter";

    private ContactListItemBinding binding;


    private Context context;
    private List<Contact> contacts;
    //private List<User> users;


    public ContactAdapter(Context context, List<Contact> contact){
        this.context = context;
        this.contacts = contact;
        //this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = ContactListItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Contact contact = contacts.get(position);
        holder.binding.setContact(contact);

//        User user = new User();
//
//        holder.binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ContactListItemBinding binding;

        public ViewHolder(ContactListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void clear(){
            contacts.clear();
            notifyDataSetChanged();
        }

        public void addAll(List<Contact> list){
            contacts.addAll(list);
            notifyDataSetChanged();
        }
    }


}