package com.example.a69477.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class UsefulLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usefullinks);
        Toolbar mytoolBar = (Toolbar) findViewById(R.id.toolbar_fee);
        setSupportActionBar(mytoolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView myheader = (ImageView) findViewById(R.id.img_fe);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/GraduatesAlumni.jpg").into(myheader);




        mytoolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

