package com.nhphuc.giaicaudo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CauHoiActivity extends AppCompatActivity {

    TextView txtView;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
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
        //ShowPopup();
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
//    public void ShowPopup(){
//        ibtnNguoiThan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ShowPopupNguoiThan();
//            }
//        });
//    }



//    public void ShowPopupNguoiThan(){
//    }

    public void LuotChoi(){
        adapterLuotChoi = new AdapterLuotChoi(this,R.layout.dong_luot_choi,hinhAnhLuotChoiArrayList);
        gvTraiTim.setAdapter(adapterLuotChoi);
    }

    private String randomCharacter(int length)
    {
        char[] chars = "ABCD".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i< length; i++)
        {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public void showPopupHelpFamily(View view) {

        final Dialog dialogPopupNguoiThan = new Dialog(this);
        dialogPopupNguoiThan.setContentView(R.layout.popup_goi_dien_nguoi_than);
        txtView = dialogPopupNguoiThan.findViewById(R.id.textViewDapAnNguoiThan);
        txtView.setText(randomCharacter(1));
        dialogPopupNguoiThan.show();

        Button btnCamOn;
        btnCamOn = (Button) dialogPopupNguoiThan.findViewById(R.id.btn_thanks);
        btnCamOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPopupNguoiThan.dismiss();
            }
        });
    }
    private String randomDapAnFail1(int length)
    {
        char[] chars = "12121212".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i< length; i++)
        {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    private String randomDapAnFail2(int length)
    {
        char[] chars = "34343434".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i< length; i++)
        {
            char c = chars[random.nextInt(chars.length)];
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public void loaiBoDapAnSai(View view) {
        btnDapAnA = findViewById(R.id.buttonA);
        btnDapAnB = findViewById(R.id.buttonB);
        btnDapAnC = findViewById(R.id.buttonC);
        btnDapAnD = findViewById(R.id.buttonD);

        if (randomDapAnFail1(1) == "1")
        {
            btnDapAnA.setVisibility(View.INVISIBLE);
        }
        else{
            btnDapAnB.setVisibility(View.INVISIBLE);
        }
        if (randomDapAnFail2(1) == "3")
        {
            btnDapAnC.setVisibility(View.INVISIBLE);
        }
        else {
            btnDapAnD.setVisibility(View.INVISIBLE);
        }
    }
}
