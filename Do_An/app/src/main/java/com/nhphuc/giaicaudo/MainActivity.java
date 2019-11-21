package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imgLogo;
    Button btnDangKy,btnDangNhap;
    TextView txtQuenMatKhau;
    EditText edtTenDangNhap,edtMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        ShowPopup();

        DangNhap();

        Logo();
    }


    public void AnhXa(){
        edtMatKhau = (EditText) findViewById(R.id.editTextMatKhau);
        edtTenDangNhap = (EditText) findViewById(R.id.editTextTenDangNhap);
        imgLogo = (ImageView) findViewById(R.id.imageViewLogo);
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
        dialogPopupQuenMatKhau.setContentView(R.layout.popup_quen_mat_khau);
        dialogPopupQuenMatKhau.show();
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
                if(edtTenDangNhap.getText().toString().equals("nhphuc") && edtMatKhau.getText().toString().equals("123")){
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                }
                else if(TextUtils.isEmpty(edtTenDangNhap.getText().toString()) ||TextUtils.isEmpty(edtMatKhau.getText().toString())){
                    Toast.makeText(MainActivity.this, "Tên đăng nhập và mật khẩu không được để trống", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Tên đăng nhập và mật khẩu sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Logo(){
        Animation animLogo = AnimationUtils.loadAnimation(this,R.anim.anim_logo);

        imgLogo.startAnimation(animLogo);

    }
}
