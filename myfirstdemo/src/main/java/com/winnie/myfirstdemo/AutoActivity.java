package com.winnie.myfirstdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoActivity extends AppCompatActivity {

    private AutoCompleteTextView text;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto);
        text=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        String[] datas={"java","javam","java","javase","javams","javaa"};
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(AutoActivity.this,android.R.layout.simple_list_item_1,datas);
        text.setAdapter(arrayAdapter);
//        text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//              name=datas[position];
//
//            }
//        });
//        Toast.makeText(null,"搜索的内容是："+name，null).show();
    }
}
