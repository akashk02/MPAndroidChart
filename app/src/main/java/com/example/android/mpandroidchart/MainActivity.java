package com.example.android.mpandroidchart;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LineChart chart;
    private YAxis leftYAxis;
    private YAxis rightYAxis;
    private XAxis xAxis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = (LineChart) findViewById(R.id.chart);
        List<Entry> entries = new ArrayList<>();


        entries.add(new Entry(2, 38 ,"02 Aug’17"));
        entries.add(new Entry(3, 25 ,"03 Aug’17"));
        entries.add(new Entry(4, 39 ,"04 Aug’17"));
        entries.add(new Entry(5, 30 ,"05 Aug’17"));
        entries.add(new Entry(6, 22 ,"06 Aug’17"));
        entries.add(new Entry(7, 26 ,"07 Aug’17"));
        entries.add(new Entry(8, 28 ,"08 Aug’17"));
        entries.add(new Entry(9, 34 ,"09 Aug’17"));
        entries.add(new Entry(10, 31,"10 Aug’17"));
        entries.add(new Entry(11, 21,"11 Aug’17"));
        entries.add(new Entry(12, 50,"12 Aug’17"));

        LineDataSet dataSet = new LineDataSet(entries, "Lifeline"); // add entries to dataset
        dataSet.setLineWidth(8);
        dataSet.setValueTextSize(18);
        dataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return entry.getData().toString();
            }
        });

        dataSet.setValueTypeface(Typeface.createFromAsset(getAssets(),"fonts/Lobster.otf"));

        LineData lineData = new LineData(dataSet);
        lineData.setValueTextColor(R.color.graph);

        chart.setData(lineData);
        chart.setVisibleXRangeMaximum(2);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setPinchZoom(false);
        chart.setScaleEnabled(false);
        chart.getDescription().setText("");
        chart.invalidate(); // refresh

        leftYAxis = chart.getAxisLeft();
        leftYAxis.setAxisMinimum(10f); // start at 10
        leftYAxis.setDrawGridLines(false); // no grid lines
        leftYAxis.setTextSize(14);
        leftYAxis.setTextColor(R.color.graph);
        leftYAxis.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Lobster.otf"));

        rightYAxis = chart.getAxisRight();
        rightYAxis.setDrawGridLines(false); // no grid lines
        rightYAxis.setDrawAxisLine(false); // no axis line
        rightYAxis.setDrawLabels(false); // no axis line

        xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f); // start at zero
        xAxis.setDrawGridLines(false); // no grid lines
        xAxis.setDrawAxisLine(false); // no axis line
        xAxis.setTextSize(14);
        xAxis.setTextColor(R.color.graph);
        xAxis.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Lobster.otf"));
        xAxis.setDrawLabels(false); // no axis line

    }
}
