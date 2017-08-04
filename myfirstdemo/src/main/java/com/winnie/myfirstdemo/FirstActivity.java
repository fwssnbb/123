package com.winnie.myfirstdemo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    private Button regist;
    private Button oauth;
    private EditText input_name;
    private TextView username;
private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        img=(ImageView) findViewById(R.id.img);
        DisplayMetrics dm=getResources().getDisplayMetrics();
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        int dpi=dm.densityDpi;
        System.out.println("w=="+width+",h=="+height+",dpi=="+dpi);
        Drawable drawable=getResources().getDrawable(R.drawable.qq,null);
        img.setImageDrawable(drawable);
        username = (TextView) findViewById(R.id.input_name);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        username.setText(name);
        intent.putExtra("result",true);
        setResult(2,intent);
        regist = (Button) findViewById(R.id.regist);
        oauth = (Button) findViewById(R.id.oauth);
        input_name = (EditText) findViewById(R.id.input_name);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in1 = new Intent(FirstActivity.this, RegistActivity.class);
                startActivity(in1);

            }
        });
        oauth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in1 = new Intent(FirstActivity.this, OauthActivity.class);
                startActivity(in1);

            }
        });

    }


    public void login(View view){

        String name = input_name.getText().toString();
        Intent intent = new Intent(FirstActivity.this, MainActivity.class);
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

