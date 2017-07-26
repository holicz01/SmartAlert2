package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragment;
import com.anonymus.smartalert.utils.MainBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JSEAQuestionFragment extends Fragment {

    Button a1;
    Button a2;
    Button a4;
    TextView a3;
    int i = 0;
    int qi = 1;
    int max ;
    @BindView(R.id.text_question)
    TextView textQuestion;
    final List<String> question = new ArrayList<>();



    public JSEAQuestionFragment() {
        // Required empty public constructor
    }

    public static JSEAQuestionFragment newInstance() {
        Bundle args = new Bundle();
        JSEAQuestionFragment fragment = new JSEAQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jsea_question, container, false);
        ButterKnife.bind(this, rootView);

        question.add(0,"Do I clearly understand the requirement of the TASK? ");
        question.add(1,"Am I competent to undertake the TASK? (Trained, Authorized, Fit for Work) ");
        question.add(2,"Does PPE meet the requirements of the TASK? ");
        question.add(3,"Is this a simple task commonly undertaken? ");
        question.add(4,"Are my Tools and Equipment in a SAFE Working Condition?");

        textQuestion.setText(question.get(i));

        max = question.size();

        a3 = (TextView) rootView.findViewById(R.id.a3);
        a3.setText("" + qi + " / " + max);
        a1 = (Button) rootView.findViewById(R.id.a1);
        a4 = (Button) rootView.findViewById(R.id.a4);


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i <= max){
                    i++;
                    qi++;
                    if (i == max){
                        textQuestion.setText(question.get(i-1));
                    }else{
                        textQuestion.setText(question.get(i));

                    }
                }
                a3.setText("" + qi + " / " + max);
                if (qi == max) {
                    a1.setEnabled(false);
                    a4.setVisibility(View.VISIBLE);
                }
            }
        });

        a2 = (Button) rootView.findViewById(R.id.a2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != 0){
                    i--;
                    qi--;
                    textQuestion.setText(question.get(i));
                    a3.setText("" + qi + " / " + max);
                }
                if (i >= 1) {
                    a1.setEnabled(true);
                    a4.setVisibility(View.GONE);
                    a3.setText("" + qi + " / " + max);

                }

            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragment(DashboardFragment.newInstance()));
            }
        });
        return rootView;
    }

    private void initInstances() {

    }
}
