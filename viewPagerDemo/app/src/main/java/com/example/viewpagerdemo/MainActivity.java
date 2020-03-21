package com.example.viewpagerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ViewPager mViewPager;

    public PagerAdapter mPageAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return layout_Ids.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View child = mViewList.get(position);
            container.addView(child);
            return child;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mViewList.get(position));
        }
    };

    private int[] layout_Ids = new int[]{
      R.layout.test_first,
      R.layout.test_second,
      R.layout.test_third
    };

    public final List<View> mViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.view_pager);
        for (int i = 0; i < layout_Ids.length; i++) {
            View view = getLayoutInflater().inflate(layout_Ids[i], null);
            mViewList.add(view);
        }
        mViewPager.setAdapter(mPageAdapter);
    }
}
