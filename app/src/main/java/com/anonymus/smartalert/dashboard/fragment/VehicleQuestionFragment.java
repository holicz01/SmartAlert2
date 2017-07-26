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

public class VehicleQuestionFragment extends Fragment {

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



    public VehicleQuestionFragment() {
        // Required empty public constructor
    }

    public static VehicleQuestionFragment newInstance() {
        Bundle args = new Bundle();
        VehicleQuestionFragment fragment = new VehicleQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vehical_question, container, false);
        ButterKnife.bind(this, rootView);

        question.add(0,"Two-Way Radio");
        question.add(1,"Fuel Level");
        question.add(2,"Engine Oil Level");
        question.add(3,"Coolant Level");
        question.add(4,"Clutch Fluid Level");
        question.add(5,"Power Steering Oil Level");
        question.add(6,"Brake Fluid Level");
        question.add(7,"Reflective Flag / Flashing Light");
        question.add(8,"First Aid Kit");
        question.add(9,"Jack Wheel Brace");
        question.add(10,"Indicators / Brakelights");
        question.add(11,"Wheel Nuts");
        question.add(12,"Wheel Rims");
        question.add(13,"Flashlight / Torch");
        question.add(14,"Tyres (Condition and Uniform)");
        question.add(15,"Front Left");
        question.add(16,"Rear left");
        question.add(17,"Front Right");
        question.add(18,"Rear Right");
        question.add(19,"Visibility (Windows)");
        question.add(20,"Rear View Mirrors");
        question.add(21,"Switches and Gauges");
        question.add(22,"Window Washer Operation / Fluid / Blades");
        question.add(23,"Cargo Barrier Secure");
        question.add(24,"Foot Pedal Rubbers");
        question.add(25,"Horn");
        question.add(26,"Fire Extinguisher");
        question.add(27,"Vehicle Washed");
        question.add(28,"Body Damaged (If evident – Provide Details)");
        question.add(29,"General Condition of Vehicle");
        question.add(30,"*Critical* Foot Brake");
        question.add(31,"*Critical* Park Brake");
        question.add(32,"*Critical* All Seat Belts");
        question.add(33,"*Critical* Spare Tyre Inflated");
        question.add(34,"*Critical* Headlight / Spotlight / Fog Lamp");

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
