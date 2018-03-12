package com.example.android.mpandroidchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

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

        entries.add(new Entry(2, 38));
        entries.add(new Entry(3, 25));
        entries.add(new Entry(4, 39));
        entries.add(new Entry(5, 30));
        entries.add(new Entry(6, 22));
        entries.add(new Entry(7, 26));
        entries.add(new Entry(8, 28));
        entries.add(new Entry(9, 34));
        entries.add(new Entry(10, 31));
        entries.add(new Entry(11, 21));
        entries.add(new Entry(12, 50));

        LineDataSet dataSet = new LineDataSet(entries, "Lifeline"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setLineWidth(6);

        LineData lineData = new LineData(dataSet);

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

        rightYAxis = chart.getAxisRight();
        rightYAxis.setDrawGridLines(false); // no grid lines
        rightYAxis.setDrawAxisLine(false); // no axis line
        rightYAxis.setDrawLabels(false);

        xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f); // start at zero
        xAxis.setDrawGridLines(false); // no grid lines
        xAxis.setDrawAxisLine(false); // no axis line

        String[] values = {"0", "01 Aug’17", "02 Aug’17", "03 Aug’17", "04 Aug’17", "05 Aug’17", "06 Aug’17", "07 Aug’17", "08 Aug’17", "09 Aug’17", "10 Aug’17", "11 Aug’17", "12 Aug’17", "13 Aug’17", "14 Aug’17", "15 Aug’17"};
        xAxis.setValueFormatter(new xAxisFormatter(values));
        xAxis.setGranularity(1);

    }

    public class xAxisFormatter implements IAxisValueFormatter {

        private String[] mValues;

        public xAxisFormatter(String[] values) {
            mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }


}
