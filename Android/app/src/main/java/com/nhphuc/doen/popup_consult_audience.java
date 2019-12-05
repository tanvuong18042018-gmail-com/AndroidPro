package com.nhphuc.doen;

import java.util.ArrayList;
import java.util.Collections;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

public class popup_consult_audience extends AppCompatActivity {

    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_consult_audience);
        chart = (BarChart) findViewById(R.id.chart);

        BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();

        AddValuesToBarEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, null);

        BARDATA = new BarData(BarEntryLabels, Bardataset);

        Bardataset.setColor(Color.parseColor("#3300ff"));

        Bardataset.setValueTextSize(20);

        chart.setData(BARDATA);

        chart.animateY(5000);

        chart.setDescription(null);

        chart.getLegend().setEnabled(false);

        chart.setDescriptionTextSize(25);

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        chart.getAxisRight().setEnabled(false);
        chart.getAxisLeft().setEnabled(false);

        chart.getAxisLeft().setTextSize(15);

        chart.getXAxis().setTextSize(25);

        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);

        chart.setTouchEnabled(false);

        chart.setDoubleTapToZoomEnabled(false);
    }

    public void AddValuesToBARENTRY(){

        BARENTRY.add(new BarEntry(55, 0));
        BARENTRY.add(new BarEntry(10, 1));
        BARENTRY.add(new BarEntry(25, 2));
        BARENTRY.add(new BarEntry(15, 3));

    }

    public void AddValuesToBarEntryLabels(){

        BarEntryLabels.add("A");
        BarEntryLabels.add("B");
        BarEntryLabels.add("C");
        BarEntryLabels.add("D");

    }
}
