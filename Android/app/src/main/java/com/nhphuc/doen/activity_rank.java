package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class activity_rank extends AppCompatActivity {

    RecyclerView recyclerViewRank;
    RankAdapter rankAdapter;
    ArrayList<Rank> rankArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        AnhXa();

        RankGame();
    }

    private void AnhXa() {
        recyclerViewRank = (RecyclerView) findViewById(R.id.recyclerViewRank);
        recyclerViewRank.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewRank.setLayoutManager(layoutManager);

        rankArrayList = new ArrayList<>();

        rankArrayList.add(new Rank("1", R.drawable.avatar , "Nguyen Minh Phuong", "25000"));
        rankArrayList.add(new Rank("2", R.drawable.avatar, "Nguyen Hoang Phuc", "24000"));
        rankArrayList.add(new Rank("3", R.drawable.avatar, "Nguyen Nhat Minh", "23000"));
        rankArrayList.add(new Rank("4", R.drawable.avatar, "Vo Nhat Ninh", "22000"));
        rankArrayList.add(new Rank("5", R.drawable.avatar, "Huynh Ngoc Tam", "21000"));
        rankArrayList.add(new Rank("6", R.drawable.avatar, "Tran Minh Tam", "20000"));
        rankArrayList.add(new Rank("7", R.drawable.avatar, "Bui Anh Khoa", "19000"));
        rankArrayList.add(new Rank("8", R.drawable.avatar, "Truong Thuy Trang", "18000"));
        rankArrayList.add(new Rank("9", R.drawable.avatar, "Le Minh Nhut", "17000"));
        rankArrayList.add(new Rank("10", R.drawable.avatar, "Nguyen Thanh Long", "16000"));
    }

    private void RankGame(){

        rankAdapter = new RankAdapter(rankArrayList, getApplicationContext());
        recyclerViewRank.setAdapter(rankAdapter);
    }
}
