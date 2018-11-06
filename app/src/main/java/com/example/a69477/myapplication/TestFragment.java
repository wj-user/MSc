package com.example.a69477.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFragment extends Fragment {

    private TextView tv,tv_title;

    private String type;
    public static TestFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("type","");
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 暂时按type分，要是对页面有分类可以直接对界面分
     * @param title 当前页面的标题
     * @param body  当前界面具体内容
     * @param type  admission/curriculum等
     * @param number    当前子类的第n个界面
     * @return
     */
    public static TestFragment newInstance(String title,String body,String type,int number){
        Bundle args = new Bundle();
        //args.putString("name", name);
        args.putString("title",title);
        args.putString("body",body);
        args.putString("type",type);
        args.putInt("number",number);
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = (TextView) view.findViewById(R.id.fragment_test_tv);
        tv_title=(TextView)view.findViewById(R.id.fragment_test_title);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if(!bundle.get("type").equals("")){//已标记分类
                String title=bundle.get("title").toString();
                String body = bundle.get("body").toString();

                tv_title.setText(title);
                tv_title.setVisibility(View.VISIBLE);
                tv_title.setTextSize(35);

                tv.setText(body);
                tv.setTextSize(18);
                tv.setTypeface(Typeface.SERIF);
            }
            else {
                tv_title.setVisibility(View.GONE);
                String name = bundle.get("name").toString();
                tv.setText(name);
            }
        }

    }

}

