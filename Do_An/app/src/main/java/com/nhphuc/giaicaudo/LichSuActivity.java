package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class LichSuActivity extends AppCompatActivity {


    RecyclerView rvLichSuChoi;
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
        rvLichSuChoi = (RecyclerView) findViewById(R.id.recyclerViewLichSuChoi);
        rvLichSuChoi.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvLichSuChoi.setLayoutManager(layoutManager);

        lichSuNguoiChoiArrayList = new ArrayList<>();
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("24/10","8","2000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("23/10","7","3000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("21/10","6","4000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("22/10","5","5000"));
        lichSuNguoiChoiArrayList.add(new LichSuNguoiChoi("25/10","9","1000"));

    }

    public void LichSuChoi(){

        Animation animRv = AnimationUtils.loadAnimation(this,R.anim.anim_recyclerview);
        rvLichSuChoi.startAnimation(animRv);

        adapterLichSuChoi = new AdapterLichSuChoi(lichSuNguoiChoiArrayList,getApplicationContext());
        rvLichSuChoi.setAdapter(adapterLichSuChoi);
    }

}
