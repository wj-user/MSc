package com.example.a69477.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Alumni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni);
        Toolbar mytoolBar = (Toolbar) findViewById(R.id.toolbar_fee);
        setSupportActionBar(mytoolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ImageView myheader = (ImageView) findViewById(R.id.img_fe);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/GraduatesAlumni.jpg").into(myheader);

        ImageView mainImage=findViewById(R.id.alumni_img);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/GradDinner2017-2.jpg").into(mainImage);

        TextView alumni_intro=findViewById(R.id.alumni_intro);
        alumni_intro.setText("HKU is a journey, not a destination. When you left HKU, you are not alone for the rest of your life because you have the alumni association, your powerful backing forever.\n" +
                "\n" +
                "The MSc(CompSc) Alumni Association strengthens the bonding and communication among our graduates, facilitates resources sharing and thus fulfills the responsibilities of being an HKU alumni. We aim at practicing the motto \"Sapience and Virtue\", working in unity, helping each other, contributing to our alma mater and serving the community.\n" +
                "\n" +
                "Our Alumni Association is not only the heritage of HKU, but also the wealth throughout our whole lives. It actively recruits not just new graduates each year. It also invites new and current students to join the big family before their graduation. Currently, we have bases throughout China, including Hong Kong, Beijing, Shanghai, Shenzhen and Chengdu. Every student who has studied the MSc(CompSc) programme can find their own home.\n" +
                "\n" +
                "http://www.hkumsccs.com");



        mytoolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

