package com.example.micka.playgroundprojectv2.Utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by micka on 3/16/2018.
 */

public class VolleySingleton {
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private VolleySingleton(Context context){
        mContext = context;
        mRequestQueue = getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if(mRequestQueue ==null)
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        return mRequestQueue;
    }
    public static synchronized VolleySingleton getInstance(Context context){
        if(mInstance==null)
            mInstance = new VolleySingleton(context);
        return mInstance;
    }
    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

}