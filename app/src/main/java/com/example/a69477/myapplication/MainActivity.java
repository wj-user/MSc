package com.example.a69477.myapplication;

import android.content.Intent;
import android.os.Bundle;


import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static com.example.a69477.myapplication.R.id.nav_Admission;


public class MainActivity extends AppCompatActivity  {

    private DrawerLayout mDrawerLayout;
    private ViewPager mPcitureviewpager;
    private int[] mImage = new int[10];

    // private CircleIndicator = mCircleindicator;
    private void initView() {
        mPcitureviewpager = (ViewPager) findViewById(R.id.picture);
        mImage[0] = R.drawable.hku1;
        mImage[1] = R.drawable.slide1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //---------------------------------------------------------------------
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//标题
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //---------------------------------------------------------------------
        ImageView img1 =(ImageView) findViewById(R.id.schedule);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/ProgrammeSchedule.jpg").into(img1);
        ImageView img2 =(ImageView) findViewById(R.id.fee);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/ProgrammeFees.jpg").into(img2);
        ImageView img3 =(ImageView) findViewById(R.id.ddl);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/ApplicationDeadlines.jpg").into(img3);
        ImageView img4 =(ImageView) findViewById(R.id.Overview);
        Glide.with(this).load(R.drawable.cover).into(img4);
        //---------------------------------------------------------------------
        CardView my_program_sch = (CardView) findViewById(R.id.psCard);
        my_program_sch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,ProSchedule.class);
                startActivity(intent1);
            }
        });

        CardView my_composition_fee = (CardView) findViewById(R.id.cfCard);
        my_composition_fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,CompositionFees.class);
                startActivity(intent2);
            }
        });


        //---------------------------------------------------------------------
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        }
        navView.setCheckedItem(nav_Admission);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_Admission) {
                    Intent intent = new Intent(MainActivity.this, application.class);
                    startActivityForResult(intent, 11);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                } else if (id == R.id.nav_Curriculum) {
                    Intent intent = new Intent(MainActivity.this, Curriculum.class);
                    startActivityForResult(intent, 11);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                } else if (id == R.id.nav_Gratuate) {

                } else if (id == R.id.nav_News) {

                } else if (id == R.id.nav_About) {
                    Intent intent = new Intent(MainActivity.this, About.class);
                    startActivityForResult(intent, 11);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                } else if (id == R.id.nav_Resource) {
                    Intent intent = new Intent(MainActivity.this, Sresource.class);
                    startActivityForResult(intent, 11);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        //---------------------------------------------------------------------
        initView();
        AdvertiseViewpagerAdapter advertiseViewpagerAdapter = new AdvertiseViewpagerAdapter(mImage);
        mPcitureviewpager.setAdapter(advertiseViewpagerAdapter);
    } //---------------------------------------------------------------------

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }//右上菜单


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Phone Call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mail_us:
                Toast.makeText(this, "You clicked Mail us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }//右上菜单触发效果
}








