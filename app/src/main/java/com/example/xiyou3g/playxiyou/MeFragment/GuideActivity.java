package com.example.xiyou3g.playxiyou.MeFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
import android.widget.ImageView;
=======
>>>>>>> cc9c9212212d6bce897d33a34ea97072735ea660

import com.example.xiyou3g.playxiyou.Adapter.GuideAdapter;
import com.example.xiyou3g.playxiyou.Content.MeContent;
import com.example.xiyou3g.playxiyou.DataBean.GuideBean;
import com.example.xiyou3g.playxiyou.R;

import java.util.ArrayList;
import java.util.List;
import static com.example.xiyou3g.playxiyou.Content.MeContent.*;

/**
 * Created by Lance on 2017/8/2.
 */

public class GuideActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView guideRecyc;
    private EditText guideContent;
    private Button guideSend;
<<<<<<< HEAD
    private ImageView back;
=======
>>>>>>> cc9c9212212d6bce897d33a34ea97072735ea660

    private List<GuideBean> guideBeanList = new ArrayList<>();
    private GuideAdapter guideAdapter;

    private Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    initWight();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);
        guideBeanList.clear();
        GuideBean guideBean = new GuideBean();
        guideBean.setGuideMsg("Hello,我是西邮小猿！\n在这儿我可以帮你查询东区教室的分布情况喔~~");
        guideBean.setType(RECIVE_TYPE);
        guideBeanList.add(guideBean);
        initWight();
    }

    private void initWight() {
        guideRecyc = (RecyclerView) findViewById(R.id.guiderecycler);
        guideContent = (EditText) findViewById(R.id.guidecontent);
        guideSend = (Button) findViewById(R.id.guidesend);
<<<<<<< HEAD
        back = (ImageView) findViewById(R.id.back);
=======
>>>>>>> cc9c9212212d6bce897d33a34ea97072735ea660

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        guideRecyc.setLayoutManager(linearLayoutManager);
        guideAdapter = new GuideAdapter(guideBeanList);
        guideRecyc.setAdapter(guideAdapter);

<<<<<<< HEAD
        back.setOnClickListener(this);
=======
>>>>>>> cc9c9212212d6bce897d33a34ea97072735ea660
        guideSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guidesend:
                String send = guideContent.getText().toString();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> cc9c9212212d6bce897d33a34ea97072735ea660
                if(!send.equals("")){
                    GuideBean guideBean = new GuideBean();
                    guideBean.setGuideMsg(send);
                    guideBean.setType(SEND_TYPE);
                    guideBeanList.add(guideBean);
                    GuideBean guideBean1 = new GuideBean();
                    guideBean1.setGuideMsg(XiyouGuide.getResult(send));
                    guideBean1.setType(RECIVE_TYPE);
                    guideBeanList.add(guideBean1);
//                Message message = new Message();
//                message.what = 1;
//                mhandler.sendMessage(message);
                    guideAdapter.notifyItemInserted(guideBeanList.size()-1);
                    guideRecyc.scrollToPosition(guideBeanList.size()-1);
                    guideContent.setText("");
<<<<<<< HEAD
                }
                break;
            case R.id.back:
                finish();
=======

                }
=======
                GuideBean guideBean = new GuideBean();
                guideBean.setGuideMsg(send);
                guideBean.setType(SEND_TYPE);
                guideBeanList.add(guideBean);
                GuideBean guideBean1 = new GuideBean();
                guideBean1.setGuideMsg(XiyouGuide.getResult(send));
                guideBean1.setType(RECIVE_TYPE);
                guideBeanList.add(guideBean1);
//                Message message = new Message();
//                message.what = 1;
//                mhandler.sendMessage(message);
                guideAdapter = new GuideAdapter(guideBeanList);
                guideRecyc.setAdapter(guideAdapter);
                guideContent.setText("");
>>>>>>> 2913b9ccda47fc292b3b20269036ef5eb0c45463
>>>>>>> cc9c9212212d6bce897d33a34ea97072735ea660
                break;
        }
    }
}
