package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnDangKy,btnDangNhap;
    TextView txtQuenMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        ShowPopup();

        DangNhap();
    }


    public void AnhXa(){
        btnDangNhap = (Button) findViewById(R.id.buttonDangNhap);
        btnDangKy = (Button) findViewById(R.id.buttonDangKy);
        txtQuenMatKhau = (TextView) findViewById(R.id.textViewQuenMatKhau);
    }

    public void ShowPopup(){
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopupDangKy();
            }
        });

        txtQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopupQuenMatKhau();
            }
        });
    }

    public void ShowPopupQuenMatKhau(){
        final Dialog dialogPopupQuenMatKhau = new Dialog(this);
        Button btnClose;
        dialogPopupQuenMatKhau.setContentView(R.layout.popup_quen_mat_khau);
        btnClose = (Button) dialogPopupQuenMatKhau.findViewById(R.id.buttonClose);
        dialogPopupQuenMatKhau.show();
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPopupQuenMatKhau.dismiss();
            }
        });
    }

    public void ShowPopupDangKy(){
        final Dialog dialogPopupDangKy = new Dialog(this);
        Button btnDong;
        dialogPopupDangKy.setContentView(R.layout.popup_dang_ky);
        btnDong = (Button) dialogPopupDangKy.findViewById(R.id.buttonDong);
        dialogPopupDangKy.show();
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPopupDangKy.dismiss();
            }
        });
    }

    public void DangNhap(){
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
