package com.example.xiyou3g.playxiyou.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiyou3g.playxiyou.HttpRequest.GetSiliuData;
import com.example.xiyou3g.playxiyou.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import static com.example.xiyou3g.playxiyou.Content.AttenContent.*;

/**
 * Created by Lance on 2017/7/23.
 */

public class SiliuActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout idWrapper;
    private TextInputLayout nameWrapper;
<<<<<<< HEAD

    private ImageView back;
    private EditText id;
    private EditText name;
    private TextView figure;
    private Button find;

    private ImageView clear;
=======
<<<<<<< HEAD

    private ImageView back;
    private EditText id;
    private EditText name;
    private TextView figure;
    private Button find;

    private ImageView clear;
=======
<<<<<<< HEAD

    private ImageView back;
    private EditText id;
    private EditText name;
    private TextView figure;
    private Button find;

    private ImageView clear;
=======

    private ImageView back;
    private EditText id;
    private EditText name;
    private TextView figure;
    private Button find;
<<<<<<< HEAD

    private ImageView clear;
=======
<<<<<<< HEAD

    private ImageView clear;
=======
<<<<<<< HEAD

    private ImageView clear;
=======
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
>>>>>>> dc73a1145aa1a599cdab9b04d440f49715b04dd5
>>>>>>> e9a8a41fee9b6ad02f284ae5331fa83531f9737f
>>>>>>> 2913b9ccda47fc292b3b20269036ef5eb0c45463

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        Slide slide = new Slide();
//        slide.setDuration(500);
//        getWindow().setEnterTransition(slide);
        setContentView(R.layout.siliu_activity);

        initWight();
    }

    private void initWight() {
        idWrapper = (TextInputLayout) findViewById(R.id.idWrapper);
        nameWrapper = (TextInputLayout) findViewById(R.id.nameWrapper);
        id = (EditText) findViewById(R.id.ailiu_id);
        name = (EditText) findViewById(R.id.ailiu_name);
        find = (Button) findViewById(R.id.siliu_find);
        figure = (TextView) findViewById(R.id.figure);
        back = (ImageView) findViewById(R.id.sback);
<<<<<<< HEAD
        clear = (ImageView) findViewById(R.id.clear);

        clear.setOnClickListener(this);
=======
<<<<<<< HEAD
        clear = (ImageView) findViewById(R.id.clear);

        clear.setOnClickListener(this);
=======
<<<<<<< HEAD
        clear = (ImageView) findViewById(R.id.clear);

        clear.setOnClickListener(this);
=======
<<<<<<< HEAD
        clear = (ImageView) findViewById(R.id.clear);

        clear.setOnClickListener(this);
=======
<<<<<<< HEAD
        clear = (ImageView) findViewById(R.id.clear);

        clear.setOnClickListener(this);
=======
<<<<<<< HEAD
        clear = (ImageView) findViewById(R.id.clear);

        clear.setOnClickListener(this);
=======
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
>>>>>>> dc73a1145aa1a599cdab9b04d440f49715b04dd5
>>>>>>> e9a8a41fee9b6ad02f284ae5331fa83531f9737f
>>>>>>> 2913b9ccda47fc292b3b20269036ef5eb0c45463

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
>>>>>>> dc73a1145aa1a599cdab9b04d440f49715b04dd5
>>>>>>> e9a8a41fee9b6ad02f284ae5331fa83531f9737f
>>>>>>> 2913b9ccda47fc292b3b20269036ef5eb0c45463
                if(s.length()>0){
                    clear.setVisibility(View.VISIBLE);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0,1.0f);
                    alphaAnimation.setDuration(150);
                    clear.setAnimation(alphaAnimation);
                }else{
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0);
                    alphaAnimation.setDuration(150);
                    clear.setAnimation(alphaAnimation);
                    clear.setVisibility(View.GONE);
                }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
>>>>>>> dc73a1145aa1a599cdab9b04d440f49715b04dd5
>>>>>>> e9a8a41fee9b6ad02f284ae5331fa83531f9737f
>>>>>>> 2913b9ccda47fc292b3b20269036ef5eb0c45463
                if(idWrapper.getEditText().getText().length() != 15){
                    figure.setTextColor(Color.RED);
                }else{
                    figure.setTextColor(Color.BLACK);
                }
                figure.setText(s.length()+"/15");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        back.setOnClickListener(this);
        find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.siliu_find:
                String sid = idWrapper.getEditText().getText().toString();
                String sname = nameWrapper.getEditText().getText().toString();
                if(sid.length()>15){
                    idWrapper.setError("准考证号大于15位！");
                }else if(sid.length()<15){
                    idWrapper.setError("准考证号小于15位！");
                }else if(sname.length() == 0){
                    nameWrapper.setError("姓名不能为空！");
                }else if(sname.length()<2){
                    nameWrapper.setError("请至少输入姓名的前两位！");
                }else{
                    final ProgressDialog dialog = new ProgressDialog(this);
                    dialog.setTitle("温馨提示：");
                    dialog.setMessage("正在努力加载...");
                    dialog.show();
                    idWrapper.setErrorEnabled(false);
                    nameWrapper.setErrorEnabled(false);
                    GetSiliuData.getSiliu(sid,sname);
                    attenHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            if(isGet == 1){
                                Dialog dialog = new Dialog(SiliuActivity.this);
                                dialog.setContentView(R.layout.siliu_info);
                                initDialog(dialog);
                                dialog.create();
                                dialog.show();
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(SiliuActivity.this);
                                builder.setTitle("温习提示：");
                                builder.setMessage("请确认准考证号与姓名是否正确！");
                                builder.setPositiveButton("好的",null).create().show();
                            }
                        }
                    },800);
                }
                break;
            case R.id.sback:
                finish();
                break;
<<<<<<< HEAD
            case R.id.clear:
                id.setText("");
                break;
=======
<<<<<<< HEAD
            case R.id.clear:
                id.setText("");
                break;
=======
<<<<<<< HEAD
            case R.id.clear:
                id.setText("");
                break;
=======
<<<<<<< HEAD
            case R.id.clear:
                id.setText("");
                break;
=======
<<<<<<< HEAD
            case R.id.clear:
                id.setText("");
                break;
=======
<<<<<<< HEAD
            case R.id.clear:
                id.setText("");
                break;
=======
>>>>>>> 9afaf5bf4b739f4a9965d1dfc1541ef4848df079
>>>>>>> 2c1a4be3a78d1876fd68ac22c2153d1970d458de
>>>>>>> f3a7b3d83889c41bd6151331b5442e4d96cdfcd2
>>>>>>> dc73a1145aa1a599cdab9b04d440f49715b04dd5
>>>>>>> e9a8a41fee9b6ad02f284ae5331fa83531f9737f
>>>>>>> 2913b9ccda47fc292b3b20269036ef5eb0c45463

        }
    }

    private void initDialog(final Dialog dialog) {
        TextView sname = (TextView) dialog.findViewById(R.id.sname);
        TextView sschool = (TextView) dialog.findViewById(R.id.sschool);
        TextView wid = (TextView) dialog.findViewById(R.id.wid);
        TextView wlisten = (TextView) dialog.findViewById(R.id.wlisten);
        TextView wread = (TextView) dialog.findViewById(R.id.wread);
        TextView wwirte = (TextView) dialog.findViewById(R.id.wwrite);
        TextView wtotal = (TextView) dialog.findViewById(R.id.wtotal);
        TextView lid = (TextView) dialog.findViewById(R.id.lid);
        TextView llevel = (TextView) dialog.findViewById(R.id.llevel);
        ImageView back = (ImageView) dialog.findViewById(R.id.sback);

        sname.setText(siliuBean.getSname());
        sschool.setText(siliuBean.getSchool());
        wid.setText(siliuBean.getSid());
        wlisten.setText(siliuBean.getWlisten());
        wread.setText(siliuBean.getWread());
        wwirte.setText(siliuBean.getWrite());
        wtotal.setText(siliuBean.getWtotal());
        lid.setText(siliuBean.getLid());
        llevel.setText(siliuBean.getLlevel());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
