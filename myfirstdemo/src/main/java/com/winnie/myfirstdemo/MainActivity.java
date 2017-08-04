package com.winnie.myfirstdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        username = (TextView) findViewById(R.id.username);
        //获取intent?
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        username.setText(name);
        intent.putExtra("result",true);
        setResult(2,intent);
    }
}
