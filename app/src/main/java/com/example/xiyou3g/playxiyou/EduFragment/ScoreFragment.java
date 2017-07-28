package com.example.xiyou3g.playxiyou.EduFragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
<<<<<<< HEAD
=======

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
import com.example.xiyou3g.playxiyou.Adapter.ScoreAdapter;
import com.example.xiyou3g.playxiyou.Adapter.ScoreTeamAdapter;
import com.example.xiyou3g.playxiyou.DataBean.ProjectBean;
import com.example.xiyou3g.playxiyou.DataBean.ScoreYearAndTeam;
import com.example.xiyou3g.playxiyou.HttpRequest.GetProjectData;
import com.example.xiyou3g.playxiyou.HttpRequest.GetScoreData;
import com.example.xiyou3g.playxiyou.R;
<<<<<<< HEAD
=======

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.xiyou3g.playxiyou.Content.EduContent.*;

/**
 * Created by Lance on 2017/7/12.
 *
 */

public class ScoreFragment extends Fragment {

//    private RecyclerView scoreTeamRecyc;
    private RecyclerView scoreRecyc;
    private TextView isData;

    private View view;
//    private LinearLayoutManager linearLayoutManager1;
    private LinearLayoutManager linearLayoutManager2;
    private TextView current;

    private List<ScoreYearAndTeam> yearList;
//    private ScoreTeamAdapter scoreTeamAdapter;
    private ScoreAdapter scoreAdapter;

    private ProgressDialog dialog;

    private ImageView bselect;
    private List<String> select;
    private PopupWindow popupWindow;
    private CoordinatorLayout main_layout;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dialog = new ProgressDialog(getContext());
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("正在努力加载...");
        dialog.show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.score_fragment,container,false);
        yearList = new ArrayList<>();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 2:
                        initWight(view);
                        Log.e("accept success","666666666666");
                        dialog.dismiss();
                        break;
                    case 4:
                        dialog = new ProgressDialog(getContext());
                        dialog.setMessage("正在努力加载...");
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.show();
                        break;
                }
            }
        };
        if(sYear != 0){
            dialog.dismiss();
        }
        if(yearList.size() == 0 && !stuname.equals("null")){
            getYearAndTeam();
        }
        initWight(view);

        return view;
    }

    private void getYearAndTeam() {
        yearList.clear();
        sYear = Integer.parseInt(stuYear);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        if(month >= 9){
            for(int i =0;i<year - sYear;i++){
                sYear = sYear + i;
                ScoreYearAndTeam scoreYearAndTeam1 = new ScoreYearAndTeam();
                scoreYearAndTeam1.setYear(sYear+"-"+(sYear+1));
                scoreYearAndTeam1.setTeam("1");
                yearList.add(scoreYearAndTeam1);
                ScoreYearAndTeam scoreYearAndTeam2 = new ScoreYearAndTeam();
                scoreYearAndTeam2.setYear(sYear+"-"+(sYear+1));
                scoreYearAndTeam2.setTeam("2");
                yearList.add(scoreYearAndTeam2);
            }
            sYear = sYear + 1;
            ScoreYearAndTeam scoreYearAndTeam1 = new ScoreYearAndTeam();
            scoreYearAndTeam1.setYear(sYear+"-"+(sYear+1));
            scoreYearAndTeam1.setTeam("1");
            yearList.add(scoreYearAndTeam1);
        }else{
            for(int i =0;i<year - sYear;i++){
                sYear = sYear + i;
                ScoreYearAndTeam scoreYearAndTeam1 = new ScoreYearAndTeam();
                scoreYearAndTeam1.setYear(sYear+"-"+(sYear+1));
                scoreYearAndTeam1.setTeam("1");
                yearList.add(scoreYearAndTeam1);
                ScoreYearAndTeam scoreYearAndTeam2 = new ScoreYearAndTeam();
                scoreYearAndTeam2.setYear(sYear+"-"+(sYear+1));
                scoreYearAndTeam2.setTeam("2");
                yearList.add(scoreYearAndTeam2);
            }
        }
    }

    private void initWight(View view) {

//        scoreTeamRecyc = (RecyclerView) view.findViewById(R.id.select_team_recycler);
        scoreRecyc = (RecyclerView) view.findViewById(R.id.score_recycler);
        current = (TextView) view.findViewById(R.id.score_time);
        isData = (TextView) view.findViewById(R.id.score_tv);

<<<<<<< HEAD
        bselect = (ImageView) view.findViewById(R.id.bttest);
        main_layout = (CoordinatorLayout) view.findViewById(R.id.score_layout);

=======
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
        current.setText(currentScore);

        if(stuname.equals("null")){
            isData.setVisibility(View.VISIBLE);
        }else{
//            linearLayoutManager1 = new LinearLayoutManager(getContext());
//            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
//            scoreTeamRecyc.setLayoutManager(linearLayoutManager1);

            linearLayoutManager2 = new LinearLayoutManager(getContext());
            linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
            scoreRecyc.setLayoutManager(linearLayoutManager2);

<<<<<<< HEAD
//            scoreTeamAdapter = new ScoreTeamAdapter(yearList);
//            scoreTeamRecyc.setAdapter(scoreTeamAdapter);
=======
            scoreTeamAdapter = new ScoreTeamAdapter(yearList);
            scoreTeamRecyc.setAdapter(scoreTeamAdapter);
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079

            scoreAdapter = new ScoreAdapter(scoreBeanList);
            scoreRecyc.setAdapter(scoreAdapter);

            select = new ArrayList<>();
            for(int i =yearList.size()-1;i>=0;i--){
                select.add(yearList.get(i).getYear()+"   第"+yearList.get(i).getTeam()+"学期");
            }
            bselect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopupWindow();
                }
            });

        }
    }

    private void showPopupWindow() {
       View view = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow,null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreTeamAdapter scoreTeamAdapter = new ScoreTeamAdapter(yearList);
        recyclerView.setAdapter(scoreTeamAdapter);
        popupWindow = new PopupWindow(main_layout, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(bselect);
    }
}
