package com.winnie.myfirstdemo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {
    private Button regist;
    private Button oauth;
    private EditText input_name;
    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        DisplayMetrics dm=getResources().getDisplayMetrics();
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        int dpi=dm.densityDpi;
        System.out.println("w=="+width+",h=="+height+",dpi=="+dpi);
        Drawable drawable=getResources().getDrawable(R.drawable.qq,null);

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

                Intent in1 = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(in1);

            }
        });
        oauth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopupWindow(v);
                final Intent it = new Intent(LoginActivity.this, MainActivity.class);
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(it);
                    }
                };
                timer.schedule(task, 1000 * 5);

            }
        });

    }


    public void login(View view){

        switch(view.getId()){
            case R.id.oauth:

                showPopupWindow(view);
                break;
            case R.id.login:
                String name = input_name.getText().toString();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username",name);
                startActivityForResult(intent,1);
                break;
        }

    }
    private void showPopupWindow(View view){
        View contentView= LayoutInflater.from(LoginActivity.this).inflate(R.layout.oauth,null);
        final PopupWindow popupWindow=new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event){
                new AlertDialog.Builder(LoginActivity.this).setTitle("正在授权登陆")
                .setView(LayoutInflater.from(LoginActivity.this).inflate(
                        R.layout.oauthing,null
                )).create().show();
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.p1,null));
        View windowContentViewRoot=contentView;
        int windowPos[]=calculatePopWindowPos(view,windowContentViewRoot);
        int xoff=950;
        windowPos[0]-=xoff;
        int yoff=60;
        windowPos[1]+=yoff;
        popupWindow.showAtLocation(view, Gravity.TOP|Gravity.START,windowPos[0],windowPos[1]);
        popupWindow.showAsDropDown(view);
    }
    private int[] calculatePopWindowPos(final View anchorView,final View contentView){
        final int windowPos[]=new int[2];
        final int anchorLoc[]=new int[2];
        anchorView.getLocationOnScreen(anchorLoc);
        final int anchorHeight=anchorView.getHeight();
        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final int screenHeight=metrics.widthPixels;
        final  int screenWidth=metrics.heightPixels;
        contentView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        final  int windowHeight=contentView.getMeasuredHeight();
        final  int windowWidth=contentView.getMeasuredWidth();
        windowPos[0]=screenWidth-windowWidth;
        windowPos[1]=anchorLoc[1]+anchorHeight;
        return windowPos;


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == 1){
            if(resultCode == 2){
                boolean res =  intent.getBooleanExtra("result",false);

                if (res){
                    Toast.makeText(LoginActivity.this,"用户名可使用",Toast.LENGTH_SHORT).show();
                }

            }


        }
    }
}

