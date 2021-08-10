package com.example.classorganizer;


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Registering Post class
        //ParseObject.registerSubclass(Post.class);
        //Registering User class

        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(School.class);
        ParseObject.registerSubclass(Course.class);

        //Registering Assignments Data Model as well as Contacts Data Model
        //ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Assignment.class);
        ParseObject.registerSubclass(Contact.class);
        ParseObject.registerSubclass(Course.class);
        ParseObject.registerSubclass(Event.class);



        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(BuildConfig.MYAPPID)
                .clientKey(BuildConfig.CLIENTKEY)
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}