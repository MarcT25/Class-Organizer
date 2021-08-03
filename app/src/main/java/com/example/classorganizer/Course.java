package com.example.classorganizer;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcel;

@ParseClassName("Course")
//@Parcel
public class Course extends ParseObject {

    public Course(){}

    public static final String KEY_OBJECT_ID = "objectID";
    public static final String KEY_USER = "whichUser";

    public static final String KEY_COURSE = "CourseName";


    // Object ID (user id)
    public String getKeyObjectID() { return getString(KEY_OBJECT_ID); }
    public void setObjectID(String id) {put(KEY_OBJECT_ID, id); }

    public ParseUser getAuthor(){
        return getParseUser(KEY_USER);
    }
    public void setAuthor(ParseUser whichUser){
        put(KEY_USER,whichUser);
    }

    public String getCourseName(){
        return getString(KEY_COURSE);
    }
    public void setCourseName(String courseName){
        put(KEY_COURSE,courseName);
    }


}