package com.nhphuc.giaicaudo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterXepHang extends RecyclerView.Adapter<AdapterXepHang.ViewHolder>{
    ArrayList<BangXepHang> bangXepHangArrayList;
    Context context;

    public AdapterXepHang(ArrayList<BangXepHang> bangXepHangArrayList, Context context) {
        this.bangXepHangArrayList = bangXepHangArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.dong_bang_xep_hang,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgHinh.setImageResource(bangXepHangArrayList.get(position).getHinh());
        holder.txtDiem.setText(bangXepHangArrayList.get(position).getDiem());
        holder.txtTen.setText(bangXepHangArrayList.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return bangXepHangArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTen,txtDiem;
        ImageView imgHinh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTen = (TextView) itemView.findViewById(R.id.textViewTen);
            txtDiem = (TextView) itemView.findViewById(R.id.textViewSoDiem);
            imgHinh = (ImageView) itemView.findViewById(R.id.imageViewAvt);
        }
    }
}
