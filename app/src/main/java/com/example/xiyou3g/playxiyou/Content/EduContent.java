package com.example.xiyou3g.playxiyou.Content;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.widget.PopupWindow;

import com.android.volley.RequestQueue;
import com.baidu.location.LocationClient;
import com.example.xiyou3g.playxiyou.DataBean.CourseBean;
import com.example.xiyou3g.playxiyou.DataBean.MajorBean;
import com.example.xiyou3g.playxiyou.DataBean.ProjectBean;
import com.example.xiyou3g.playxiyou.DataBean.ScoreBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lance on 2017/7/12.
 */

public class EduContent {

    static public int isAllRequest = 1;
    static public  LocationClient client;

    static public int UPDATE_COURSE = 1;
    static public int UPDATE_SCORE = 2;
    static public Handler handler = new Handler();

    static public String cookies;
    static public RequestQueue mqueue;
    static public String loginName;     //学号;
    static public String loginPassword; //登录密码;
    static public String loginCheckCode;
    static public String student_name;  //姓名;

    static public List<CourseBean> courseList = new ArrayList<>();
    static public List<ScoreBean> scoreBeanList = new ArrayList<>();
    static public String course_content = null;
    static public String currentScore = "";
    static public int sYear = 0;

    static public String stuname;       //学生姓名;
    static public String stuid;         //学号;
    static public String stuacademy;    //学院;
    static public String stumajor;      //专业;
    static public String stuclass;      //班级;
    static public String stueducation;  //学历;
    static public String stuYear;       //入学年份;
    static public String stuSex;        //性别;

    static public String Year;
    static public String Team;
    static public PopupWindow popupWindow;

    static public FragmentManager fragmentManager;

    static public List<List<ProjectBean>> proList = new ArrayList<>();
    static public List<MajorBean> majorBeanList = new ArrayList<>();
    static public List<String> ViewStatelist = new ArrayList<>();
}
