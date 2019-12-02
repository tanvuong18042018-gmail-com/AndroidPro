package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    ArrayList<History> historyArrayList;
    Context context;

    public HistoryAdapter(ArrayList<History> historyArrayList, Context context) {
        this.historyArrayList = historyArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.row_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNumberOrder.setText(historyArrayList.get(position).getNumberOrder());
        holder.txtScore.setText(historyArrayList.get(position).getScore());
        holder.txtDay.setText(historyArrayList.get(position).getDay());
    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNumberOrder, txtDay, txtScore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumberOrder = (TextView) itemView.findViewById(R.id.textViewNumberOrder);
            txtScore = (TextView) itemView.findViewById(R.id.textViewScore);
            txtDay = (TextView) itemView.findViewById(R.id.textViewDay);
        }
    }
}
