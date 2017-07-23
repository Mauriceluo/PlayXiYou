package com.example.xiyou3g.playxiyou.EduFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiyou3g.playxiyou.Adapter.TestStackAdapter;
import com.example.xiyou3g.playxiyou.HttpRequest.GetMajorData;
import com.example.xiyou3g.playxiyou.R;
import com.loopeer.cardstack.CardStackView;

import java.util.Arrays;

import static com.example.xiyou3g.playxiyou.Content.EduContent.*;

/**
 * Created by Lance on 2017/7/12.
 */

public class ProjectFragment extends Fragment implements CardStackView.ItemExpendListener{

    private CardStackView cardStackView;
    private TestStackAdapter testStackAdapter;

    private static Integer[] item = new Integer[]{R.color.team1,R.color.team2,R.color.team3,
            R.color.team4,R.color.team5,R.color.team6,R.color.team7,R.color.team8};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(majorBeanList.size() == 0 && !stuname.equals("null")){
            new Thread(new GetMajorData()).start();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project_fragment,container,false);
        initWight(view);
        return view;
    }

    private void initWight(View view) {
        cardStackView = (CardStackView) view.findViewById(R.id.stackview);
        testStackAdapter = new TestStackAdapter(getContext());
        cardStackView.setAdapter(testStackAdapter);
        cardStackView.setItemExpendListener(this);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                testStackAdapter.updateData(Arrays.asList(item));
            }
        },200);
    }

    @Override
    public void onItemExpend(boolean expend) {

    }
}
