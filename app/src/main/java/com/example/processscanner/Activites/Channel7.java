package com.example.processscanner.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.processscanner.MainActivity;
import com.example.processscanner.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Channel7 extends AppCompatActivity {

    ImageView backBtn;
    private LineChart lineChart;
    private BarChart barChart;
    BarData barData;
    private TextView timeTextView, dateTextView;
    private Handler handler;
    ArrayList barEntriesArrayList;
    private ImageView lineGraphImageView, barGraphImageView;
    private int fillColor = Color.argb(150, 255,255,0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel7);
        backBtn = findViewById(R.id.backArrow);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Channel7.this, MainActivity.class);
                startActivity(intent);
            }
        });

        timeTextView = findViewById(R.id.timeTv);
        dateTextView = findViewById(R.id.dateTv);
        handler = new Handler(Looper.getMainLooper());

        // Start updating time every second
        startUpdatingTime();
    }

    private void startUpdatingTime() {
        // Schedule a runnable to update time every second
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateTime();
                // Repeat the update every second
                handler.postDelayed(this, 1000);
            }
        }, 1000);

        // Display current date
        updateDate();


        lineChart = findViewById(R.id.chart1);
        barChart = findViewById(R.id.barChart1);
        lineGraphImageView = findViewById(R.id.lineGraph);
        barGraphImageView = findViewById(R.id.barGraph);

        // Set up initial visibility
        lineChart.setVisibility(View.VISIBLE);
        barChart.setVisibility(View.GONE);

        setDataForLineChart();
        // Set up OnClickListener for Line Graph
        lineGraphImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility
                lineChart.setVisibility(View.VISIBLE);
                barChart.setVisibility(View.GONE);
                setDataForLineChart();
            }
        });

        // Set up OnClickListener for Bar Graph
        barGraphImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle visibility
                lineChart.setVisibility(View.GONE);
                barChart.setVisibility(View.VISIBLE);
                setDataForBarChart();
            }
        });

    }

    private void updateTime() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String currentTime = timeFormat.format(calendar.getTime());

        // Set the current time to the TextView
        timeTextView.setText(currentTime);
    }

    private void updateDate() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());

        // Set the current date to the TextView
        dateTextView.setText(currentDate);
    }

    @Override
    protected void onDestroy() {
        // Remove the callbacks to prevent memory leaks
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();

    }
    private void setDataForBarChart() {
        getBarEntries();  // Call this method to initialize barEntriesArrayList

        BarDataSet barDataSet = new BarDataSet(barEntriesArrayList, "Bar Data Set");
        barDataSet.setColors(getColor(R.color.yellow));
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        barData = new BarData(barDataSet);
        barChart.setData(barData);

        barChart.getDescription().setEnabled(false);
        barChart.invalidate(); // Refresh the chart

    }
    private void getBarEntries() {
        barEntriesArrayList = new ArrayList<>();
        barEntriesArrayList.add(new BarEntry(1f, 400));
        barEntriesArrayList.add(new BarEntry(2f, 190));
        barEntriesArrayList.add(new BarEntry(3f, 350));
        barEntriesArrayList.add(new BarEntry(4f, 200));
        barEntriesArrayList.add(new BarEntry(5f, 400));
        barEntriesArrayList.add(new BarEntry(6f, 100));
    }

    private void setDataForLineChart() {
        lineChart.getDescription().setEnabled(false);
        lineChart.setDrawBorders(false);
        lineChart.setPinchZoom(false);

        Legend l = lineChart.getLegend();
        l.setEnabled(true);

        // Hide X-axis and Y-axis
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setEnabled(true);

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setEnabled(true);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(true);

        setData(50, 100);
    }

    private void setData(int count, float range) {
        ArrayList<Entry> yVals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 400;
            yVals.add(new Entry(i, val));
        }

        ArrayList<Entry> yVals1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 150;
            yVals1.add(new Entry(i, val));
        }

        LineDataSet set1, set2;

        set1 = new LineDataSet(yVals, "Data Set1");
        set1.setColor(getColor(R.color.yellow));
        set1.setDrawCircles(true);
        set1.setDrawFilled(true);
        set1.setFillColor(fillColor);

        set2 = new LineDataSet(yVals1, "Data Set1");
        set2.setColor(getColor(R.color.yellow));
        set2.setDrawCircles(true);
        set2.setDrawFilled(true);
        set2.setFillColor(fillColor);

        LineData data = new LineData(set2, set1);
        data.setDrawValues(true);
        lineChart.setData(data);
    }

}