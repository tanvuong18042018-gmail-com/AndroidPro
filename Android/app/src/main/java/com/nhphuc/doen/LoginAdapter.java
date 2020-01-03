package com.nhphuc.doen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class LoginAdapter extends BaseAdapter {

    private List<Login> loginList;

    public LoginAdapter(List<Login> loginList) {
        this.loginList = loginList;
    }

    @Override
    public int getCount() {
        return loginList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
