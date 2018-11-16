package com.example.a69477.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

public class SresourceFragment extends Fragment {

    private TextView tv,tv_title;
    private TextView title;

    private String type;
    public static SresourceFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("type","");
        SresourceFragment fragment = new SresourceFragment();
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
    public static SresourceFragment newInstance(String title, String body, String type, int number){
        Bundle args = new Bundle();
        //args.putString("name", name);
        args.putString("title",title);
        args.putString("body",body);
        args.putString("type",type);
        args.putInt("number",number);
        SresourceFragment fragment = new SresourceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param json 直接通过json传参，方便geguia buddle不能存jsonobject
     * @return
     */
    public static SresourceFragment newInstance(JSONObject json){
        SresourceFragment fragment=new SresourceFragment();
        Bundle args=new Bundle();
        args.putString("JSON_STRING",json.toString());
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sresource, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        JSONObject json=new JSONObject();
        title=view.findViewById(R.id.title);
        if(bundle.getString("JSON_STRING")!=null) {

        }
        else {
            title.setText(bundle.get("name").toString());
        }
    }

}

