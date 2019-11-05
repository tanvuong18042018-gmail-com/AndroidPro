package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnTroChoiMoi,btnLichSu,btnBangXepHang,btnQuanLyTaiKhoan,btnMuaCredit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        AnhXa();

        TroChoiMoi();

        LichSu();

        QuanLyTaiKhoan();

        BangXepHang();
    }

    public void AnhXa(){
        btnTroChoiMoi = (Button) findViewById(R.id.buttonTroChoiMoi);
        btnBangXepHang = (Button) findViewById(R.id.buttonBangXepHang);
        btnLichSu = (Button) findViewById(R.id.buttonLichSu);
        btnMuaCredit = (Button) findViewById(R.id.buttonMuaCredit);
        btnQuanLyTaiKhoan = (Button) findViewById(R.id.buttonQuanLyTaiKhoan);
    }

    public void TroChoiMoi(){
        btnTroChoiMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, LinhVucActivity.class);
                startActivity(intent);
            }
        });
    }

    public void LichSu(){
        btnLichSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, LichSuActivity.class);
                startActivity(intent);
            }
        });
    }

    public void BangXepHang(){
        btnBangXepHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, BangXepHangActivity.class);
                startActivity(intent);
            }
        });
    }

    public void QuanLyTaiKhoan(){
        btnQuanLyTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, TaiKhoanActivity.class);
                startActivity(intent);
            }
        });
    }
}
