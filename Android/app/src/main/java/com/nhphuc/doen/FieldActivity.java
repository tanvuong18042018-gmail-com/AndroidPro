package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FieldActivity extends AppCompatActivity {

    Button btnHistoryField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        Anhxa();

        ShowActivity();
    }

    private void Anhxa() {
        btnHistoryField = (Button) findViewById(R.id.buttonHistoryField);
    }

    private void ShowActivity(){
        btnHistoryField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityFieldHistory();
            }
        });
    }

    private void ActivityFieldHistory(){
        Intent intent = new Intent(FieldActivity.this, QuestionActivity.class);
        startActivity(intent);
    }

}
