package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_credit extends AppCompatActivity {

    ImageView imgCredit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        AnhXa();

        Show();
    }

    private void Show() {
        imgCredit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuyedCredit1();
            }
        });
    }

    private void AnhXa() {
        imgCredit1 = (ImageView) findViewById(R.id.imageViewCredit1);
    }

    public void BuyedCredit1(){
        Toast.makeText(this, "Da mua thanh cong con cat", Toast.LENGTH_SHORT).show();
    }
}
