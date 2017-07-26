package com.anonymus.smartalert.dashboard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.anonymus.smartalert.R;
import com.anonymus.smartalert.dao.EmployeeFeatureDao;
import com.google.gson.internal.bind.TreeTypeAdapter;

import java.util.List;

/**
 * Created by kamie on 26/7/2560.
 */

public class EmployeeListAdapter extends BaseAdapter {

    private Context mContext;
    private List<EmployeeFeatureDao> mEmployeeList;

    public EmployeeListAdapter(Context mContext,List<EmployeeFeatureDao> mEmployeeList)
    {
        this.mContext = mContext;
        this.mEmployeeList = mEmployeeList;
    }

    @Override
    public int getCount() {
        return  0;
    }

    @Override
    public Object getItem(int position)
    {
        return  mEmployeeList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = View.inflate(mContext, R.layout.fragment_employee,null);
        return  v;
    }

}
