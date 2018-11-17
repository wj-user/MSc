package com.example.a69477.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class About extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_about);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        menu=bottomNavigationView.getMenu();
        menu.getItem(0).setTitle("Faculty");
        menu.getItem(1).setTitle("Message");
        menu.getItem(2).setTitle("About HKU");

        //activity_application的vp
        viewPager = (ViewPager) findViewById(R.id.vp);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        List<Fragment> list = new ArrayList<>();

        JSONObject json1 = new JSONObject();
        try {
            json1.put("title","MESSAGE FROM PROGRAM DIRECTOR");
            JSONObject part1 = new JSONObject();
            part1.put("title","Message From Program Director");
            JSONArray data = new JSONArray();
            data.put("We are living in the era where technology is widely accepted and becomes so commonplace that we doubt how we ever live without it. Mobile is a good prominent example. From businesses to individual consumers, everyone is connected to everyone, everywhere, all the time. Every day we hear of new technological breakthroughs, e.g. self-driving cars, organ-on-a-chip, smart glasses, drones; they are awe-inspiring. To remain in the game, the best IT professionals strive to maintain current knowledge and skills to take on these continual developments.");
            data.put("\n" +
                    "The Master of Science in Computer Science Programme is a comprehensive and challenging graduate programme with three specialisations and one general stream, namely Financial Computing Stream, Cyber Security Stream, Multimedia Computing Stream and General Computer Science Stream, to meet the needs of both industry and business in Asia, and to make the programme more unique among comparable programmes in the region.");
            data.put("As you can see from our curriculum, on one hand we have retained the nuts and bolts subjects to lay a strong foundation. But on the other hand, we updated and revised the curriculum continuously as we assess the career trends and needs of our students, and monitor rapid changes in technology developments. For example, hot topics like “fintech”, “blockchain” are included in some of our courses.");
            data.put("If you like the holistic approach of our teaching methods and curriculum, please consider enrolling in this established programme in a world-class university.");
            data.put("Dr. K.P. Chow\n" +
                    "Programme Director");
            part1.put("data",data);
            json1.put("part1",part1);
            list.add(AboutFragment.newInstance(json1));
        }
        catch (JSONException e) {
            list.add(CurriculumFragment.newInstance("Whops, something is wrong!"));
        }
        list.add(TestFragment.newInstance("About第一页"));
        list.add(TestFragment.newInstance("第二页"));
        list.add(TestFragment.newInstance("大学"));
        viewPagerAdapter.setList(list);


        //---------------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About.this, MainActivity.class);
                startActivityForResult(intent, 11);
            }

        });
        //---------------------------------------------------------------------

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };
}





