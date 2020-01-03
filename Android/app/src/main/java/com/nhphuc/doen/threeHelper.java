package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class threeHelper extends AppCompatActivity {

    TextView txtMessiResult, txtRonaldoResult, txtNeymarResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String result = intent.getStringExtra("resultThree");
        setContentView(R.layout.activity_three_helper);


        txtMessiResult      = (TextView) findViewById(R.id.textViewMessiResult);
        txtRonaldoResult    = (TextView) findViewById(R.id.textViewRonaldoResult);
        txtNeymarResult     = (TextView) findViewById(R.id.textViewNeymarResult);

        txtMessiResult.setText("Toi xin chon dap an " + result);
        txtRonaldoResult.setText("Toi xin chon dap an " + result);
        txtNeymarResult.setText("Toi xin chon dap an " + result);

    }
}
