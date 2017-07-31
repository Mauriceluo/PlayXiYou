package com.example.xiyou3g.playxiyou.EduFragment;

import android.app.ProgressDialog;
import android.content.Context;
<<<<<<< HEAD
import android.graphics.drawable.ColorDrawable;
=======
<<<<<<< HEAD
import android.graphics.drawable.ColorDrawable;
=======
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
import android.support.v4.widget.SwipeRefreshLayout;
=======
<<<<<<< HEAD
import android.support.v4.widget.SwipeRefreshLayout;
=======
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
import com.example.xiyou3g.playxiyou.Adapter.ScoreAdapter;
import com.example.xiyou3g.playxiyou.Adapter.ScoreTeamAdapter;
import com.example.xiyou3g.playxiyou.DataBean.ProjectBean;
import com.example.xiyou3g.playxiyou.DataBean.ScoreYearAndTeam;
<<<<<<< HEAD
import com.example.xiyou3g.playxiyou.HttpRequest.GetScoreData;
import com.example.xiyou3g.playxiyou.R;
=======
<<<<<<< HEAD
import com.example.xiyou3g.playxiyou.HttpRequest.GetScoreData;
import com.example.xiyou3g.playxiyou.R;
=======
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
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//    private RecyclerView scoreTeamRecyc;
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
    private RecyclerView scoreRecyc;
    private TextView isData;

    private View view;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//    private LinearLayoutManager linearLayoutManager1;
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
    private LinearLayoutManager linearLayoutManager2;
    private TextView current;

    private List<ScoreYearAndTeam> yearList;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//    private ScoreTeamAdapter scoreTeamAdapter;
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
    private ScoreAdapter scoreAdapter;

    private ProgressDialog dialog;

    private ImageView bselect;
    private List<String> select;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
    private CoordinatorLayout main_layout;

    private SwipeRefreshLayout swipeRefreshLayout;
    private int isrefresh = 0;

<<<<<<< HEAD
=======
=======
    private PopupWindow popupWindow;
    private CoordinatorLayout main_layout;

>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//        scoreTeamRecyc = (RecyclerView) view.findViewById(R.id.select_team_recycler);
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
        scoreRecyc = (RecyclerView) view.findViewById(R.id.score_recycler);
        current = (TextView) view.findViewById(R.id.score_time);
        isData = (TextView) view.findViewById(R.id.score_tv);

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
        bselect = (ImageView) view.findViewById(R.id.bttest);
        main_layout = (CoordinatorLayout) view.findViewById(R.id.score_layout);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.days,R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isrefresh = 1;
                new Thread(new GetScoreData(Year,Team)).start();              //获取成绩信息;
            }
        });

<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
        bselect = (ImageView) view.findViewById(R.id.bttest);
        main_layout = (CoordinatorLayout) view.findViewById(R.id.score_layout);

=======
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
        current.setText(currentScore);

        if(stuname.equals("null")){
            isData.setVisibility(View.VISIBLE);
        }else{
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
//            linearLayoutManager1 = new LinearLayoutManager(getContext());
//            linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
//            scoreTeamRecyc.setLayoutManager(linearLayoutManager1);

>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
            linearLayoutManager2 = new LinearLayoutManager(getContext());
            linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
            scoreRecyc.setLayoutManager(linearLayoutManager2);

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
//            scoreTeamAdapter = new ScoreTeamAdapter(yearList);
//            scoreTeamRecyc.setAdapter(scoreTeamAdapter);
=======
            scoreTeamAdapter = new ScoreTeamAdapter(yearList);
            scoreTeamRecyc.setAdapter(scoreTeamAdapter);
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079

>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
            scoreAdapter = new ScoreAdapter(scoreBeanList);
            scoreRecyc.setAdapter(scoreAdapter);

            select = new ArrayList<>();
            for(int i =yearList.size()-1;i>=0;i--){
                select.add(yearList.get(i).getYear()+"   第"+yearList.get(i).getTeam()+"学期");
            }
            bselect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
                    if(popupWindow != null &&popupWindow.isShowing()){
                        popupWindow.dismiss();
                        popupWindow = null;
                    }else {
                        showPopupWindow();
                    }
                }
            });
            if(isrefresh == 1){
                swipeRefreshLayout.setRefreshing(false);
                isrefresh = 0;
            }
<<<<<<< HEAD
=======
=======
                    showPopupWindow();
                }
            });

>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.showAsDropDown(bselect);
    }

<<<<<<< HEAD
=======
=======
        popupWindow.showAsDropDown(bselect);
    }
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
}
