package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {

    Button btnBuyCredit, btnAudience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        AnhXa();

        ShowActivity();
    }

    public void AnhXa(){
        btnBuyCredit = (Button) findViewById(R.id.buttonBuyCredit);
        btnAudience = (Button) findViewById(R.id.buttonAudience);
    }

    public void ShowActivity(){
        btnBuyCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityBuyCredit();
            }
        });

        btnAudience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupAudience();
            }
        });
    }

    public void ActivityBuyCredit(){
        Intent intent = new Intent(QuestionActivity.this, activity_credit.class);
        startActivity(intent);
    }

    public void PopupAudience(){
        final Dialog dialogPopupConsultAudience = new Dialog(QuestionActivity.this);
        dialogPopupConsultAudience.setContentView(R.layout.activity_popup_consult_audience);
        dialogPopupConsultAudience.show();
    }
}
