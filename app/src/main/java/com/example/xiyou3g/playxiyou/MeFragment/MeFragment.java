package com.example.xiyou3g.playxiyou.MeFragment;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xiyou3g.playxiyou.Activity.LoginActivity;
import com.example.xiyou3g.playxiyou.Activity.MainActivity;
import com.example.xiyou3g.playxiyou.Activity.PersInfoActivity;
import com.example.xiyou3g.playxiyou.Activity.SiliuActivity;
import com.example.xiyou3g.playxiyou.Adapter.HelpAdapter;
import com.example.xiyou3g.playxiyou.EduFragment.EduFragment;
import com.example.xiyou3g.playxiyou.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.xiyou3g.playxiyou.Content.EduContent.*;

/**
 * Created by Lance on 2017/7/14.
 */

public class MeFragment extends Fragment implements View.OnClickListener{

    private View view;
    private TextView stuName;
    private TextView stuNum;

    private TextView stuinfo;
    private TextView siliu;
    private TextView help;
    private TextView question;
    private TextView about;
    private TextView exit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.me_fragment,container,false);
        initWight(view);
        return view;
    }

    private void initWight(View view) {
        stuName = (TextView) view.findViewById(R.id.stuname);
        stuNum = (TextView) view.findViewById(R.id.stunum);
        stuinfo = (TextView) view.findViewById(R.id.stuinfo);
        siliu = (TextView) view.findViewById(R.id.siliu);
        help = (TextView) view.findViewById(R.id.help);
        question = (TextView) view.findViewById(R.id.question);
        about = (TextView) view.findViewById(R.id.about);
        exit = (TextView) view.findViewById(R.id.exit);

        stuName.setText(stuname);
        stuNum.setText(stuclass);

        stuinfo.setOnClickListener(this);
        siliu.setOnClickListener(this);
        help.setOnClickListener(this);
        question.setOnClickListener(this);
        about.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.stuinfo:
                Intent intent = new Intent(getContext(), PersInfoActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                break;
            case R.id.siliu:
                Intent intent1 = new Intent(getContext(), SiliuActivity.class);
                startActivity(intent1,ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                break;
            case R.id.help:
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
                View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.help_dialog,null);
                RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.help_recyc);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                List<String> helpList = new ArrayList<>();
                String[] array = new String[]{"APP名称：西邮游"
                        ,"适用范围：西邮童鞋们"
                        ,"主要功能：\n教务处查询（课表查询、成绩查询、培养计划查询、所得学分查询）、邮电大学体育部登录、智慧教室门户（功能还没开发完全，小猿正在努力开发）"
                        ,"其它功能：\n个人信息，四六级成绩查询，更多功能待开发中，敬请期待~"
                        ,"APP诞生地：\n西邮移动应用开发实验室（3G实验室）"
                        ,"教务处官网：\nhttp://222.24.62.120/"
                        ,"体育部官网：\nhttp://yddx.boxkj.com/admin/login"
                        ,"智慧教室官网：\nhttp://jwkq.xupt.edu.cn:8080/"
                        ,"四六级查询（99宿舍）：\nhttp://cet.99sushe.com/"};
                for(int i =0;i<array.length;i++){
                    helpList.add(array[i]);
                }
                HelpAdapter helpAdapter = new HelpAdapter(helpList);
                recyclerView.setAdapter(helpAdapter);
                bottomSheetDialog.setContentView(dialogView);
                bottomSheetDialog.show();
                break;
            case R.id.question:
                break;
            case R.id.about:
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.about);
                dialog.create();
                dialog.show();
                break;
            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("温馨提示：");
                builder.setMessage("是否确认切换账号？");
                builder.setPositiveButton("是的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent1 = new Intent(getContext(),LoginActivity.class);
                        startActivity(intent1);
                        getActivity().finish();
                    }
                });
                builder.setNegativeButton("再想想",null).create().show();
                break;
        }
    }

}
