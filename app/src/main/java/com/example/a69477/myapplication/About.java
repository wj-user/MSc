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
    private String host="https://www.msc-cs.hku.hk";
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
        JSONObject faculty=new JSONObject();
        try{
            faculty.put("title","The Department of Computer Science is committed to high-quality education and training of computing professionals at both the undergraduate and postgraduate levels. At the postgraduate level, we offer two taught programmes based on coursework, the MSc(CompSc) and the MSc(ECom&IComp), as well as the research-based MPhil and PhD programmes.\n" +
                    "\n" +
                    "The academic staff is active in research and development in a variety of areas including databases, parallel and distributed computing, computer networks, computer graphics, algorithms and complexity, computer vision, multimedia, software engineering, statistical computing, information security and computer forensics, and legal aspects of computing. Some of our research results have been applied to the development of real software and systems. You will have these researchers as your inspiring teachers of the courses in this programme. Here are some of them");
            JSONArray data=new JSONArray();

            JSONObject teacher1=new JSONObject();
            teacher1.put("name","Dr. Chan H.T.H.");
            teacher1.put("url",host+"/Media/Default/instructors/Chan%20H.T.H.%20.jpg");
            teacher1.put("email","hubert@cs.hku.hk");
            teacher1.put("degree","PhD (Carnegie Mellon)");
            teacher1.put("study_content","Algorithms, Combinatorial Optimization, Graphs, Information Networks, Security & Privacy");
            data.put(teacher1);

            JSONObject teacher2=new JSONObject();
            teacher2.put("name","Dr. Chan K.P.");
            teacher2.put("url",host+"/Media/Default/instructors/Chan%20K.P..jpg");
            teacher2.put("email","kpchan@cs.hku.hk");
            teacher2.put("degree","PhD (HK)");
            teacher2.put("study_content","Pattern Recognition, Chinese Computing, Facial Expression Recognition, Machine Learning");
            data.put(teacher2);


            JSONObject teacher3=new JSONObject();
            teacher3.put("name","Dr. Cheng R.C.K.");
            teacher3.put("url",host+"/Media/Default/instructors/Cheng%20R.C.K..jpg");
            teacher3.put("email"," ckcheng@cs.hku.hk");
            teacher3.put("degree","PhD (Purdue)");
            teacher3.put("study_content","Database and Uncertainty Management");
            data.put(teacher3);

            JSONObject teacher4=new JSONObject();
            teacher4.put("name","Dr. Chim T.W.");
            teacher4.put("url",host+"/Media/Default/instructors/ChimTW.jpg");
            teacher4.put("email","twchim@cs.hku.hk");
            teacher4.put("degree","PhD (HK)");
            teacher4.put("study_content","Network Security and Cryptography");
            data.put(teacher4);

            JSONObject teacher5=new JSONObject();
            teacher5.put("name","Dr. Choi L.Y.K.");
            teacher5.put("url",host+"/Media/Default/instructors/Choi%20L.Y.K..jpg");
            teacher5.put("email","ykchoi@cs.hku.hk");
            teacher5.put("degree","PhD (HK)");
            teacher5.put("study_content","Medical Visualization, Geometric Computing, Computer Graphics");
            data.put(teacher5);

            JSONObject teacher6=new JSONObject();
            teacher6.put("name","Dr. Chow K.P.");
            teacher6.put("url",host+"chow@cs.hku.hk");
            teacher6.put("email","/Media/Default/instructors/ChowKP.jpg");
            teacher6.put("degree","PhD (UC Santa Barbara)");
            teacher6.put("study_content","Computer Forensics, Digital Investigation, Data Privacy, Computer Security");
            data.put(teacher6);

            JSONObject teacher7=new JSONObject();
            teacher7.put("name","Dr. Chung H.Y.");
            teacher7.put("url",host+"/Media/Default/instructors/Chung%20H.Y..jpg");
            teacher7.put("email","hychung@cs.hku.hk");
            teacher7.put("degree","PhD (HK)");
            teacher7.put("study_content","Internet Computing, Video-coding, Video/Image Processing, Real-time Processing");
            data.put(teacher7);

            JSONObject teacher8=new JSONObject();
            teacher8.put("name","Dr. Lau V.M.K.");
            teacher8.put("url",host+"/Media/Default/instructors/Lau%20V.M.K..jpg");
            teacher8.put("email","vmklau@cs.hku.hk");
            teacher8.put("degree", "PhD (HK)");
            teacher8.put("study_content","User Interface, Embedded System, Mobile system, Chinese Character, Font and Input Technologies");
            data.put(teacher8);

            JSONObject teacher9=new JSONObject();
            teacher9.put("name","Dr. Pun K.K.H.");
            teacher9.put("url",host+"/Media/Default/instructors/Pun%20K.K.H..jpg");
            teacher9.put("email","pun@cs.hku.hk");
            teacher9.put("degree","PhD (Illinois); LLB, LLM (London)");
            teacher9.put("study_content","Information Technology Law, e-Commerce, e-Crimes, Computerization of Law");
            data.put(teacher9);

            JSONObject teacher10=new JSONObject();
            teacher10.put("name","Dr. Rahmel J.H.");
            teacher10.put("url",host+"/Media/Default/instructors/RahmelJuergen.jpg");
            teacher10.put("email","juergen@hku.hk");
            teacher10.put("degree","PhD (Kaiserslautern)");
            teacher10.put("study_content","Artificial Intelligence, Financial Services");
            data.put(teacher10);

            JSONObject teacher11=new JSONObject();
            teacher11.put("name","Dr. Schnieders D.");
            teacher11.put("url",host+"/Media/Default/instructors/Schnieders%20D.jpg");
            teacher11.put("email","sdirk@cs.hku.hk");
            teacher11.put("degree","PhD (HK)");
            teacher11.put("study_content","Computer Vision, Image Processing, Pattern Recognition");
            data.put(teacher11);

            JSONObject teacher12=new JSONObject();
            teacher12.put("name","Dr. Shum C.D.");
            teacher12.put("url",host+"\\Media\\Default\\ContentImages\\InstructorNoImg.jpg");
            teacher12.put("email","cdshum@cs.hku.hk");
            teacher12.put("degree","PhD (California)");
            teacher12.put("study_content","Financial Computing");
            data.put(teacher12);

            JSONObject teacher13=new JSONObject();
            teacher13.put("name","Dr. Tam A.T.C.");
            teacher13.put("url",host+"/Media/Default/instructors/Tam%20A.T.C..jpg");
            teacher13.put("email","atctam@cs.hku.hk");
            teacher13.put("degree","PhD (HK)");
            teacher13.put("study_content","Cluster Computing, Parallel and Distributed Computing");
            data.put(teacher13);

            JSONObject teacher14=new JSONObject();
            teacher14.put("name","Dr. Ting H.F.");
            teacher14.put("url",host+"/Media/Default/instructors/Ting%20H.F..jpg");
            teacher14.put("email","hfting@cs.hku.hk");
            teacher14.put("degree","PhD (Princeton)");
            teacher14.put("study_content","Design and Analysis of Algorithms");
            data.put(teacher14);

            JSONObject teacher15=new JSONObject();
            teacher15.put("name","Dr. Wong K.K.Y.");
            teacher15.put("url",host+"/Media/Default/instructors/Wong%20K.K.Y..jpg");
            teacher15.put("email","kykwong@cs.hku.hk");
            teacher15.put("degree","PhD (Cambridge)");
            teacher15.put("study_content","Camera Calibration, Motion Tracking");
            data.put(teacher15);

            JSONObject teacher16=new JSONObject();
            teacher16.put("name","Dr. Wu C.");
            teacher16.put("url",host+"/Media/Default/instructors/Wu%20C..jpg");
            teacher16.put("email","cwu@cs.hku.hk");
            teacher16.put("degree","PhD (Toronto)");
            teacher16.put("study_content","Computer Networking, Cloud Computing");
            data.put(teacher16);

            JSONObject teacher17=new JSONObject();
            teacher17.put("name","Dr. Yiu S.M.");
            teacher17.put("url",host+"/Media/Default/instructors/Yiu%20S.M..jpg");
            teacher17.put("email","smyiu@cs.hku.hk");
            teacher17.put("degree","PhD (HK)");
            teacher17.put("study_content","Bioinformatics, Computer Security and Cryptography");
            data.put(teacher17);

            JSONObject teacher18=new JSONObject();
            teacher18.put("name","Dr. Yiu S.W.");
            teacher18.put("url",host+"/Media/Default/instructors/Yiu%20S.W.%20.jpg");
            teacher18.put("email","swryiu@cs.hku.hk");
            teacher18.put("degree","PhD (UC Berkeley)");
            teacher18.put("study_content","Computer and Network Security");
            data.put(teacher18);

            JSONObject teacher19=new JSONObject();
            teacher19.put("name","Mr. Li F.K.F.");
            teacher19.put("url",host+"\\Media\\Default\\ContentImages\\InstructorNoImg.jpg");
            teacher19.put("email","fkfli@cs.hku.hk");
            teacher19.put("degree","MSc (HK)");
            teacher19.put("study_content","Computer Forensics, Malware Analysis");
            data.put(teacher19);

            JSONObject teacher20=new JSONObject();
            teacher20.put("name","Mr. Mitcheson, G.");
            teacher20.put("url",host+"/Media/Default/instructors/Mitcheson,%20G..jpg");
            teacher20.put("email","georgem@cs.hku.hk");
            teacher20.put("degree","BSc, MSc (Manc)");
            teacher20.put("study_content","Software Engineering, Evolutionary Computation and Design");
            data.put(teacher20);

            JSONObject teacher21=new JSONObject();
            teacher21.put("name","Mr. Ng P.T.L.");
            teacher21.put("url",host+"/Media/Default/instructors/Ng%20P.T.L..jpg");
            teacher21.put("email","tlng@cs.hku.hk");
            teacher21.put("degree","MBA (Birmingham)");
            teacher21.put("study_content","Financial Computing");
            data.put(teacher21);

            JSONObject teacher22=new JSONObject();
            teacher22.put("name","Prof. Cheung D.W.L.");
            teacher22.put("url",host+"/Media/Default/instructors/Cheung%20D.W.L..jpg");
            teacher22.put("email","dcheung@cs.hku.hk");
            teacher22.put("degree","PhD (Simon Fraser)");
            teacher22.put("study_content","Data Engineering, e-Commerce Technology");
            data.put(teacher22);

            JSONObject teacher23=new JSONObject();
            teacher23.put("name","Prof. Kao B.C.M.");
            teacher23.put("url",host+"/Media/Default/instructors/Kao%20B.C.M..jpg");
            teacher23.put("email","kao@cs.hku.hk");
            teacher23.put("degree","PhD (Princeton)");
            teacher23.put("study_content","Database Management Systems, Data Mining, Real-time Systems, Information Retrieval Systems");
            data.put(teacher23);

            JSONObject teacher24=new JSONObject();
            teacher24.put("name","Prof. Lam T.W.");
            teacher24.put("url",host+"/Media/Default/instructors/Lam%20T.W..jpg");
            teacher24.put("email"," twlam@cs.hku.hk");
            teacher24.put("degree","PhD (Washington)");
            teacher24.put("study_content","Algorithms, Computational Biology");
            data.put(teacher24);

            JSONObject teacher25=new JSONObject();
            teacher25.put("name","Prof. Lau F.C.M.");
            teacher25.put("url",host+"/Media/Default/instructors/Lau%20F.C.M..jpg");
            teacher25.put("email","fcmlau@cs.hku.hk");
            teacher25.put("degree","PhD (Waterloo)");
            teacher25.put("study_content","Operating Systems, Parallel and Distributed Computing, Wireless Networks");
            data.put(teacher25);

            JSONObject teacher26=new JSONObject();
            teacher26.put("name","Prof. Tse T.H.");
            teacher26.put("url",host+"/Media/Default/instructors/Tse%20T.H..jpg");
            teacher26.put("email","thtse@cs.hku.hk");
            teacher26.put("degree","PhD (London)");
            teacher26.put("study_content","Program Testing, Debugging, and Analysis");
            data.put(teacher26);

            JSONObject teacher27=new JSONObject();
            teacher27.put("name","Prof. Wang C.L.");
            teacher27.put("url",host+"/Media/Default/instructors/WangCL.jpg");
            teacher27.put("email","clwang@cs.hku.hk");
            teacher27.put("degree","PhD (USC)");
            teacher27.put("study_content","Operating Systems, Virtual Machines, Cloud Computing");
            data.put(teacher27);

            JSONObject teacher28=new JSONObject();
            teacher28.put("name","Prof. Wang W.");
            teacher28.put("url",host+"/Media/Default/instructors/Wang%20W..jpg");
            teacher28.put("email","wenping@cs.hku.hk");
            teacher28.put("degree","PhD (Alberta)");
            teacher28.put("study_content","Computer Graphics, Computational Geometry, Geometric Modeling");
            data.put(teacher28);

            JSONObject teacher29=new JSONObject();
            teacher29.put("name","Prof. White B.");
            teacher29.put("url",host+"/Media/Default/instructors/BeboWhite.jpg");
            teacher29.put("email","bwhite@cs.hku.hk");
            teacher29.put("degree","MS (US)");
            teacher29.put("study_content","Web Science, Social Media in Education, The Web of Things, and Cloud Computing");
            data.put(teacher29);

            faculty.put("data",data);
            faculty.put("imageUrl",host+"/Media/Default/ContentImages/contentH-Instructors.jpg");
            faculty.put("type","faculty");
            list.add(AboutFragment.newInstance(faculty));
        }
        catch (JSONException e){
            list.add(AboutFragment.newInstance("Whops, something is wrong!"));
        }



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
            list.add(AboutFragment.newInstance("Whops, something is wrong!"));
        }

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





