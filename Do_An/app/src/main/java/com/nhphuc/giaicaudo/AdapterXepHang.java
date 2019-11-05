package com.nhphuc.giaicaudo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterXepHang extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BangXepHang> bangXepHangList;

    public AdapterXepHang(Context context, int layout, List<BangXepHang> bangXepHangList) {
        this.context = context;
        this.layout = layout;
        this.bangXepHangList = bangXepHangList;
    }

    @Override
    public int getCount() {
        return bangXepHangList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        TextView txtSoDiem,txtTen;
        ImageView imgAvt;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtSoDiem = (TextView) view.findViewById(R.id.textViewSoDiem);
            holder.txtTen = (TextView) view.findViewById(R.id.textViewTen);
            holder.imgAvt = (ImageView) view.findViewById(R.id.imageViewAvt);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        BangXepHang bangXepHang = bangXepHangList.get(i);

        holder.txtTen.setText(bangXepHang.getTen());

        holder.txtSoDiem.setText(bangXepHang.getDiem());

        holder.imgAvt.setImageResource(bangXepHang.getHinh());

        return view;
    }
}
