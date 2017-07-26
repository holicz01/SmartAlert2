package com.anonymus.smartalert.dashboard.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.event.EventToolbarColor;
import com.anonymus.smartalert.utils.MainBus;

public class InductionCardSelectFragment extends Fragment {

    Button b1;
    String color;
    int image;
    String zone;
    String area;

    public InductionCardSelectFragment() {
        // Required empty public constructor
    }

    public static InductionCardSelectFragment newInstance(String color,int image,String zone,String area) {
        Bundle args = new Bundle();
        InductionCardSelectFragment fragment = new InductionCardSelectFragment();
        args.putString("color",color);
        args.putInt("image",image);
        args.putString("zone",zone);
        args.putString("area",area);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.color = getArguments().getString("color");
        this.image = getArguments().getInt("image");
        this.zone = getArguments().getString("zone");
        this.area = getArguments().getString("area");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_introduction_card_selected, container, false);

        TextView t1 = (TextView) rootView.findViewById(R.id.text1);
        TextView t2 = (TextView) rootView.findViewById(R.id.text2);
        TextView t3 = (TextView) rootView.findViewById(R.id.text3);
        TextView t4 = (TextView) rootView.findViewById(R.id.text4);
        TextView cIssueddate = (TextView) rootView.findViewById(R.id.issueddate);
        TextView tzone = (TextView) rootView.findViewById(R.id.zone);
        TextView tarea = (TextView) rootView.findViewById(R.id.area);

        t1.setTextColor(Color.parseColor(color));
        t2.setTextColor(Color.parseColor(color));
        t3.setTextColor(Color.parseColor(color));
        t4.setTextColor(Color.parseColor(color));
        cIssueddate.setTextColor(Color.parseColor(color));

        tzone.setText(zone);
        tarea.setText(area);

        LinearLayout a1 = (LinearLayout) rootView.findViewById(R.id.a1);
        ImageView imageLogo = (ImageView) rootView.findViewById(R.id.image);

         a1.setBackgroundColor(Color.parseColor(color));
          imageLogo.setBackgroundResource(image);

        MainBus.getInstance().getBus().post(new EventToolbarColor(color));
//
//         b1 = (Button) rootView.findViewById(R.id.b1);
//        if (image == R.drawable.icon_green){
//            b1.setVisibility(View.GONE);
//        }
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(InductionTermFragment.newInstance()));
//            }
//        });

        return rootView;
    }

    private void initInstances() {

    }

    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Induction Card"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Induction Card"));
        MainBus.getInstance().getBus().post(new EventToolbarColor("#EB1C24"));

    }
}
