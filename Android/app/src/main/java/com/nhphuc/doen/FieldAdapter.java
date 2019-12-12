package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class FieldAdapter  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Field> fieldList;

    public FieldAdapter(Context context, int layout, List<Field> fieldList) {
        this.context = context;
        this.layout = layout;
        this.fieldList = fieldList;
    }

    @Override
    public int getCount() {
        return fieldList.size();
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
        TextView txtField;
        //Button btnFieldOne;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            viewHolder.txtField      = (TextView) convertView.findViewById(R.id.textViewFiled);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Field field = fieldList.get(position);
        viewHolder.txtField.setText(field.getField_name());
        viewHolder.txtField.setId(field.getField_id());

        return convertView;
    }
}
