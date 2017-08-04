package com.winnie.myfirstdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FragmentTest extends AppCompatActivity {
    private TextView tv_findWork;
    private TextView tv_findTalents;
    private TextView tv_findSchool;
    private TextView tv_findStudent;
    private Fragment contentFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_test);
        // 初始化数据
        initUi();
    }
    /**
     * 初始化变量
     */
    private void initUi() {
        tv_findWork = (TextView) findViewById(R.id.tvWork);
        tv_findWork.setOnClickListener(itemClick);
        tv_findTalents = (TextView) findViewById(R.id.tvTalents);
        tv_findTalents.setOnClickListener(itemClick);
        tv_findSchool = (TextView) findViewById(R.id.tvSchool);
        tv_findSchool.setOnClickListener(itemClick);
        tv_findStudent = (TextView) findViewById(R.id.tvStudent);
        tv_findStudent.setOnClickListener(itemClick);
        // fragment管理者
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();
        Fragment init = new WorkFragment();
        transaction.replace(R.id.fragmentPager, init,"fragment");//tag
        transaction.commit();
    }

    /**
     * 点击选项
     */
    private View.OnClickListener itemClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            tv_findWork.setBackgroundColor(0xffffffff);
            tv_findWork.setTextColor(0XFFE4BA3F);
            tv_findTalents.setBackgroundColor(0Xffffffff);
            tv_findTalents.setTextColor(0XFFE4BA3F);
            tv_findSchool.setBackgroundColor(0xffffffff);
            tv_findSchool.setTextColor(0XFFE4BA3F);
            tv_findStudent.setBackgroundColor(0xffffffff);
            tv_findStudent.setTextColor(0XFFE4BA3F);
            TextView textview = (TextView) v;
            textview.setBackgroundColor(0XFFE4BA3F);
            textview.setTextColor(0xff000000);
            transaction = fragmentManager.beginTransaction();
            switch (v.getId()) {
                case R.id.tvWork:
                    contentFragment = new WorkFragment();
                    transaction.replace(R.id.fragmentPager, contentFragment);
                    break;
                case R.id.tvTalents:
                    contentFragment = new TitleFragment();
                    transaction.replace(R.id.fragmentPager, contentFragment);
                    break;
                case R.id.tvSchool:
                    contentFragment = new SchoolFragment();
                    transaction.replace(R.id.fragmentPager, contentFragment);
                    break;
                case R.id.tvStudent:
                    contentFragment = new StudentFragment();
                    transaction.replace(R.id.fragmentPager, contentFragment);
                    break;

                default:
                    break;
            }
            transaction.commit();
        }
    };
}
