package com.example.xiyou3g.playxiyou.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.xiyou3g.playxiyou.DataBean.ProjectBean;
import com.example.xiyou3g.playxiyou.HttpRequest.GetCourseData;
import com.example.xiyou3g.playxiyou.HttpRequest.GetPerInfo;
import com.example.xiyou3g.playxiyou.HttpRequest.GetProjectData;
import com.example.xiyou3g.playxiyou.R;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.xiyou3g.playxiyou.Content.EduContent.*;
import static com.example.xiyou3g.playxiyou.Content.AttenContent.*;

/**
 * Created by Lance on 2017/7/12.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText username;          //账号；
    private EditText password;          //密码；
    private EditText codeCheck;         //验证码；
    private ImageView userClear;
    private ImageView passSee;
    private ImageView codeImage;
    private Button login;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox remberPass;

    private Boolean isCanSee = false;
    private int flag;
    private byte[] imagebytes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        islogin = 0;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mqueue = Volley.newRequestQueue(this);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        initWight();                    //实例化控件;
    }

    private void initWight() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        codeCheck = (EditText) findViewById(R.id.codeedit);
        userClear = (ImageView) findViewById(R.id.userclear);
        passSee = (ImageView) findViewById(R.id.passSee);
        codeImage = (ImageView) findViewById(R.id.codeCheck);
        login = (Button) findViewById(R.id.login);
        codeCheck.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        remberPass = (CheckBox) findViewById(R.id.remember_pass);

        boolean isRemeber = pref.getBoolean("remember",false);
        if(isRemeber){
            username.setText(pref.getString("username",""));
            password.setText(pref.getString("password",""));
            remberPass.setChecked(true);
        }

        initCodeImage();
        userClear.setOnClickListener(this);
        passSee.setOnClickListener(this);
        login.setOnClickListener(this);
        codeImage.setOnClickListener(this);
    }

    private void initCodeImage() {
        final String checkCodeImageUrl = "http://222.24.62.120/CheckCode.aspx";

        StringRequest getCheckCode = new StringRequest(Request.Method.GET, checkCodeImageUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imagebytes, 0, imagebytes.length);
                codeImage.setImageBitmap(bitmap);
                //Log.e("qwe", "success");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                codeImage.setImageResource(R.mipmap.codeerror);
            }
        }){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                imagebytes = response.data;
                Log.e("response_headers", response.headers + "");
                cookies = response.headers.get("Set-Cookie");
                String dataString;
                try{
                    dataString = new String(response.data,"UTF-8");
                    return Response.success(dataString, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };
        mqueue.add(getCheckCode);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userclear:
                username.setText("");
                password.setText("");
                break;
            case R.id.passSee:
                if(isCanSee){
                    isCanSee = false;
                    passSee.setImageResource(R.mipmap.eye_cant_see);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    isCanSee = true;
                    passSee.setImageResource(R.mipmap.eyes_can_see);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                break;
            case R.id.codeCheck:
                initCodeImage();
                break;
            case R.id.login:

                final String url = "http://222.24.62.120/default2.aspx";
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("信息提示：");

                loginName = username.getText().toString();
                loginPassword = password.getText().toString();
                loginCheckCode = codeCheck.getText().toString();

                Log.e("information:", loginName + "-" + loginPassword + "-" + loginCheckCode);
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if(flag == 1){
                            Document document1 = Jsoup.parse(s);
                            student_name = document1.getElementById("xhxm").text();
                            student_name = student_name.substring(0, student_name.length() - 2);
                            Log.e("student_name:", student_name);

                            new Thread(new GetPerInfo()).start();       //获取个人信息;
                            getCurrentCourse();                         //获取当前课表;

                            builder.setMessage("欢迎您，"+student_name+"同学！");
                            builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    editor = pref.edit();
                                    Log.e("checkbox state",remberPass.isChecked()+"");
                                    if(remberPass.isChecked()){
                                        editor.putBoolean("remember",true);
                                        editor.putString("username",username.getText().toString());
                                        editor.putString("password",password.getText().toString());
                                    }else{
                                        editor.clear();
                                    }
                                    editor.apply();
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).create().show();
                        } else {
                            builder.setMessage("登录失败，请重新登录");
                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    initCodeImage();
                                }
                            }).create().show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        builder.setMessage("请检查网络连接");
                        builder.setPositiveButton("确认",null).create().show();
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String,String> header = new HashMap<>();
                        header.put("Cookie",cookies);
                        header.put("Referer","http://222.24.62.120/");
                        header.put("Pragma","no-cache");
                        header.put("Accept-Encoding","gzip, deflate");
                        header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                        header.put("Accept-Language","zh-Hans-CN,zh-Hans;q=0.8");
                        header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
                        Log.e("cookie",cookies+"1111111");
                        return header;
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        return ("__VIEWSTATE=dDwtNTE2MjI4MTQ7Oz5O9kSeYykjfN0r53Yqhqckbvd83A==&txtUserName=" +loginName
                                +"&Textbox1=&TextBox2=" +loginPassword
                                +"&txtSecretCode=" +loginCheckCode
                                +"&RadioButtonList1=%D1%A7%C9%FA&Button1=&lbLanguage=&hidPdrs=&hidsc=").getBytes();
                    }

                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        System.out.println(response.headers);
                        Log.e("statusCode",response.statusCode+"   length="+response.headers.size());
                        if(response.headers.size() == 13){
                            flag = 1;
                        }
                        return super.parseNetworkResponse(response);
                    }
                };
                mqueue.add(request);
                break;
        }
    }

    private void getCurrentCourse() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        new Thread(new GetCourseData(year,month,1)).start();
    }

    private List<String> getVisState(final List<String> list) {
        list.clear();
        for(int i = 0;i< 8;i++){
            String url = "http://222.24.62.120/pyjh.aspx?xh="+loginName+"&xm="+student_name+"&gnmkdm=N121607";
            final String[] __viewstate = new String[1];
            StringRequest stringRequest1 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    //repsone_content = s;
                    Document document1 = Jsoup.parse(s);
                    __viewstate[0] = document1.select("input[name=__VIEWSTATE]").val();
                    try {
                        __viewstate[0] = URLEncoder.encode(__viewstate[0],"GBK");
                    } catch (UnsupportedEncodingException e) {
                        Log.e("error","123456789");
                    }
                    Log.e("viewstate      ",__viewstate[0]);
                    list.add(__viewstate[0]);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.e("failure",volleyError+"");
                }
            }){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> header = new HashMap<>();
                    header.put("Cookie",cookies);
                    header.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                    header.put("Referer","http://222.24.62.120/pyjh.aspx?xh="+loginName+"&xm="+student_name+"&gnmkdm=N121607");
                    header.put("Accept-Encoding","gzip, deflate");
                    header.put("Accept-Language", "zh-Hans-CN,zh-Hans,zh;q=0.8");
                    header.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
                    return header;
                }

            };
            mqueue.add(stringRequest1);
        }
        return list;
    }

    private void getAllProject(List<String> list) {
        for(int i =1;i<=8;i++){
            List<ProjectBean> projectBeen = new ArrayList<>();
            proList.add(projectBeen);
            new Thread(new GetProjectData(i,list)).start();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            exitClick();
        }
        return false;
    }

    private static Boolean isExit = false;

    private void exitClick() {
        Timer timer;
        if(isExit == false){
            isExit = true;
            Snackbar.make(login,"再按一次退出程序",Snackbar.LENGTH_SHORT).show();
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            },2000);
        }else{
            finish();
        }
    }
}
