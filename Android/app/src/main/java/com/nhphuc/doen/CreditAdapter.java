package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CreditAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Credit> creditList;

    public CreditAdapter(Context context, int layout, List<Credit> creditList) {
        this.context = context;
        this.layout = layout;
        this.creditList = creditList;
    }

    @Override
    public int getCount() {
        return creditList.size();
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
        TextView txtRuby, txtNameCredit;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CreditAdapter.ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new CreditAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            viewHolder.txtNameCredit    = (TextView) convertView.findViewById(R.id.textViewCredit);
            viewHolder.txtRuby          = (TextView) convertView.findViewById(R.id.textViewNumberRuby);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (CreditAdapter.ViewHolder) convertView.getTag();
        }

        Credit credit = creditList.get(position);
        viewHolder.txtNameCredit.setText(credit.getNameCredit());
        viewHolder.txtRuby.setText(Integer.toString(credit.getPriceCredit()));

        return convertView;
    }
}
