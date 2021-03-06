package com.example.day02_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.day02_2.view.ViewAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());

        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(viewAdapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("专题");
        mTab.getTabAt(1).setText("我的");
    }
}
