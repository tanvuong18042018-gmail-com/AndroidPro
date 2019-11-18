package com.nhphuc.giaicaudo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLichSuChoi extends RecyclerView.Adapter<AdapterLichSuChoi.ViewHolder>{
    ArrayList<LichSuNguoiChoi> lichSuNguoiChoiArrayList;
    Context context;

    public AdapterLichSuChoi(ArrayList<LichSuNguoiChoi> lichSuNguoiChoiArrayList, Context context) {
        this.lichSuNguoiChoiArrayList = lichSuNguoiChoiArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.dong_lich_su_choi,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCau.setText(lichSuNguoiChoiArrayList.get(position).getSoCau());
        holder.txtDiem.setText(lichSuNguoiChoiArrayList.get(position).getSoDiem());
        holder.txtNgay.setText(lichSuNguoiChoiArrayList.get(position).getNgay());

    }

    @Override
    public int getItemCount() {
        return lichSuNguoiChoiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNgay,txtCau,txtDiem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCau = (TextView) itemView.findViewById(R.id.textViewSoCau);
            txtNgay = (TextView) itemView.findViewById(R.id.textViewNgay);
            txtDiem = (TextView) itemView.findViewById(R.id.textViewSoDiem);
        }
    }
}
