package com.example.a69477.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class application extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //menu=findViewById(R.id.bottomMenu);
        menu=bottomNavigationView.getMenu();
        menu.getItem(0).setTitle("Admission Requirement");
        menu.getItem(1).setTitle("Application Procedure");
        menu.getItem(2).setTitle("Composition Fee");
        menu.getItem(3).setTitle("Words from Students and Graduates");
        menu.getItem(4).setTitle("Information sessions");
        //menu.getItem(5).setTitle("FAQ");

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

        JSONObject json1=new JSONObject();//第一个界面的json数据,由part123组成

        try{
            json1.put("title","Admission Requirements");
            JSONObject part1=new JSONObject();
            JSONObject part2=new JSONObject();
            JSONObject part3=new JSONObject();

            part1.put("title","Eligibility");
            part1.put("intro","To be eligible for admission to the programmes, a candidate shall satisfy both the University Entrance Requirements and the Programme Entrance Requirements including but not limited to:");
            //part1的abc数据部分
            JSONArray data1=new JSONArray();
            data1.put("a. shall comply with the General Regulations;");
            data1.put("b. shall hold a Bachelor’s degree of this University or a qualification of equivalent standard from this University or another comparable institution accepted for this purpose;");
            data1.put("c. for a candidate who is seeking admission on the basis of a qualification from a university or comparable institution outside Hong Kong of which the language of teaching and/or examination is not English, shall satisfy the University English language requirement applicable to high degrees as prescribed under General Regulation G2(b); and");
            data1.put("d. satisfy the examiners in a qualifying examination if required.");
            part1.put("data",data1);
            part1.put("number",1);
            json1.put("part1",part1);

            part2.put("title","Regulations");
            part2.put("intro","");
            //part2的abc数据部分
            JSONArray data2=new JSONArray();
            data2.put("1. General Regulations of The University\n" +
                    "https://www4.hku.hk/pubunit/drcd/files/pgdr2017-18/genreg.pdf");
            data2.put("2. University's Regulations for Taught Postgraduate Curricula: \n" +
                    "https://www4.hku.hk/pubunit/drcd/files/pgdr2017-18/tpg-regulations.pdf");
            data2.put("3. Degree Regulations of MSc(CompSc) for students admitted to the curriculum in 2017-2018 and thereafter:\n" +
                    "http://www.msc-cs.hku.hk/Media/Default/RegulationSyllabus/Regulations_MSc_2017-18.pdf\n" +
                    "http://www.msc-cs.hku.hk/Media/Default/RegulationSyllabus/Syllabus_MSc(CompSc)_2018-19.pdf");

            part2.put("data",data2);
            part2.put("number",2);
            json1.put("part2",part2);


            part3.put("title","English Language Proficiency Requirement");
            part3.put("intro","Applicants who wish to be admitted on the basis of a qualification from a university or comparable institution outside Hong Kong where the language of teaching and/or examination is not English are required to obtain:");
            JSONArray data3=new JSONArray();
            data3.put("a. a score of 550 or above (paper-based test) or 80 or above (internet-based test) in the Test of English as a Foreign Language (TOEFL).  Applicants who took the TOEFL should request the Educational Testing Service (ETS) to send an official score report to the University directly. For this purpose, the HKU TOEFL code is 9671. Test scores more than two years old will not be accepted; or");
            data3.put("b. a minimum overall band of 6 with no subtest lower than 5.5 in the International English Language Testing System (IELTS); or");
            data3.put("c. grade C or above in the Overseas General Certificate of Education (GCE); or");
            data3.put("d. grade C or above in the International General Certificate of Secondary Education (IGCSE); or");
            data3.put("e. grade C or above in the Cambridge Test of Proficiency in English Language;");
            part3.put("data",data3);
            part3.put("number",3);
            json1.put("part3",part3);

            list.add(TestFragment.newInstance(json1));
        }
        catch (JSONException e){
            list.add(TestFragment.newInstance("Whops, something is wrong!"));
        }



        JSONObject json2=new JSONObject();
        try{
            json2.put("","");
        }
        catch (JSONException e){
            list.add(TestFragment.newInstance("Whops, something is wrong!"));
        }


        list.add(TestFragment.newInstance("第二页"));
        list.add(TestFragment.newInstance("大学"));
        list.add(TestFragment.newInstance("很难"));
        list.add(TestFragment.newInstance("呵呵"));
        viewPagerAdapter.setList(list);


        //---------------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(application.this, MainActivity.class);
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
                case R.id.navigation_person:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.navigation_is:
                    viewPager.setCurrentItem(4);
            }
            return false;
        }
    };
}





