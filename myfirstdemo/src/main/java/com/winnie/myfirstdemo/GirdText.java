package com.winnie.myfirstdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.gird_text)
public class GirdText extends AppCompatActivity {

    private  int[] nameID={R.drawable.app1,R.drawable.app2,R.drawable.app3,R.drawable.app4,R.drawable.app5,R.drawable.app6,
            R.drawable.app7,R.drawable.app8,R.drawable.app9,R.drawable.app10,R.drawable.app11, R.drawable.app12};
    private  String[] iconName={"1","2","3","4","5","6","7","8","9","10","11","12"};

    @ViewInject(R.id.gridView)
    private GridView gird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.gird_text);
        x.view().inject(this);
        MyAdapter myAdapter= new MyAdapter(GirdText.this);
        gird.setAdapter(myAdapter);
    }
    class MyAdapter extends BaseAdapter{
        private Context mContext;
        public MyAdapter(Context context)
        {
            mContext=context;
        }
        @Override
        public int getCount() {
            return nameID.length;
        }

        @Override
        public Object getItem(int position) {
            return nameID[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout linear=new LinearLayout(mContext);
            linear.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            linear.setOrientation(LinearLayout.VERTICAL);
            ImageView imageView=new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(230,230));
            imageView.setImageResource(nameID[position]);
            linear.addView(imageView);
            TextView textView=new TextView(mContext);
            textView.setLayoutParams(new ViewGroup.LayoutParams(230,ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setText(iconName[position]);
            linear.addView(textView);
            return linear;
        }
    }
}
