package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

public class JSEACheckFragment extends Fragment {


    public JSEACheckFragment() {
        // Required empty public constructor
    }

    public static JSEACheckFragment newInstance() {
        Bundle args = new Bundle();
        JSEACheckFragment fragment = new JSEACheckFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_jsea, container, false);
        Button btn_start = (Button) rootView.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(JSEAQuestionFragment.newInstance()));
            }
        });
        return rootView;
    }

    private void initInstances() {

    }
}
