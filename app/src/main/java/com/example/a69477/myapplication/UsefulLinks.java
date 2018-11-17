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
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/UsefulLinks.jpg").into(myheader);

        TextView useful_intro=findViewById(R.id.useful_intro);
        useful_intro.setText("The University of Hong Kong Home Page\n" +
                "   -  https://www.hku.hk\n" +
                "\n" +
                "The Faculty of Engineering\n" +
                "   -  http://engg.hku.hk\n" +
                "\n" +
                "Department of Computer Science\n" +
                "   -  http://www.cs.hku.hk \n" +
                "\n" +
                "Information Technology Services\n" +
                "   -  http://www.its.hku.hk\n" +
                "\n" +
                "Centre of Development and Resources for Students\n" +
                "   -  http://www.cedars.hku.hk   \n" +
                "\n" +
                "China Affairs Office\n" +
                "   -  http://www.aal.hku.hk/cao\n" +
                "\n" +
                "The HKU Libraries\n" +
                "   -  https://lib.hku.hk/\n" +
                "\n" +
                "Please email msccs@cs.hku.hk if you find any above links broken or if you have any suggestion of other useful links for us to include in the list.");


        mytoolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

