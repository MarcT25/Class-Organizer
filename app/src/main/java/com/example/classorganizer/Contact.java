package com.example.classorganizer;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.parceler.Parcel;

@ParseClassName("Contact")
//@Parcel
public class Contact extends ParseObject {

    //Parcel requirement
    public Contact(){}

    public static final String KEY_OBJECT_ID = "objectID";

    public static final String KEY_COURSE_ID = "courseID";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_NAME = "Name";



    //--------------------Getters and Setters----------------------


    // Object ID (user id)
    public String getKeyObjectID() { return getString(KEY_OBJECT_ID); }
    public void setObjectID(String id) {put(KEY_OBJECT_ID, id); }

    //First Name
    public String getKeyCourseIdID() { return getString(KEY_COURSE_ID); }
    public void setCourseIdID(String id) {put(KEY_COURSE_ID, id); }

    //Contact Email
    public String getEmail(){
        return getString(KEY_EMAIL);
    }
    public void setEmail(String email){ put(KEY_EMAIL, email); }

    //Contact Name
    public String getContactName(){
        return getString(KEY_NAME);
    }
    public void setContactName(String email){ put(KEY_NAME, email); }
}
