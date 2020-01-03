package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class dinalogNguoiThan extends AppCompatActivity {
    TextView txtTitle, txtResult;
    ImageView imgRoaldo, imgMessi, imgNeymar, imgMessi2, imgNeymar2;

    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinalog_nguoi_than);

        AnhXa();

        Intent intent = getIntent();
        result = intent.getStringExtra("result");
    }

    private void AnhXa() {
        imgMessi            = (ImageView) findViewById(R.id.imageViewMessi);
        imgRoaldo           = (ImageView) findViewById(R.id.imageViewronaldo);
        imgNeymar           = (ImageView) findViewById(R.id.imageViewNeymar);
        imgMessi2           = (ImageView) findViewById(R.id.imageViewMessi2);
        imgNeymar2          = (ImageView) findViewById(R.id.imageViewNeymar2);

        txtTitle            = (TextView)  findViewById(R.id.textViewTitleTroGiup);
        txtResult           = (TextView)  findViewById(R.id.textViewResult);
    }

    public void messi(View view) {
        imgRoaldo.setVisibility(View.INVISIBLE);
        imgNeymar.setVisibility(View.INVISIBLE);
        imgMessi.setVisibility(View.INVISIBLE);
        imgNeymar2.setVisibility(View.INVISIBLE);
        imgMessi2.setVisibility(View.VISIBLE);

        txtTitle.setText("Vì tôi là Messi nên tôi sẽ trả lời là...");
        txtResult.setText("" + result);
    }

    public void neymar(View view) {
        imgRoaldo.setVisibility(View.INVISIBLE);
        imgNeymar.setVisibility(View.INVISIBLE);
        imgMessi.setVisibility(View.INVISIBLE);
        imgNeymar2.setVisibility(View.VISIBLE);
        imgMessi2.setVisibility(View.INVISIBLE);

        txtTitle.setText("Một cầu thủ đẳng cấp nên tôi sẽ chọn...");
        txtResult.setText("" + result);
    }

    public void ronaldo(View view) {
        imgRoaldo.setVisibility(View.VISIBLE);
        imgNeymar.setVisibility(View.INVISIBLE);
        imgMessi.setVisibility(View.INVISIBLE);
        imgNeymar2.setVisibility(View.INVISIBLE);
        imgMessi2.setVisibility(View.INVISIBLE);

        txtTitle.setText("Vì là CR7 huyền thoại nên tôi sẽ trả lời là...");
        txtResult.setText("" + result);
    }
}
