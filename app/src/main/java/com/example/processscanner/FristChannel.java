package com.example.processscanner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import com.example.processscanner.Activites.Channel1;
import com.example.processscanner.Activites.Channel2;
import com.example.processscanner.Activites.Channel3;
import com.example.processscanner.Activites.Channel4;
import com.example.processscanner.Activites.Channel5;
import com.example.processscanner.Activites.Channel6;
import com.example.processscanner.Activites.Channel7;
import com.example.processscanner.Activites.Channel8;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;


public class FristChannel extends Fragment {
    RelativeLayout cardChannel1,cardChannel2 ,cardChannel3,cardChannel4,cardChannel5,cardChannel6,cardChannel7,cardChannel8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frist_channel, container, false);

        GridLayout gridLayout = view.findViewById(R.id.gridLayoutChannels1to8);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            makeDraggable(gridLayout.getChildAt(i), i);
        }


        LineChart[] lineCharts = new LineChart[8];
        lineCharts[0] = view.findViewById(R.id.chart1);
        lineCharts[1] = view.findViewById(R.id.chart2);
        lineCharts[2] = view.findViewById(R.id.chart3);
        lineCharts[3] = view.findViewById(R.id.chart4);
        lineCharts[4] = view.findViewById(R.id.chart5);
        lineCharts[5] = view.findViewById(R.id.chart6);
        lineCharts[6] = view.findViewById(R.id.chart7);
        lineCharts[7] = view.findViewById(R.id.chart8);





        for (int i = 0; i < lineCharts.length; i++) {
            configureLineChart(lineCharts[i]);
            int lineColor = getLineColor(i);
            int fillColor = getFillColor(i);
            setData(lineCharts[i], 50, 80, lineColor, fillColor);
        }

         lineCharts[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel1.class);
                startActivity(intent);
            }
        });
        lineCharts[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel2.class);
                startActivity(intent);
            }
        });

        lineCharts[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel3.class);
                startActivity(intent);
            }
        });

        lineCharts[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel4.class);
                startActivity(intent);
            }
        });

        lineCharts[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel5.class);
                startActivity(intent);
            }
        });

        lineCharts[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel6.class);
                startActivity(intent);
            }
        });

        lineCharts[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel7.class);
                startActivity(intent);
            }
        });

        lineCharts[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("--------", "onClick: Button is clicked ");
                Intent intent = new Intent(getActivity(), Channel8.class);
                startActivity(intent);
            }
        });

//        lineCharts[8].setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("--------", "onClick: Button is clicked ");
//                Intent intent = new Intent(getActivity(), Channel1.class);
//                startActivity(intent);
//            }
//        });

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


    private void makeDraggable(final View view, final int index) {
        view.setOnTouchListener(new View.OnTouchListener() {
            float dX, dY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        v.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();
                        break;

                    case MotionEvent.ACTION_UP:
                        // Handle the drop here if needed
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });
    }
}