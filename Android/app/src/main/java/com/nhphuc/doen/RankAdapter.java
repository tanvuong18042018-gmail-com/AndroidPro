package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RankAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Rank> rankList;

    public RankAdapter(Context context, int layout, List<Rank> rankList) {
        this.context = context;
        this.layout = layout;
        this.rankList = rankList;
    }

    @Override
    public int getCount() {
        return rankList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName, txtScore, txtNumberRank;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RankAdapter.ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            viewHolder.txtName          = (TextView) convertView.findViewById(R.id.textViewNamePlayerRank);
            viewHolder.txtScore         = (TextView) convertView.findViewById(R.id.textViewScorePlayerRank);
            viewHolder.txtNumberRank    = (TextView) convertView.findViewById(R.id.textViewNumberRank);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Rank rank = rankList.get(position);
        int number = 1 + position;
        viewHolder.txtNumberRank.setText("" + number);
        viewHolder.txtName.setText(rank.getName_login());
        viewHolder.txtScore.setText("" + rank.getMax_score());

        return convertView;
    }
}
