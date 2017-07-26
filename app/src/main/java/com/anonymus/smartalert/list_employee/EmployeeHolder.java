package com.anonymus.smartalert.list_employee;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.anonymus.smartalert.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by holicz01 on 7/26/2017 AD.
 */

public class EmployeeHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_name)
    public TextView textName;
    @BindView(R.id.text_role)
    public TextView textRole;
    public EmployeeHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
