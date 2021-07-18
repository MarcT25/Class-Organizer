package com.example.classorganizer;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcel;

@ParseClassName("School")
//@Parcel
public class School extends ParseObject {


    //Required for parcel
    public School(){}

    public static final String KEY_SCHOOL = "school";
    public static final String KEY_USER = "user";



    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }
    public void setUser(ParseUser user){
        put(KEY_USER, user);
    }

    public String getSchool(){
        return getString(KEY_SCHOOL);
    }



}
