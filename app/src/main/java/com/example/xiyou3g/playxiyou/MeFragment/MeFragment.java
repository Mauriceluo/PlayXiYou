package com.example.xiyou3g.playxiyou.MeFragment;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiyou3g.playxiyou.Activity.LoginActivity;
import com.example.xiyou3g.playxiyou.Activity.MainActivity;
import com.example.xiyou3g.playxiyou.Activity.PersInfoActivity;
import com.example.xiyou3g.playxiyou.Activity.SiliuActivity;
import com.example.xiyou3g.playxiyou.EduFragment.EduFragment;
import com.example.xiyou3g.playxiyou.R;

import org.w3c.dom.Text;

import static com.example.xiyou3g.playxiyou.Content.EduContent.*;

/**
 * Created by Lance on 2017/7/14.
 */

public class MeFragment extends Fragment implements View.OnClickListener{

    private View view;
    private TextView stuName;
    private TextView stuNum;

    private TextView stuinfo;
//    private TextView siliu;
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
//        siliu = (TextView) view.findViewById(R.id.siliu);
        help = (TextView) view.findViewById(R.id.help);
        question = (TextView) view.findViewById(R.id.question);
        about = (TextView) view.findViewById(R.id.about);
        exit = (TextView) view.findViewById(R.id.exit);

        stuName.setText(stuname);
        stuNum.setText(stuclass);

        stuinfo.setOnClickListener(this);
//        siliu.setOnClickListener(this);
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
//            case R.id.siliu:
//                Intent intent1 = new Intent(getContext(), SiliuActivity.class);
//                startActivity(intent1,ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
//                break;
            case R.id.help:
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
                builder.setPositiveButton("是--的", new DialogInterface.OnClickListener() {
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
