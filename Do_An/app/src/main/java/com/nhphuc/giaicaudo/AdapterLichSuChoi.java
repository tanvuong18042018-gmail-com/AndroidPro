package com.nhphuc.giaicaudo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterLichSuChoi extends BaseAdapter {
    private Context context;
    private int layout;
    private List<LichSuNguoiChoi> lichSuNguoiChoiList;

    public AdapterLichSuChoi(Context context, int layout, List<LichSuNguoiChoi> lichSuNguoiChoiList) {
        this.context = context;
        this.layout = layout;
        this.lichSuNguoiChoiList = lichSuNguoiChoiList;
    }

    @Override
    public int getCount() {
        return lichSuNguoiChoiList.size();
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
        TextView txtNgay,txtDiem,txtCau;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtNgay = (TextView) view.findViewById(R.id.textViewNgay);
            holder.txtCau = (TextView) view.findViewById(R.id.textViewSoCau);
            holder.txtDiem = (TextView) view.findViewById(R.id.textViewSoDiem);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        LichSuNguoiChoi lichSuNguoiChoi = lichSuNguoiChoiList.get(i);

        holder.txtNgay.setText(lichSuNguoiChoi.getNgay());

        holder.txtDiem.setText(lichSuNguoiChoi.getSoDiem());

        holder.txtCau.setText(lichSuNguoiChoi.getSoCau());


        return view;
    }
}
