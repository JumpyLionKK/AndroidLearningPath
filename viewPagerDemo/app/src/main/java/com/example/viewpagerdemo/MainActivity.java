package com.example.viewpagerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private ViewGroup mDotViewGroup;

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

    private List<View> mViewList = new ArrayList<>();

    private List<ImageView> mDotViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.view_pager);
        mDotViewGroup = findViewById(R.id.dot_layout);
        for (int i = 0; i < layout_Ids.length; i++) {
            View view = getLayoutInflater().inflate(layout_Ids[i], null);
            mViewList.add(view);
            ImageView dot = new ImageView(this);
            dot.setImageResource(R.mipmap.ic_launcher);
            dot.setMaxWidth(100);
            dot.setMaxHeight(100);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20,20);
            layoutParams.leftMargin = 20;
            dot.setLayoutParams(layoutParams);
            mDotViewGroup.addView(dot);
            mDotViewList.add(dot);
        }
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setCurrentItem(0);
        mDotViewList.get(0).setImageResource(R.mipmap.test);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mDotViewList.size(); i++) {
                    mDotViewList.get(i).setImageResource((position == i) ? R.mipmap.test : R.mipmap.ic_launcher);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
