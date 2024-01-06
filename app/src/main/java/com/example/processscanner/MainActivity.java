package com.example.processscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;

    private TabLayout tabLayout;

    private TextView relay1,relay2, relay3,relay4;


//    GraphView graphView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager =findViewById(R.id.channelViewPager);
        tabLayout = findViewById(R.id.tabLayout);

        ChannelAdapter pagerAdapter = new ChannelAdapter(getSupportFragmentManager());

        pagerAdapter.addFragment(new FristChannel(), "Channel 1-8");
        pagerAdapter.addFragment(new SecondChannel(), "Channel 9-16");
        pagerAdapter.addFragment(new AllChannel(), "All Channel");

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        TextView liveTextView = findViewById(R.id.connected);
        Handler handler1 = new Handler();
        final int textColor1 = getColor(R.color.yellow);
        final long blinkInterval = 2000;

        Runnable blinkRunnable1 = new Runnable() {
            @Override
            public void run() {
                liveTextView.setTextColor(liveTextView.getTextColors().getDefaultColor() == textColor1 ?
                        getColor(R.color.green) : textColor1);
                handler1.postDelayed(this, blinkInterval);
            }
        };

// Start the blinking effect by posting the runnable
        handler1.post(blinkRunnable1);

        relay1 = findViewById(R.id.r1);
        relay2 = findViewById(R.id.r2);
        relay3 = findViewById(R.id.r3);
        relay4 = findViewById(R.id.r4);
        Handler handler = new Handler();


        final List<TextView> relayTextViews = new ArrayList<>();
        relayTextViews.add(relay1);
        relayTextViews.add(relay2);
        relayTextViews.add(relay3);
        relayTextViews.add(relay4);


        final int textColor = Color.BLACK;
        final long[] blinkIntervals = {500, 1000, 1500, 2000}; // Adjust intervals as needed


        for (int i = 0; i < relayTextViews.size(); i++) {
            final TextView currentRelay = relayTextViews.get(i);


            int finalI = i;
            Runnable blinkRunnable = new Runnable() {
                @Override
                public void run() {

                    currentRelay.setTextColor(currentRelay.getTextColors().getDefaultColor() == textColor ?
                            Color.RED : textColor);

                    handler.postDelayed(this, blinkIntervals[finalI]);
                }
            };
            handler.post(blinkRunnable);
        }

    }


}






//        tabLayout = findViewById(R.id.tabLayout);
//        gridLayoutChannels1to8 = findViewById(R.id.gridLayoutChannels1to8);
//        gridLayoutChannels9to16 = findViewById(R.id.gridLayoutChannels9to16);
//        btnLeftArrow = findViewById(R.id.btnLeftArrow);
//        btnRightArrow = findViewById(R.id.btnRightArrow);
//
//        // Set up the TabLayout
//        tabLayout.addTab(tabLayout.newTab().setText("Channels 1-8"));
//        tabLayout.addTab(tabLayout.newTab().setText("Channels 9-16"));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                switch (tab.getPosition()) {
//                    case 0:
//                        gridLayoutChannels1to8.setVisibility(View.VISIBLE);
//                        gridLayoutChannels9to16.setVisibility(View.GONE);
//                        break;
//                    case 1:
//                        gridLayoutChannels1to8.setVisibility(View.GONE);
//                        gridLayoutChannels9to16.setVisibility(View.VISIBLE);
//                        break;
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                // Not used
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                // Not used
//            }
//        });
//
//        // Set up left arrow button click
//        btnLeftArrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tabLayout.getTabAt(0).select();
//            }
//        });
//
//        // Set up right arrow button click
//        btnRightArrow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tabLayout.getTabAt(1).select();
//            }
//        });


//        graphView = findViewById(R.id.idGraphView);
//
//        graphView.setBackgroundColor(getResources().getColor(R.color.white));
//
//// Create a LineGraphSeries with data
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
//                new DataPoint(0, 1),
//                new DataPoint(1, 3),
//                new DataPoint(2, 4),
//                new DataPoint(3, 9),
//                new DataPoint(4, 6),
//                new DataPoint(5, 3),
//                new DataPoint(6, 6),
//                new DataPoint(7, 1),
//                new DataPoint(8, 2)
//        });
//
//// Set up the graph properties
//        graphView.addSeries(series);
//        graphView.getGridLabelRenderer().setHorizontalLabelsVisible(false);
//        graphView.getGridLabelRenderer().setVerticalLabelsVisible(false);
//        graphView.getGridLabelRenderer().setGridStyle(com.jjoe64.graphview.GridLabelRenderer.GridStyle.NONE);
//        graphView.getViewport().setDrawBorder(false);
//        graphView.getViewport().setScalable(true);
//        graphView.getViewport().setScrollable(true);




