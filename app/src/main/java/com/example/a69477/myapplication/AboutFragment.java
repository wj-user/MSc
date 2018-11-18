package com.example.a69477.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutFragment extends Fragment {

    private TextView tv,tv_title;
    private TextView title;

    private String type;
    public static AboutFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("type","");
        AboutFragment fragment = new AboutFragment();
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
    public static AboutFragment newInstance(String title, String body, String type, int number){
        Bundle args = new Bundle();
        //args.putString("name", name);
        args.putString("title",title);
        args.putString("body",body);
        args.putString("type",type);
        args.putInt("number",number);
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param json 直接通过json传参，方便geguia buddle不能存jsonobject
     * @return
     */
    public static AboutFragment newInstance(JSONObject json){
        AboutFragment fragment=new AboutFragment();
        Bundle args=new Bundle();
        args.putString("JSON_STRING",json.toString());
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        JSONObject json=new JSONObject();
        title=view.findViewById(R.id.title);
        ImageView imageView = view.findViewById(R.id.about_header);
        if(bundle.getString("JSON_STRING")!=null) {
            try {
                String json_string = bundle.getString("JSON_STRING");
                json = new JSONObject(json_string);
                title.setText(json.get("title").toString());
                title.setVisibility(View.VISIBLE);
                if (json.optString("title").equals("MESSAGE FROM PROGRAM DIRECTOR")){
                    Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/mfpd-L.jpg").into(imageView);
                    JSONObject part1 = json.optJSONObject("part1");
                    TextView title1 = view.findViewById(R.id.title);
                    title1.setText(part1.optString("title"));

                    CardView mycard1 = view.findViewById(R.id.about_card1);
                    mycard1.setVisibility(View.VISIBLE);

                    JSONArray data1 = part1.optJSONArray("data");
                    TextView part1_1 = view.findViewById(R.id.about_card1_text1);
                    part1_1.setText(data1.optString(0));

                    TextView part1_2 = view.findViewById(R.id.about_card1_text2);
                    part1_2.setText(data1.optString(1) + "\n");

                    TextView part1_3 = view.findViewById(R.id.about_card1_text3);
                    part1_3.setText(data1.optString(2) + "\n");

                    String seq3 = data1.optString(3);//+ "\n" + "\n";
                    TextView part1_4 = view.findViewById(R.id.about_card1_text4);
                    part1_4.setText(seq3);

                    TextView part1_5 = view.findViewById(R.id.about_card1_text5);
                    part1_5.setText(data1.optString(4) );

                    ImageView mycard1_img = view.findViewById(R.id.about_card1_img);
                    Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/instructors/ChowKP-Square250.jpg").into(mycard1_img);
                }
                else if(json.optString("type").equals("faculty")){
                    Glide.with(this).load(json.optString("imageUrl")).into(imageView);
                    JSONArray data= json.optJSONArray("data");
                    for(int i=1;i<=data.length();i++){
                        JSONObject teacher=data.optJSONObject(i-1);
                        String name=teacher.optString("name");
                        String url=teacher.optString("url");
                        String degree=teacher.optString("degree");
                        String study_content=teacher.optString("study_content");

                        String CardName="teacher"+i;
                        int CardId=getResources().getIdentifier(CardName,"id","com.example.a69477.myapplication");
                        CardView teacherCard=view.findViewById(CardId);
                        teacherCard.setVisibility(View.VISIBLE);

                        String imageName="teacher"+i+"_url";
                        int ImageId=getResources().getIdentifier(imageName,"id","com.example.a69477.myapplication");
                        ImageView teacher_image=view.findViewById(ImageId);
                        Glide.with(this).load(url).into(teacher_image);

                        String nameName="teacher"+i+"_name";
                        int nameId=getResources().getIdentifier(nameName,"id","com.example.a69477.myapplication");
                        TextView teacher_name=view.findViewById(nameId);
                        teacher_name.setText(name);

                        String degreeName="teacher"+i+"_degree";
                        int degreeId=getResources().getIdentifier(degreeName,"id","com.example.a69477.myapplication");
                        TextView teacher_degree=view.findViewById(degreeId);
                        teacher_degree.setText(degree);

                        String study_contentName="teacher"+i+"_study_content";
                        int study_contentId=getResources().getIdentifier(study_contentName,"id","com.example.a69477.myapplication");
                        TextView teacher_study_content=view.findViewById(study_contentId);
                        teacher_study_content.setText(study_content);
                    }
                }
                else {
                    Glide.with(this).load(json.optString("imageUrl")).into(imageView);
                    String data = json.optString("content");
                    TextView content=view.findViewById(R.id.content);
                    content.setText(data);
                    content.setVisibility(View.VISIBLE);
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

