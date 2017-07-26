package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.network.HttpManager;
import com.anonymus.smartalert.utils.MainBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dfragment extends Fragment {


    public Dfragment() {
        // Required empty public constructor
    }

    public static Dfragment newInstance() {
        Bundle args = new Bundle();
        Dfragment fragment = new Dfragment();
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.asd, container, false);
        initInstances();
        return rootView;
    }

    private void initInstances() {
        Call call = HttpManager.getInstance().getService().getData();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Toast.makeText(getContext(),"200",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
        List<String> question = new ArrayList<>();
        question.add("Fuel Level");
        question.add("Engine Oil Level");
        question.add("Coolant Level");
        question.add("Clutch Fluid Level");
        question.add("Power Steering Oil Level");
        question.add("Brake Fluid Level");
        question.add("Reflective Flag / Flashing Light");
        question.add("First Aid Kit");
        question.add("Jack Wheel Brace");
        question.add("Indicators / Brakelights");
        question.add("Wheel Nuts");
        question.add("Wheel Rims");
        question.add("Flashlight / Torch");
        question.add("Tyres (Condition and Uniform)");
        question.add("Front Left");
        question.add("Rear left");
        question.add("Front Right");
        question.add("Rear Right");
        question.add("Visibility (Windows)");
        question.add("Window Washer Operation / Fluid / Blades");
        question.add("Cargo Barrier Secure");
        question.add("Foot Pedal Rubbers");
        question.add("Horn");
        question.add("Fire Extinguisher");
        question.add("Vehicle Washed");
        question.add("Body Damaged (If evident – Provide Details)");
        question.add("General Condition of Vehicle");
        question.add("*Critical* Foot Brake");
        question.add("*Critical* Park Brake");
        question.add("*Critical* All Seat Belts");
        question.add("*Critical* Spare Tyre Inflated");
        question.add("*Critical* Headlight / Spotlight / Fog Lamp");
    }
}
