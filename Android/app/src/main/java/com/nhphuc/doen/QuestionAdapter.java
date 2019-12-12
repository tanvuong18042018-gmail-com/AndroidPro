package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class QuestionAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Question> questionList;

    public QuestionAdapter(Context context, int layout, List<Question> questionList){
        this.context = context;
        this.layout = layout;
        this.questionList = questionList;
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder{
        Button btnQuestion;
        TextView txtResultQuetion, txtResultA, txtResultB, txtResultC, txtResultD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuestionAdapter.ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            viewHolder.btnQuestion     = (Button) convertView.findViewById(R.id.buttonQuestion);
            viewHolder.txtResultA      = (TextView) convertView.findViewById(R.id.textViewResultA);
            viewHolder.txtResultB      = (TextView) convertView.findViewById(R.id.textViewResultB);
            viewHolder.txtResultC      = (TextView) convertView.findViewById(R.id.textViewResultC);
            viewHolder.txtResultD      = (TextView) convertView.findViewById(R.id.textViewResultD);
            viewHolder.txtResultQuetion = (TextView) convertView.findViewById(R.id.textViewResultQuetion);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (QuestionAdapter.ViewHolder) convertView.getTag();
        }

        Question question = questionList.get(position);

        viewHolder.btnQuestion.setText(question.getCont_question());
        viewHolder.txtResultA.setText(question.getResult_a());
        viewHolder.txtResultB.setText(question.getResult_b());
        viewHolder.txtResultC.setText(question.getResult_c());
        viewHolder.txtResultD.setText(question.getResult_d());
        viewHolder.txtResultQuetion.setText(question.getResult());

        return convertView;
    }
}
