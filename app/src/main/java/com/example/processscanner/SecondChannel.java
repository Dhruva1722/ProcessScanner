package com.example.processscanner;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;


public class SecondChannel extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_channel, container, false);

        LineChart[] lineCharts = new LineChart[8];
        lineCharts[0] = view.findViewById(R.id.chart9);
        lineCharts[1] = view.findViewById(R.id.chart10);
        lineCharts[2] = view.findViewById(R.id.chart11);
        lineCharts[3] = view.findViewById(R.id.chart12);
        lineCharts[4] = view.findViewById(R.id.chart13);
        lineCharts[5] = view.findViewById(R.id.chart14);
        lineCharts[6] = view.findViewById(R.id.chart15);
        lineCharts[7] = view.findViewById(R.id.chart16);

        // Configure each LineChart
        for (int i = 0; i < lineCharts.length; i++) {
            configureLineChart(lineCharts[i]);
            int lineColor = getLineColor(i); // Define a method to get different line colors
            int fillColor = getFillColor(i); // Define a method to get different fill colors
            setData(lineCharts[i], 50, 80, lineColor, fillColor);
        }

        return view;
    }

    private void setData(LineChart lineChart, int count, float range, int lineColor, int fillColor) {
        ArrayList<Entry> yVals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 100;
            yVals.add(new Entry(i, val));
        }

        LineDataSet dataSet = new LineDataSet(yVals, "Data Set");
        dataSet.setColor(lineColor);
        dataSet.setDrawCircles(false);
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(fillColor);
        dataSet.setValueTextSize(0f);


        LineData data = new LineData(dataSet);
        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void configureLineChart(LineChart lineChart) {
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setPinchZoom(true);
        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.setViewPortOffsets(0f, 0f, 0f, 0f);
        lineChart.setGridBackgroundColor(Color.TRANSPARENT);

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setEnabled(false); // Disable the left Y-axis
        lineChart.getAxisRight().setEnabled(false);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setEnabled(false); // Disable the X-axis

    }

    private int getLineColor(int index) {
        switch (index) {
            case 0:
                return getResources().getColor(R.color.blue);
            case 1:
                return getResources().getColor(R.color.red);
            case 2:
                return getResources().getColor(R.color.yellow);
            case 3:
                return getResources().getColor(R.color.blue);
            case 4:
                return getResources().getColor(R.color.purple);
            case 5:
                return getResources().getColor(R.color.red);
            case 6:
                return getResources().getColor(R.color.yellow);
            case 7:
                return getResources().getColor(R.color.purple);

            default:
                return getResources().getColor(R.color.black);
        }
    }


    private int getFillColor(int index) {
        switch (index) {
            case 0:
                return getResources().getColor(R.color.blue);
            case 1:
                return getResources().getColor(R.color.red);
            case 2:
                return getResources().getColor(R.color.yellow);
            case 3:
                return getResources().getColor(R.color.blue);
            case 4:
                return getResources().getColor(R.color.purple);
            case 5:
                return getResources().getColor(R.color.red);
            case 6:
                return getResources().getColor(R.color.yellow);
            case 7:
                return getResources().getColor(R.color.purple);
            default:
                return getResources().getColor(R.color.black);
        }
    }
}