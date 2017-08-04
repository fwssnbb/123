package com.winnie.extra;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Thinkpad on 2017/7/30.
 */

public class MyApplication extends Application {
    private String name;
    @Override
    public void onCreate(){
        super.onCreate();
        setName("hello");
        x.Ext.init(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
