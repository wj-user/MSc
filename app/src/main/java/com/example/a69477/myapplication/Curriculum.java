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

public class Curriculum extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private Menu menu;
    private String host="https://www.msc-cs.hku.hk";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView_curriculum);

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        menu=bottomNavigationView.getMenu();
        menu.getItem(0).setTitle("Programme Overview");
        menu.getItem(1).setTitle("Course");
        menu.getItem(2).setTitle("Schedule");
        menu.getItem(3).setTitle("Regulation");

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

        //overview
        JSONObject json1=new JSONObject();
        try {
            json1.put("title", "Programme Overview");

            JSONObject part1=new JSONObject();
            part1.put("title","Programme Overview");
            JSONArray data1=new JSONArray();
            data1.put("The MSc(CompSc) programme is a comprehensive postgraduate study programme provides advanced and in-depth learning in Computer Science.  The programme is credit unit based, with courses of both applied and fundamental nature.");
            data1.put("Students can choose focussed streams of study or a comprehensive and diversified study in Computer Science, i.e. the General Stream.");
            data1.put("Focussed streams of study represent a cohesive collection of related courses that provides both fundamental and in-depth exposure to students in a given ICT domain.  Students can extend and deepen their knowledge in the specialization streams in Cyber Security, Multimedia Computing and Financial Computing. ");
            part1.put("data",data1);
            json1.put("part1",part1);

            JSONArray stream=new JSONArray();
            JSONObject cyber=new JSONObject();
            cyber.put("Cyber Security","The Cyber Security Stream is a multidisciplinary area of study and professional activity concerned with state-of-the-art technology in cyber security. The curriculum covers different aspects of cyber security from different perspectives, including technical, organisational, human-oriented and legal.");
            cyber.put("imageUrl",host+"/Media/Default/ContentImages/InformationSecurity.jpg");
            stream.put(cyber);

            JSONObject mulmedia=new JSONObject();
            mulmedia.put("Multimedia Computing","The Multimedia Computing Stream focuses on multimedia computing, communications, analytics, visualisation and applications.\n" +
                    "\n" +
                    "Multimedia Computing encompasses media coding and processing, streaming-media middleware, media representations, real-time protocols, media analysis, and human-interaction and visualisation techniques.\n" +
                    "\n" +
                    "Students are encouraged to develop innovative ideas using the latest development in technology such as mobile devices and big-data analytics.");
            mulmedia.put("imageUrl",host+"/Media/Default/ContentImages/MultimediaComputing.jpg");
            stream.put(mulmedia);


            JSONObject financial=new JSONObject();
            financial.put("Financial Computing","The Financial Computing Stream is the study of data and algorithms used in finance and the mathematics of computer programs that realise financial models or systems.\n" +
                    "\n" +
                    "Financial Computing emphasises practical numerical methods and focuses on techniques that are directly applicable to business and financial analysis.\n" +
                    "\n" +
                    "The emphasis will be in the computing aspect of the financial industry.");
            financial.put("imageUrl",host+"/Media/Default/ContentImages/FinancialComputing.jpg");
            stream.put(financial);

            JSONObject general=new JSONObject();
            general.put("General Stream","The General Stream covers a broad, comprehensive range of Computer Science subjects, including a wide range of courses from which students can choose from. It offers students the most flexibility to design their own study portfolio based on their career aspiration or requirements.");
            general.put("imageUrl",host+"/Media/Default/ContentImages/GeneralStream.jpg");
            stream.put(general);
            json1.put("stream",stream);

            JSONObject part2=new JSONObject();
            part2.put("title","Pattern of Study");
            JSONArray data2 =new JSONArray();
            data2.put("Students are required to complete 72 credits of courses selected from the syllabus which must include capstone experience.");
            part2.put("data",data2);
            json1.put("part2",part2);

            JSONObject part3=new JSONObject();
            part3.put("title","Enrolment Mode");
            part3.put("intro","Students can study in one of the following enrolment modes(Each course normally carries 6 credits):");
            JSONArray data3= new JSONArray();
            data3.put("(a)Courses (60 credits)^ + Project (12 credits)\n" +
                    "\n" +
                    "     i.e. 10 Courses + Project\n" +
                    "\n");
            data3.put("(b)Courses (48 credits)^ + Dissertation (24 credits)\n" +
                    "\n" +
                    "     i.e. 8 Courses + Dissertation");
            part3.put("data",data3);
            json1.put("part3",part3);

            JSONObject part4=new JSONObject();
            part4.put("title","Capstone Experience – Dissertations and Projects");
            JSONArray data4= new JSONArray();
            data4.put("The capstone experience will definitely be beneficial for students to put together what they have learnt in the programme and demonstrate a deeper understanding of the knowledge they have acquired. Students are required to complete a dissertation (24 credits) or a project (12 credits), and attend some supplementary workshops. The dissertation / project would represent students’ consolidated capstone experience in their study.");
            part4.put("data",data4);
            json1.put("part4",part4);

            list.add(CurriculumFragment.newInstance(json1));

        }catch (JSONException e){
            list.add(CurriculumFragment.newInstance("Whops, something is wrong!"));
        }

        JSONObject json2=new JSONObject();
        try{
            json2.put("title","Courses");

        }
        catch (JSONException e){

        }



        list.add(CurriculumFragment.newInstance("Curriculum第一页"));
        list.add(CurriculumFragment.newInstance("第二页"));
        list.add(CurriculumFragment.newInstance("大学"));
        list.add(CurriculumFragment.newInstance("很难"));
        viewPagerAdapter.setList(list);


        //---------------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Curriculum.this, MainActivity.class);
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
            }
            return false;
        }
    };
}





