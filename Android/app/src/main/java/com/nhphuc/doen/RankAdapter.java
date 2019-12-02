package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {

    ArrayList<Rank> rankArrayList;
    Context context;

    public RankAdapter(ArrayList<Rank> rankArrayList, Context context) {
        this.rankArrayList = rankArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.row_rank, parent, false);
        return new RankAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNumberOrderRank.setText(rankArrayList.get(position).getNumberOrderRank());
        holder.txtNamePlayerRank.setText(rankArrayList.get(position).getNameRank());
        holder.txtScorePlayerRank.setText(rankArrayList.get(position).getScoreRank());
        holder.imgPlayerRank.setImageResource(rankArrayList.get(position).getImageRank());
    }

    @Override
    public int getItemCount() {
        return rankArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtNumberOrderRank, txtNamePlayerRank, txtScorePlayerRank;
        ImageView imgPlayerRank;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNumberOrderRank = (TextView) itemView.findViewById(R.id.textViewNumberRank);
            txtNamePlayerRank = (TextView) itemView.findViewById(R.id.textViewNamePlayerRank);
            txtScorePlayerRank = (TextView) itemView.findViewById(R.id.textViewScorePlayerRank);
            imgPlayerRank = (ImageView) itemView.findViewById(R.id.imageViewAvatarPlayerRank);
        }
    }
}
