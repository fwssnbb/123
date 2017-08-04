package com.winnie.myfirstdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class RegistActivity extends AppCompatActivity {
    private EditText input_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);
        input_name = (EditText) findViewById(R.id.input_name);
    }
    public void regist(View view){

        String name = input_name.getText().toString();
        Intent intent = new Intent(RegistActivity.this, FirstActivity.class);
        intent.putExtra("username",name);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == 1){
            if(resultCode == 2){
                boolean res =  intent.getBooleanExtra("result",false);

            }


        }
    }
}
