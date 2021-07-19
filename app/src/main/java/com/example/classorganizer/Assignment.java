package com.example.classorganizer;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcel;

@ParseClassName("Assignment")
//@Parcel
public class Assignment extends ParseObject {

    public Assignment(){}

    public static final String KEY_OBJECT_ID = "objectID";
    public static final String KEY_COURSE_ID = "objectID";

    public static final String KEY_USER = "studentID";

    public static final String KEY_ASSIGNMENT = "content";


    // Object ID (user id)
    public String getKeyObjectID() { return getString(KEY_OBJECT_ID); }
    public void setObjectID(String id) {put(KEY_OBJECT_ID, id); }

    // Course ID
    public String getKeyCourseID() { return getString(KEY_COURSE_ID); }
    public void setCourseID(String id) {put(KEY_COURSE_ID, id); }

    //Get Student
    public ParseUser getAuthor(){
        return getParseUser(KEY_USER);
    }
    public void setAuthor(ParseUser studentID){
        put(KEY_USER,studentID);
    }

    // Get Assignment Record
    public String getAssignment(){
        return getString(KEY_ASSIGNMENT);
    }

    public void setAssignment(String assignmentName){
        put(KEY_ASSIGNMENT,assignmentName);
    }


}