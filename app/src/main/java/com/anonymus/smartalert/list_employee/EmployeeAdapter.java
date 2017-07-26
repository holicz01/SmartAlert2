package com.anonymus.smartalert.list_employee;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dao.EmployeeFeatureDao;
import com.anonymus.smartalert.dao.EmployeeFeatureProperties;
import com.anonymus.smartalert.dashboard.fragment.Efragment;
import com.anonymus.smartalert.event.EventChangeFragmentBackStack;
import com.anonymus.smartalert.utils.MainBus;

import org.parceler.Parcels;

import java.util.List;

/**
 * Created by holicz01 on 7/26/2017 AD.
 */

public class EmployeeAdapter extends RecyclerView.Adapter {
    List<String> nameList;
    List<String> role;
    List<EmployeeFeatureDao>  employeeFeatureProperties;

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_employee, parent,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        EmployeeHolder view = (EmployeeHolder) holder;
        view.textName.setText(nameList.get(position));
        view.textRole.setText(role.get(position));
        view.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainBus.getInstance().getBus().post(new EventChangeFragmentBackStack(Efragment.newInstance(Parcels.wrap(employeeFeatureProperties.get(position).getEmployeeFeatureDao()))));
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList != null ? nameList.size() : 0;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public void setEmployeeFeatureProperties(List<EmployeeFeatureDao> employeeFeatureProperties) {
        this.employeeFeatureProperties = employeeFeatureProperties;
    }
}
