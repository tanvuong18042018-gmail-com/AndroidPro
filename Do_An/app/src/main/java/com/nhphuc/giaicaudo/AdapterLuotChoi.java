package com.nhphuc.giaicaudo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class AdapterLuotChoi extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnhLuotChoi> hinhAnhLuotChoiList;

    public AdapterLuotChoi(Context context, int layout, List<HinhAnhLuotChoi> hinhAnhLuotChoiList) {
        this.context = context;
        this.layout = layout;
        this.hinhAnhLuotChoiList = hinhAnhLuotChoiList;
    }

    @Override
    public int getCount() {
        return hinhAnhLuotChoiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgLuotChoi;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.imgLuotChoi = (ImageView) view.findViewById(R.id.imageViewLuotChoi);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        HinhAnhLuotChoi hinhAnhLuotChoi = hinhAnhLuotChoiList.get(i);

        holder.imgLuotChoi.setImageResource(hinhAnhLuotChoi.getHinh());

        return view;
    }
}
