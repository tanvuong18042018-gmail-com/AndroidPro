package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuestionActivity extends AppCompatActivity {

    Button btnBuyCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        AnhXa();

        ShowActivity();
    }

    public void AnhXa(){
        btnBuyCredit = (Button) findViewById(R.id.buttonBuyCredit);
    }

    public void ShowActivity(){
        btnBuyCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityBuyCredit();
            }
        });
    }

    public void ActivityBuyCredit(){
        Intent intent = new Intent(QuestionActivity.this, activity_credit.class);
        startActivity(intent);
    }
}
