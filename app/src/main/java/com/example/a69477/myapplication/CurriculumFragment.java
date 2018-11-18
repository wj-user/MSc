package com.example.a69477.myapplication;

import android.graphics.Typeface;
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

public class CurriculumFragment extends Fragment {

    private TextView tv,tv_title;
    private TextView title;

    private String type;
    public static CurriculumFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("type","");
        CurriculumFragment fragment = new CurriculumFragment();
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
    public static CurriculumFragment newInstance(String title, String body, String type, int number){
        Bundle args = new Bundle();
        //args.putString("name", name);
        args.putString("title",title);
        args.putString("body",body);
        args.putString("type",type);
        args.putInt("number",number);
        CurriculumFragment fragment = new CurriculumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param json 直接通过json传参，方便geguia buddle不能存jsonobject
     * @return
     */
    public static CurriculumFragment newInstance(JSONObject json){
        CurriculumFragment fragment=new CurriculumFragment();
        Bundle args=new Bundle();
        args.putString("JSON_STRING",json.toString());
        fragment.setArguments(args);
        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_curriculum, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments();
        JSONObject json=new JSONObject();
        title=view.findViewById(R.id.title);
        ImageView curri_header = view.findViewById(R.id.curri_header);
        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/ProgrammeOverview.jpg").into(curri_header);
        if(bundle.getString("JSON_STRING")!=null) {
            try {
                String json_string = bundle.getString("JSON_STRING");
                json = new JSONObject(json_string);
                title.setText(json.get("title").toString());
                title.setVisibility(View.VISIBLE);
                if(json.optString("title").equals("Programme Overview")){
                    String titleIntro=json.optJSONObject("part1").optJSONArray("data").optString(0)+"\n\n"+json.optJSONObject("part1").optJSONArray("data").optString(1)+"\n\n"+json.optJSONObject("part1").optJSONArray("data").optString(2)+"\n";
                    TextView title_intro=view.findViewById(R.id.title_intro);
                    title_intro.setVisibility(View.VISIBLE);
                    title_intro.setText(titleIntro);

                    JSONArray data= json.optJSONArray("stream");
                    JSONObject cyber=data.optJSONObject(0);
                    String title="Cyber Security";
                    String imageUrl=cyber.optString("imageUrl");
                    String intro = cyber.optString("Cyber Security");

                    CardView cardView1 = view.findViewById(R.id.card1);
                    cardView1.setVisibility(View.VISIBLE);
                    ImageView imageView=view.findViewById(R.id.card1_img);
                    Glide.with(this).load(imageUrl).into(imageView);

                    TextView card1_title=view.findViewById(R.id.card1_title);
                    card1_title.setText(title);
                    TextView card1_intro=view.findViewById(R.id.card1_intro);
                    card1_intro.setText(intro);

                    JSONObject multimedia = data.optJSONObject(1);
                    String title2Text = "Multimedia Computing";
                    String imageUrl2 = multimedia.optString("imageUrl");
                    String intro2Text = multimedia.optString("Multimedia Computing");

                    CardView cardView2 = view.findViewById(R.id.card2);
                    cardView2.setVisibility(View.VISIBLE);
                    ImageView imageView2 = view.findViewById(R.id.card2_img);
                    Glide.with(this).load(imageUrl2).into(imageView2);

                    TextView card2_title=view.findViewById(R.id.card2_title);
                    card2_title.setText(title2Text);
                    TextView card2_intro=view.findViewById(R.id.card2_intro);
                    card2_intro.setText(intro2Text);

                    JSONObject financial = data.optJSONObject(2);
                    String title3Text="Financial Computing";
                    String imageUrl3=financial.optString("imageUrl");
                    String intro3Text=financial.optString("Financial Computing");
                    CardView cardView3=view.findViewById(R.id.card3);
                    cardView3.setVisibility(View.VISIBLE);
                    ImageView imageView3=view.findViewById(R.id.card3_img);
                    Glide.with(this).load(imageUrl3).into(imageView3);
                    TextView card3_title=view.findViewById(R.id.card3_title);
                    card3_title.setText(title3Text);
                    TextView card3_intro=view.findViewById(R.id.card3_intro);
                    card3_intro.setText(intro3Text);

                    JSONObject general = data.optJSONObject(3);
                    String title4Text="General Stream";
                    String imageUrl4=general.optString("imageUrl");
                    String intro4=general.optString("General Stream");
                    CardView cardView4=view.findViewById(R.id.card4);
                    cardView4.setVisibility(View.VISIBLE);
                    ImageView imageView4=view.findViewById(R.id.card4_img);
                    Glide.with(this).load(imageUrl4).into(imageView4);
                    TextView card4_title=view.findViewById(R.id.card4_title);
                    card4_title.setText(title4Text);
                    TextView card4_intro=view.findViewById(R.id.card4_intro);
                    card4_intro.setText(intro4);

                    JSONObject part2=json.optJSONObject("part2");
                    TextView title2=view.findViewById(R.id.title2);
                    title2.setText(part2.optString("title"));
                    title2.setVisibility(View.VISIBLE);
                    TextView part2_1=view.findViewById(R.id.part2_1);
                    part2_1.setText(part2.optJSONArray("data").optString(0));
                    part2_1.setVisibility(View.VISIBLE);

                    JSONObject part3=json.optJSONObject("part3");
                    TextView title3=view.findViewById(R.id.title3);
                    title3.setText(part3.optString("title"));
                    title3.setVisibility(View.VISIBLE);
                    TextView title3_intro=view.findViewById(R.id.title3_intro);
                    title3_intro.setText(part3.optString("intro"));
                    TextView part3_1=view.findViewById(R.id.part3_1);
                    part3_1.setText(part3.optJSONArray("data").optString(0));
                    part3_1.setVisibility(View.VISIBLE);
                    TextView part3_2=view.findViewById(R.id.part3_2);
                    part3_2.setText(part3.optJSONArray("data").optString(1));
                    part3_2.setVisibility(View.VISIBLE);


                    JSONObject part4=json.optJSONObject("part4");
                    TextView title4=view.findViewById(R.id.title4);
                    title4.setText(part4.optString("title"));
                    title4.setVisibility(View.VISIBLE);
                    TextView part4_1=view.findViewById(R.id.part4_1);
                    part4_1.setText(part4.optJSONArray("data").optString(0));
                    part4_1.setVisibility(View.VISIBLE);

                } else if (json.optString("title").equals("MSc(CompSc) Courses")){
                        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/Curriculum.jpg").into(curri_header);
                        TextView title1 = view.findViewById(R.id.title);
                        title1.setText(json.optString("title"));

                        TextView intro = view.findViewById(R.id.title_intro);
                        intro.setText(json.optString("prologue"));
                        intro.setVisibility(View.VISIBLE);

                        CardView stream1 = view.findViewById(R.id.card_stream1);
                        stream1.setVisibility(View.VISIBLE);
                        JSONArray data1 = json.optJSONArray("data1");
                        for (int i = 1; i < data1.length(); ++i){
                            JSONObject course = data1.optJSONObject(i);
                            String course_num = course.optString("number");
                            String course_name =course.optString("course_name");

                            String course_num_name = "card_stream1_num" + i;
                            int course_NumId=getResources().getIdentifier(course_num_name,"id","com.example.a69477.myapplication");
                            TextView my_course_num=view.findViewById(course_NumId);
                            my_course_num.setText(course_num);

                            String course_name_name = "card_stream1_name" + i;
                            int course_NameId=getResources().getIdentifier(course_name_name,"id","com.example.a69477.myapplication");
                            TextView my_course_name=view.findViewById(course_NameId);
                            my_course_name.setText(course_name);
                        }

                        CardView stream2 = view.findViewById(R.id.card_stream2);
                        stream2.setVisibility(View.VISIBLE);
                        JSONArray data2 = json.optJSONArray("data2");
                        for (int i = 1; i < data2.length(); ++i){
                            JSONObject course = data2.optJSONObject(i);
                            String course_num = course.optString("number");
                            String course_name =course.optString("course_name");

                            String course_num_name = "card_stream2_num" + i;
                            int course_NumId=getResources().getIdentifier(course_num_name,"id","com.example.a69477.myapplication");
                            TextView my_course_num=view.findViewById(course_NumId);
                            my_course_num.setText(course_num);

                            String course_name_name = "card_stream2_name" + i;
                            int course_NameId=getResources().getIdentifier(course_name_name,"id","com.example.a69477.myapplication");
                            TextView my_course_name=view.findViewById(course_NameId);
                            my_course_name.setText(course_name);
                        }

                        CardView stream3 = view.findViewById(R.id.card_stream3);
                        stream3.setVisibility(View.VISIBLE);
                        JSONArray data3 = json.optJSONArray("data3");
                        for (int i = 1; i < data3.length(); ++i){
                            JSONObject course = data3.optJSONObject(i);
                            String course_num = course.optString("number");
                            String course_name =course.optString("course_name");

                            String course_num_name = "card_stream3_num" + i;
                            int course_NumId=getResources().getIdentifier(course_num_name,"id","com.example.a69477.myapplication");
                            TextView my_course_num=view.findViewById(course_NumId);
                            my_course_num.setText(course_num);

                            String course_name_name = "card_stream3_name" + i;
                            int course_NameId=getResources().getIdentifier(course_name_name,"id","com.example.a69477.myapplication");
                            TextView my_course_name=view.findViewById(course_NameId);
                            my_course_name.setText(course_name);
                        }

                        CardView stream4 = view.findViewById(R.id.card_stream4);
                        stream4.setVisibility(View.VISIBLE);
                        JSONArray data4 = json.optJSONArray("data4");
                        for (int i = 1; i < data4.length(); ++i){
                            JSONObject course = data4.optJSONObject(i);
                            String course_num = course.optString("number");
                            String course_name =course.optString("course_name");

                            String course_num_name = "card_stream4_num" + i;
                            int course_NumId=getResources().getIdentifier(course_num_name,"id","com.example.a69477.myapplication");
                            TextView my_course_num=view.findViewById(course_NumId);
                            my_course_num.setText(course_num);

                            String course_name_name = "card_stream4_name" + i;
                            int course_NameId=getResources().getIdentifier(course_name_name,"id","com.example.a69477.myapplication");
                            TextView my_course_name=view.findViewById(course_NameId);
                            my_course_name.setText(course_name);
                        }

                        CardView stream5 = view.findViewById(R.id.card_stream5);
                        stream5.setVisibility(View.VISIBLE);
                        JSONArray data5 = json.optJSONArray("data5");

                        for (int i = 1; i < data5.length(); ++i){
                            JSONObject course = data5.optJSONObject(i);
                            String course_num = course.optString("number");
                            String course_name =course.optString("course_name");

                            String course_num_name = "card_stream5_num" + i;
                            int course_NumId=getResources().getIdentifier(course_num_name,"id","com.example.a69477.myapplication");
                            TextView my_course_num=view.findViewById(course_NumId);
                            my_course_num.setText(course_num);

                            String course_name_name = "card_stream5_name" + i;
                            int course_NameId=getResources().getIdentifier(course_name_name,"id","com.example.a69477.myapplication");
                            TextView my_course_name=view.findViewById(course_NameId);
                            my_course_name.setText(course_name);
                        }

                        TextView comment1 = view.findViewById(R.id.comment1);
                        String firstComment = json.optString("comment1") + "\n";
                        comment1.setText(firstComment);
                        comment1.setVisibility(View.VISIBLE);

                        TextView comment2 = view.findViewById(R.id.comment2);
                        String secondComment = json.optString("comment2") + "\n";
                        comment2.setText(secondComment);
                        comment2.setVisibility(View.VISIBLE);

                        JSONObject data6 = json.optJSONObject("data6");
                        String title2 = data6.optString("title");
                        TextView my_title2 = view.findViewById(R.id.title2);
                        my_title2.setText(title2);
                        my_title2.setVisibility(View.VISIBLE);

                        TextView my_intro2 = view.findViewById(R.id.title2_intro);
                        String title_intro2 = data6.optString("intro");
                        my_intro2.setText(title_intro2);
                        my_intro2.setVisibility(View.VISIBLE);

                        String comment3 = data6.optString("comment");
                        TextView my_comment = view.findViewById(R.id.comment3);
                        my_comment.setText(comment3);
                        my_comment.setVisibility(View.VISIBLE);


                } else if(json.optString("title").equals("Duration of Study")){
                        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/Schedule.jpg").into(curri_header);
                        JSONObject part1 = json.optJSONObject("part1");
                        TextView title1 = view.findViewById(R.id.title);
                        title1.setText(part1.optString("title"));
                        TextView title1_intro = view.findViewById(R.id.title_intro);
                        JSONArray data = part1.optJSONArray("data");
                        String intro_info = data.optString(0) + "\n" + "\n "+ data.optString(1) + "\n" + "\n"+ data.optString(2) + "\n" + "\n" + data.optString(3);
                        title1_intro.setText(intro_info);
                        title1_intro.setVisibility(View.VISIBLE);

                        JSONObject part2 = json.optJSONObject("part2");
                        TextView title2 = view.findViewById(R.id.title2);
                        title2.setText(part2.optString("title"));
                        title2.setVisibility(View.VISIBLE);
                        TextView title2_intro = view.findViewById(R.id.title2_intro);
                        JSONArray data2 = part2.optJSONArray("data");
                        String intro_info2 = data2.optString(0);
                        title2_intro.setVisibility(View.VISIBLE);
                        title2_intro.setText(intro_info2);
                } else if (json.optString("title").equals("Regulations")){
                        Glide.with(this).load("https://www.msc-cs.hku.hk/Media/Default/ContentImages/Regulation.jpg").into(curri_header);
                        JSONObject part1 = json.optJSONObject("part1");
                        TextView title1 = view.findViewById(R.id.title);
                        title1.setText(part1.optString("title"));
                        TextView title1_intro = view.findViewById(R.id.title_intro);
                        title1_intro.setVisibility(View.VISIBLE);
                        JSONArray data = part1.optJSONArray("data");
                        String intro_info = data.optString(0) + "\n" + "\n "+ data.optString(1) + "\n" + "\n"+ data.optString(2);
                        title1_intro.setText(intro_info);

                }



            }catch (JSONException e) {
                title.setText("Whops,something is wrong");
            }
        }
        else {
            title.setText(bundle.get("name").toString());
        }
    }

}

