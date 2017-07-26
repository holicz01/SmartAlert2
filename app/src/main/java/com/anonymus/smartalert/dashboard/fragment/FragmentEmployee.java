package com.anonymus.smartalert.dashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dao.EmployeeDao;
import com.anonymus.smartalert.dao.EmployeeFeatureDao;
import com.anonymus.smartalert.dao.EmployeeFeatureProperties;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.list_employee.EmployeeAdapter;
import com.anonymus.smartalert.network.HttpManager;
import com.anonymus.smartalert.utils.MainBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentEmployee extends Fragment {

    @BindView(R.id.list_employee)
    RecyclerView listEmployee;

    @BindView(R.id.edt_search)
    EditText edt_search;

    EmployeeAdapter adapter;
    List<String> nameList;
    List<String> roleList;
    List<String> searchName= new ArrayList<>();
    List<String> searchRole= new ArrayList<>();
    EmployeeDao data;

    public FragmentEmployee() {
        // Required empty public constructor
    }

    public static FragmentEmployee newInstance() {
        Bundle args = new Bundle();
        FragmentEmployee fragment = new FragmentEmployee();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_employee, container, false);
        ButterKnife.bind(this, rootView);
        initInstances();
        return rootView;
    }

    private void initInstances() {
        edt_search.setEnabled(false);
        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toUpperCase();
                for (int i = 0 ; i < nameList.size() ; i++){
                    String name = nameList.get(i).toUpperCase();
                    if(name.contains(query)){
                        searchName.add(name);
                        searchRole.add(roleList.get(i));
                    }
                }

                adapter.setRole(searchRole);
                adapter.setNameList(searchName);
                adapter.notifyDataSetChanged();

                if (count == 0){
                    adapter.setNameList(createEmployeeNameList(data.getFeature()));
                    adapter.setRole(createEmployeeRoleList(data.getFeature()));
                    adapter.setEmployeeFeatureProperties(data.getFeature());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        adapter = new EmployeeAdapter();
        listEmployee.setLayoutManager(new LinearLayoutManager(getContext()));
        listEmployee.setAdapter(adapter);


        Call<EmployeeDao> call = HttpManager.getInstance().getService().getData();
        call.enqueue(new Callback<EmployeeDao>() {
            @Override
            public void onResponse(Call<EmployeeDao> call, Response<EmployeeDao> response) {
                if (response.isSuccessful()) {
                     data = response.body();
                    adapter.setNameList(createEmployeeNameList(data.getFeature()));
                    adapter.setRole(createEmployeeRoleList(data.getFeature()));
                    adapter.setEmployeeFeatureProperties(data.getFeature());
                    adapter.notifyDataSetChanged();
                    edt_search.setEnabled(true);
                }
            }

            @Override
            public void onFailure(Call<EmployeeDao> call, Throwable t) {
                Log.d("exid", "fail");
            }
        });
    }

    private List<String> createEmployeeNameList(List<EmployeeFeatureDao> employeeList) {
         nameList = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeFeatureDao().getFirstName() != null)
                nameList.add(i, employeeList.get(i).getEmployeeFeatureDao().getFirstName());
            else
                nameList.add(i, "-");

        }
        return nameList;
    }

    private List<String> createEmployeeRoleList(List<EmployeeFeatureDao> employeeList) {
         roleList = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeFeatureDao().getPostion() != null)
                roleList.add(i, employeeList.get(i).getEmployeeFeatureDao().getPostion());
            else
                roleList.add(i, "-");
        }
        return roleList;
    }

}