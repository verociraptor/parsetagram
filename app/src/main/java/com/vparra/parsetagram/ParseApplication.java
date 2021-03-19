package com.vparra.parsetagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.vparra.parsetagram.data.model.Post;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //register parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("KGcEuQisAYdPhXBFU84GGxpoMqBDxMlFs2WOEoso")
                .clientKey("ga5FOWlPutAvuZaSfli28yjquU3y9rTXsRM6FmeX")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
