package com.example.day02_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class TwoActivity extends AppCompatActivity {
    private int position;
    private List<User.ResultsBean> beans;
    private ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initView();
        initData();
    }
    @Subscribe(sticky = true)

    private void initData() {
        VpAdapter vpAdapter = new VpAdapter(this, beans);
        mViewpager.setAdapter(vpAdapter);
        mViewpager.canScrollHorizontally(position);
    }

    private void initView() {
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
    }

}
