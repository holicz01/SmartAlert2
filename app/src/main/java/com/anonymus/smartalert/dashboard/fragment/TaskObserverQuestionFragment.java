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
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskObserverQuestionFragment extends Fragment {

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


    public TaskObserverQuestionFragment() {
        // Required empty public constructor
    }

    public static TaskObserverQuestionFragment newInstance() {
        Bundle args = new Bundle();
        TaskObserverQuestionFragment fragment = new TaskObserverQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_task_question, container, false);
        ButterKnife.bind(this, rootView);

        question.add(0,"Surroundings Ground condition");
        question.add(1,"Surroundings House Keeping");
        question.add(2,"Surroundings Stop and Think Filled Out");
        question.add(3,"Surroundings Signage");
        question.add(4,"Surroundings Environmental Hazards controlled");
        question.add(5,"Surroundings Unsafe Condition Corrected");
        question.add(6,"Surroundings Familiar with the Environment");
        question.add(7,"Surroundings Access to ER Equipment");
        question.add(8,"Authorization Procedures Understood");
        question.add(9,"Authorization JSEA");
        question.add(10,"Authorization PTW");
        question.add(11,"Authorization SDS");
        question.add(12,"Forces / Energies  Isolation / Locks and Tags");
        question.add(13,"Forces / Energies Caught between / Stuck");
        question.add(14,"Forces / Energies Manual handling and Posture");
        question.add(15,"Forces / Energies  Acceleration / Breaking / Following");
        question.add(16,"Equipment Right tools / equipment for the job");
        question.add(17,"Equipment Pre-Start Inspection of Equipment");
        question.add(18,"Equipment Safe Operation / Usage of Equipment");
        question.add(19,"Equipment Equipment Maintained");
        question.add(20,"Equipment Barricade");
        question.add(21,"Equipment Machine Guarding");
        question.add(22,"Equipment Wearing Adequate PPE");
        question.add(23,"Equipment Wear Seat Belts");
        question.add(24,"Did you stop the Job");

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
