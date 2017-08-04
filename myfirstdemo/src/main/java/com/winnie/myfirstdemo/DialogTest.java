package com.winnie.myfirstdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.dialog_test)
public class DialogTest extends AppCompatActivity {

    @ViewInject(R.id.show_dialog_normal)
    private Button normal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //setContentView(R.layout.dialog_test);
        //AlertDialog
//        normal.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
    @Event(value = {R.id.show_dialog_normal},type=View.OnClickListener.class)
    private void doEvent(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(DialogTest.this);
        builder.setTitle("hei");
        builder.setIcon(R.drawable.p1);
        //builder.setMessage("选择退出？");
        //builder.setView(R.layout.auto);
        String[] msg={"1","2"};
        builder.setItems(msg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("取消",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();


    }
}
