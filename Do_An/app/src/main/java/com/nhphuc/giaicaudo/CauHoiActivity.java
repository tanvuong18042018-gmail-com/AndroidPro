package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class CauHoiActivity extends AppCompatActivity {

    GridView gvTraiTim;
    AdapterLuotChoi adapterLuotChoi;
    ArrayList<HinhAnhLuotChoi> hinhAnhLuotChoiArrayList;

    ImageButton ibtnNguoiThan,ibtnKhanGia,ibtn50,ibtnDoiCauHoi,ibtnMuaCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau_hoi);

        AnhXa();
        LuotChoi();
        ShowPopup();
    }

    public void AnhXa(){
        ibtnNguoiThan = (ImageButton) findViewById(R.id.imageButtonICNguoiThan);

        gvTraiTim = (GridView) findViewById(R.id.gridViewTraiTim);
        hinhAnhLuotChoiArrayList = new ArrayList<>();
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 1",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 2",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 3",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 4",R.drawable.icotraitim));
        hinhAnhLuotChoiArrayList.add(new HinhAnhLuotChoi("Lượt 5",R.drawable.icotraitim));
    }
    public void ShowPopup(){
        ibtnNguoiThan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowPopupNguoiThan();
            }
        });
    }
    public void ShowPopupNguoiThan(){
        final Dialog dialogPopupNguoiThan = new Dialog(this);
        Button btnCamOn;
        dialogPopupNguoiThan.setContentView(R.layout.popup_goi_dien_nguoi_than);
        btnCamOn = (Button) dialogPopupNguoiThan.findViewById(R.id.buttonCamOn);
        dialogPopupNguoiThan.show();
        btnCamOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPopupNguoiThan.dismiss();
            }
        });
    }

    public void LuotChoi(){
        adapterLuotChoi = new AdapterLuotChoi(this,R.layout.dong_luot_choi,hinhAnhLuotChoiArrayList);
        gvTraiTim.setAdapter(adapterLuotChoi);
    }
}
