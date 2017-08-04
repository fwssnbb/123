package com.winnie.myfirstdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<String>();
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private List<Map<String,Object>> lists=new ArrayList<>();
    private  int[] imgIDs={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,};
    private  String[] names={"肯德基","麦当劳","必胜客","德克士","土大力","彤德莱"};
    private  int[] prices={4,5,3,4,1,0};
    private  int[] checks={94,85,93,84,91,90};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        list.add("北京");
        list.add("上海");
        list.add("深圳");
        list.add("福州");
        list.add("厦门");
        mySpinner = (Spinner)findViewById(R.id.Spinner_city);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner.setAdapter(adapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中


        listView=(ListView) findViewById(R.id.listView);
        String[] keys={"img","title","price","check"};
        int[] ids={R.id.item_img,R.id.item_title,R.id.item_price,R.id.item_check};
        SimpleAdapter simpleAdapter = new SimpleAdapter(SpinnerActivity.this,lists,R.layout.list_item,keys,ids);
        listView.setAdapter(simpleAdapter);
        for (int i=0;i<imgIDs.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",imgIDs[i]);
            map.put("title",names[i]);
            map.put("price","配送费："+prices[i]+"元");
            map.put("check","好评率："+checks[i]+"%");
            lists.add(map);
        }





    }
}
