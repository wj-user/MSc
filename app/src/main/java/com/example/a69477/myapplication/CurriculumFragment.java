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
                    String titleIntro=json.optJSONObject("part1").optJSONArray("data").optString(0);
                    TextView title_intro=view.findViewById(R.id.title_intro);
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
                    String title2 = "Multimedia Computing";
                    String imageUrl2 = multimedia.optString("imageUrl");
                    String intro2 = multimedia.optString("Multimedia Computing");

                    CardView cardView2 = view.findViewById(R.id.card2);
                    cardView2.setVisibility(View.VISIBLE);
                    ImageView imageView2 = view.findViewById(R.id.card2_img);
                    Glide.with(this).load(imageUrl2).into(imageView2);

                    TextView card2_title=view.findViewById(R.id.card2_title);
                    card2_title.setText(title2);
                    TextView card2_intro=view.findViewById(R.id.card2_intro);
                    card2_intro.setText(intro2);

                    JSONObject financial = data.optJSONObject(2);
                    String title3="Financial Computing";
                    String imageUrl3=financial.optString("imageUrl");
                    String intro3=financial.optString("Financial Computing");
                    CardView cardView3=view.findViewById(R.id.card3);
                    cardView3.setVisibility(View.VISIBLE);
                    ImageView imageView3=view.findViewById(R.id.card3_img);
                    Glide.with(this).load(imageUrl3).into(imageView3);
                    TextView card3_title=view.findViewById(R.id.card3_title);
                    card3_title.setText(title3);
                    TextView card3_intro=view.findViewById(R.id.card3_intro);
                    card3_intro.setText(intro3);

                    JSONObject general = data.optJSONObject(3);
                    String title4="General Stream";
                    String imageUrl4=general.optString("imageUrl");
                    String intro4=general.optString("General Stream");
                    CardView cardView4=view.findViewById(R.id.card4);
                    cardView4.setVisibility(View.VISIBLE);
                    ImageView imageView4=view.findViewById(R.id.card4_img);
                    Glide.with(this).load(imageUrl4).into(imageView4);
                    TextView card4_title=view.findViewById(R.id.card4_title);
                    card4_title.setText(title4);
                    TextView card4_intro=view.findViewById(R.id.card4_intro);
                    card4_intro.setText(intro4);




                }else if(json.optString("title").equals("")){

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

