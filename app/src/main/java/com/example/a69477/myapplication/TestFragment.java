package com.example.a69477.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestFragment extends Fragment {

    private TextView tv,tv_title;
    private TextView title;

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

    /**
     *
     * @param json 直接通过json传参，方便geguia buddle不能存jsonobject
     * @return
     */
    public static TestFragment newInstance(JSONObject json){
        TestFragment fragment=new TestFragment();
        Bundle args=new Bundle();
        args.putString("JSON_STRING",json.toString());
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
        Bundle bundle= getArguments();
        JSONObject json=new JSONObject();
        title=view.findViewById(R.id.title);
        if(bundle.getString("JSON_STRING")!=null) {
            try {
                String json_string = bundle.getString("JSON_STRING");
                json = new JSONObject(json_string);
                title.setText(json.get("title").toString());
                title.setVisibility(View.VISIBLE);
                for (int i = 1; i <= 5; i++) {   //假设最多5个part
                    if (json.optJSONObject("part" + i) != null) {     //存在某个part
                        JSONObject temp = json.optJSONObject("part" + i);//这个part
                        String number = temp.optString("number");

                        String strTitle = "title" + number;
                        int title_id = getResources().getIdentifier(strTitle, "id", "com.example.a69477.myapplication");
                        TextView title = view.findViewById(title_id);
                        title.setText(temp.optString("title"));
                        title.setVisibility(View.VISIBLE);

                        String strTitleIntro = strTitle + "_intro";
                        int title_intro_id = getResources().getIdentifier(strTitleIntro, "id", "com.example.a69477.myapplication");
                        TextView title_intro = view.findViewById(title_intro_id);
                        title_intro.setText(temp.optString("intro"));
                        title_intro.setVisibility(View.VISIBLE);

                        JSONArray data = temp.optJSONArray("data");
                        int length = data.length();
                        for (int j = 1; j <= length; j++) {
                            String tempData = data.optString(j - 1);
                            String title_data_name = "part" + number + "_" + j;
                            int tempData_id = getResources().getIdentifier(title_data_name, "id", "com.example.a69477.myapplication");
                            TextView tempDataTextView = view.findViewById(tempData_id);
                            tempDataTextView.setText(tempData);
                            tempDataTextView.setVisibility(View.VISIBLE);
                        }

                    }
                }

            } catch (JSONException e) {
                title.setText("Whops,something is wrong");
            }
        }
        else {
            title.setText(bundle.get("name").toString());
        }
    }

}

