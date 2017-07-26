package com.anonymus.smartalert.dashboard.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.event.EventChangeTitleToolbar;
import com.anonymus.smartalert.utils.MainBus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class HRFragment extends Fragment {


    public HRFragment() {
        // Required empty public constructor
    }

    public static HRFragment newInstance() {
        Bundle args = new Bundle();
        HRFragment fragment = new HRFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hr, container, false);
        LinearLayout a1;

        a1 = (LinearLayout) rootView.findViewById(R.id.a1);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(HRSelectFragment.newInstance()));
            }
        });


        return rootView;
    }

    private void initInstances() {
    }


    @Override
    public void onResume() {
        super.onResume();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Handbooks"));
    }

    @Override
    public void onPause() {
        super.onPause();
        MainBus.getInstance().getBus().post(new EventChangeTitleToolbar("Handbooks"));
    }

    public static void openFile(Context context) throws IOException {
            String url = "Handbook.doc";
            Uri uri = Uri.parse("file:///android_asset/Handbook.doc");

            Intent intent = new Intent(Intent.ACTION_VIEW);

            if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
                // Word document
                intent.setDataAndType(uri, "application/msword");
            }
            // check size
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
}
