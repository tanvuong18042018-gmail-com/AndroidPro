package com.nhphuc.doen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

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

    private class ViewHolder{
        Button btnQuestion, btnResultA, btnResultB, btnResultC, btnResultD;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuestionAdapter.ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            viewHolder.btnQuestion     = (Button) convertView.findViewById(R.id.buttonQuestion);
            viewHolder.btnResultA      = (Button) convertView.findViewById(R.id.buttonResultA);
            viewHolder.btnResultB      = (Button) convertView.findViewById(R.id.buttonResultB);
            viewHolder.btnResultC      = (Button) convertView.findViewById(R.id.buttonResultC);
            viewHolder.btnResultD      = (Button) convertView.findViewById(R.id.buttonResultD);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (QuestionAdapter.ViewHolder) convertView.getTag();
        }

        Question question = questionList.get(position);

        viewHolder.btnQuestion.setText(question.getCont_question());
        viewHolder.btnResultA.setText(question.getResult_a());
        viewHolder.btnResultB.setText(question.getResult_b());
        viewHolder.btnResultC.setText(question.getResult_c());
        viewHolder.btnResultD.setText(question.getResult_d());

        return convertView;
    }
}
