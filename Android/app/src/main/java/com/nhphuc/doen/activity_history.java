package com.nhphuc.doen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class activity_history extends AppCompatActivity {

    RecyclerView recyclerViewHistory;
    HistoryAdapter historyAdapter;
    ArrayList<History> historyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        AnhXa();

        HistoryGame();
    }

    private void AnhXa(){
        recyclerViewHistory = (RecyclerView) findViewById(R.id.recyclerViewHistory);
        recyclerViewHistory.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewHistory.setLayoutManager(layoutManager);

        historyArrayList = new ArrayList<>();

        historyArrayList.add(new History("1", "25156", "2-12-2019"));
        historyArrayList.add(new History("2", "25156", "2-12-2019"));
        historyArrayList.add(new History("3", "25156", "2-12-2019"));
        historyArrayList.add(new History("4", "25156", "2-12-2019"));
        historyArrayList.add(new History("5", "25156", "2-12-2019"));
        historyArrayList.add(new History("6", "25156", "2-12-2019"));
        historyArrayList.add(new History("7", "25156", "2-12-2019"));
        historyArrayList.add(new History("8", "25156", "2-12-2019"));
        historyArrayList.add(new History("9", "25156", "2-12-2019"));
        historyArrayList.add(new History("10", "25156", "2-12-2019"));
    }

    private void HistoryGame() {
        historyAdapter = new HistoryAdapter(historyArrayList, getApplicationContext());
        recyclerViewHistory.setAdapter(historyAdapter);
    }
}
