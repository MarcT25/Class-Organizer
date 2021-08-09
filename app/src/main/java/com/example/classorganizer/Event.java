package com.example.classorganizer;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcel;

@ParseClassName("Event")
//@Parcel
public class Event extends ParseObject {

    public Event(){}

    public static final String KEY_OBJECT_ID = "objectID";
    public static final String KEY_USER = "studentID";

    public static final String KEY_EVENT_TITLE = "eventTitle";
    public static final String KEY_EVENT_START = "startDateOfEvent";
    public static final String KEY_EVENT_END = "endDateOfEvent";


    // Object ID (user id)
    public String getKeyObjectID() { return getString(KEY_OBJECT_ID); }
    public void setObjectID(String id) {put(KEY_OBJECT_ID, id); }

    //Get Student
    public ParseUser getAuthor(){
        return getParseUser(KEY_USER);
    }
    public void setAuthor(ParseUser studentID){
        put(KEY_USER,studentID);
    }

    // Get Event Record Name
    public String getKeyEventTitle(){
        return getString(KEY_EVENT_TITLE);
    }
    public void setKeyEventTitle(String eventName){
        put(KEY_EVENT_TITLE,eventName);
    }

    // Get Event Start Date
    public String getKeyEventStart(){
        return getString(KEY_EVENT_START);
    }
    public void setKeyEventStart(String eventStart){
        put(KEY_EVENT_START,eventStart);
    }

    // Get Event Start Date
    public String getKeyEventEnd(){
        return getString(KEY_EVENT_END);
    }
    public void setKeyEventEnd(String eventEnd){
        put(KEY_EVENT_END,eventEnd);
    }
}
