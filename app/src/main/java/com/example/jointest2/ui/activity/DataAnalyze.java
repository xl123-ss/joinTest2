package com.example.jointest2.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jointest2.R;
import com.example.jointest2.ui.adapter.VPAdapter;
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class DataAnalyze extends BaseActivity {

    ViewPager viewPager;
    TextView tv_temprature, tv_pm25, tv_cq2, tv_road, tv_humidity, tv_light;
    List<TextView>textViewList;
    LayoutInflater inflater;
    List<View> viewList;
    BarChart bar_temprature, bar_pm25, bar_cq2, bar_road, bar_humidity, bar_light;
    VPAdapter adapter;


    @Override
    public int setLayoutId() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        return R.layout.activity_data_analyze;
    }

    @Override
    public void initView() {
        initViews();
        setNode();

    }




    @Override
    public void initData() {

    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        textViewList = new ArrayList<>();
        tv_temprature = findViewById(R.id.tv_temprature);
        textViewList.add(tv_temprature);
        tv_pm25 = findViewById(R.id.tv_pm25);
        textViewList.add(tv_pm25);
        tv_cq2 = findViewById(R.id.tv_cq2);
        textViewList.add(tv_cq2);
        tv_road = findViewById(R.id.tv_road);
        textViewList.add(tv_road);
        tv_humidity = findViewById(R.id.tv_humidity);
        textViewList.add(tv_humidity);
        tv_light = findViewById(R.id.tv_light);
        textViewList.add(tv_light);

        inflater = LayoutInflater.from(this);
        viewList = new ArrayList<>();

        View view1 = inflater.inflate(R.layout.layout_temprature, null);
        bar_temprature = view1.findViewById(R.id.bar_temprature);
        viewList.add(view1);
        View view2 = inflater.inflate(R.layout.layout_pm25, null);
        bar_pm25 = view2.findViewById(R.id.bar_pm25);
        viewList.add(view2);
        View view3 = inflater.inflate(R.layout.layout_cq2, null);
        bar_cq2 = view3.findViewById(R.id.bar_cq2);
        viewList.add(view3);
        View view4 = inflater.inflate(R.layout.layout_road, null);
        bar_road = view4.findViewById(R.id.bar_road);
        viewList.add(view4);
        View view5 = inflater.inflate(R.layout.layout_humidity, null);
        bar_humidity = view5.findViewById(R.id.bar_humidity);
        viewList.add(view5);
        View view6 = inflater.inflate(R.layout.layout_light, null);
        bar_light = view6.findViewById(R.id.bar_light);
        viewList.add(view6);

        adapter = new VPAdapter(viewList);
        viewPager.setAdapter(adapter);


    }

    private void setNode() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i= 0;i<viewList.size();i++){
                    if (position ==i){
                        textViewList.get(i).setBackgroundResource(R.drawable.shape_selected);
                    }else {
                        textViewList.get(i).setBackgroundResource(R.drawable.shape_unselected);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void dosubmit(View view){
        switch (view.getId()){
            case R.id.tv_temprature:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_pm25:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_cq2:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tv_road:
                viewPager.setCurrentItem(3);
                break;
            case R.id.tv_humidity:
                viewPager.setCurrentItem(4);
                break;
            case R.id.tv_light:
                viewPager.setCurrentItem(5);
                break;
        }
    }

}