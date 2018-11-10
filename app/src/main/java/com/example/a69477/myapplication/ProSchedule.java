package com.example.a69477.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ProSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_schedule);
        Toolbar mytoolBar = (Toolbar) findViewById(R.id.toolbar_app_sch);
        setSupportActionBar(mytoolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ImageView myheader = (ImageView) findViewById(R.id.image_sch);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/Schedule.jpg").into(myheader);
        mytoolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
