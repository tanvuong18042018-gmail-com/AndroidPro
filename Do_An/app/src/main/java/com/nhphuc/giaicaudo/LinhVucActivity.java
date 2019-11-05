package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

public class LinhVucActivity extends AppCompatActivity {

    GridView gvTraiTim;
    AdapterLuotChoi adapterLuotChoi;
    ArrayList<HinhAnhLuotChoi> hinhAnhLuotChoiArrayList;

    Button btnXaHoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linh_vuc);

        AnhXa();

        LuotChoi();

        XaHoi();
    }

    public void AnhXa(){
        btnXaHoi = (Button) findViewById(R.id.buttonXaHoi);

        gvTraiTim = (GridView) findViewById(R.id.gridViewTraiTim);
        hinhAnhLuotChoiArrayList = new ArrayList<>();
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 1",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 2",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 3",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 4",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 5",R.drawable.icotraitim));
    }

    public void LuotChoi(){
        adapterLuotChoi = new AdapterLuotChoi(this,R.layout.dong_luot_choi,hinhAnhLuotChoiArrayList);
        gvTraiTim.setAdapter(adapterLuotChoi);
    }

    public void XaHoi(){
        btnXaHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LinhVucActivity.this,CauHoiActivity.class);
                startActivity(intent);
            }
        });
    }
}
