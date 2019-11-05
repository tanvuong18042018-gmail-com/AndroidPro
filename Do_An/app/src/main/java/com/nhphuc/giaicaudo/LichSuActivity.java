package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class LichSuActivity extends AppCompatActivity {


    ListView lvLichSuChoi;
    AdapterLichSuChoi adapterLichSuChoi;
    ArrayList<LichSuNguoiChoi> lichSuNguoiChoiArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su);

        AnhXa();

        LichSuChoi();
    }

    public void AnhXa(){
        lvLichSuChoi = (ListView) findViewById(R.id.listViewLichSuChoi);
        lichSuNguoiChoiArrayList = new ArrayList<>();
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("24/10","8","2000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("23/10","7","3000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("21/10","6","4000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));

    }

    public void LichSuChoi(){
        adapterLichSuChoi = new AdapterLichSuChoi(this,R.layout.dong_lich_su_choi,lichSuNguoiChoiArrayList);
        lvLichSuChoi.setAdapter(adapterLichSuChoi);
    }

}
