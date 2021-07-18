package com.example.classorganizer;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.parceler.Parcel;

@ParseClassName("User")
//@Parcel
public class User extends ParseObject {

    //Parcel requirement
    public User(){}

    public static final String KEY_FIRST_NAME = "firstName";
    public static final String KEY_LAST_NAME = "lastname";
    public static final String KEY_EMAIL = "email";

    public static final String KEY_IS_PROF = "isProf";
    public static final String KEY_OBJECT_ID = "objectID";

    //--------------------Getters and Setters----------------------


    // Object ID (user id)
    public String getKeyObjectID() { return getString(KEY_OBJECT_ID); }
    public void setObjectID(String id) {put(KEY_OBJECT_ID, id); }

    //First Name
    public String getFirstName(){
        return getString(KEY_FIRST_NAME);
    }
    public void setFirstName(String firstName){
        put(KEY_FIRST_NAME, firstName);

    }

    //Last Name
    public String getLastName(){
        return getString(KEY_LAST_NAME);
    }
    public void setLastName(String lastName){
        put(KEY_LAST_NAME, lastName);
    }

    //Email
    public String getEmail(){
        return getString(KEY_EMAIL);
    }

    public void setEmail(String email){ put(KEY_EMAIL, email); }

    //IsProfessional
    public Boolean getKeyIsProf() { return getBoolean(KEY_IS_PROF); }
    public void setIsProf(boolean isProf) { put(KEY_IS_PROF, isProf); }

}
