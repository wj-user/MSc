package com.example.a69477.myapplication;

import android.content.Intent;
import android.os.Bundle;


import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import static com.example.a69477.myapplication.R.id.nav_Admission;


public class MainActivity extends AppCompatActivity  {

    private DrawerLayout mDrawerLayout;
    private ViewPager mPcitureviewpager;
    private int[] mImage = new int[10];

    // private CircleIndicator = mCircleindicator;
    private void initView() {
        mPcitureviewpager = (ViewPager) findViewById(R.id.picture);
        mImage[0] = R.drawable.school;
        mImage[1] = R.drawable.slider;
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

                } else if (id == R.id.nav_Gratuate) {

                } else if (id == R.id.nav_News) {

                } else if (id == R.id.nav_About) {

                } else if (id == R.id.nav_Resource) {

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
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }//右上菜单触发效果
}








