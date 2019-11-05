package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class BangXepHangActivity extends AppCompatActivity {

    ListView lvBangXepHang;
    AdapterXepHang adapterXepHang;
    ArrayList<BangXepHang> bangXepHangArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_xep_hang);

        AnhXa();

        BangXepHang();
    }

    public void AnhXa(){
        lvBangXepHang = (ListView) findViewById(R.id.listViewBangXepHang);
        bangXepHangArrayList = new ArrayList<>();
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"nhphuc","5000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"vnninh","4000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"nnminh","3000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"nmphuong","2000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"btvuong","1000"));
        bangXepHangArrayList.add(new BangXepHang(R.mipmap.ic_launcher,"ntam","10000"));
    }


    public void BangXepHang(){
        adapterXepHang = new AdapterXepHang(this,R.layout.dong_bang_xep_hang,bangXepHangArrayList);
        lvBangXepHang.setAdapter(adapterXepHang);
    }
}
