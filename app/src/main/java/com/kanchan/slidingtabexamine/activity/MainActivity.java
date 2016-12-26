package com.kanchan.slidingtabexamine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kanchan.slidingtabexamine.event.MessageEvent;
import com.kanchan.slidingtabexamine.R;
import com.kanchan.slidingtabexamine.adapter.TabsPagerAdapter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabsPagerAdapter pagerAdapter;
    private Button btnSend;

    private ArrayList<String> tabsTitles;
    private int[] tabIcons = {
            R.drawable.add,
            R.drawable.ic_action_nav,
            R.drawable.user
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolBar();
        initView();
        setUiListener();
        initData();
        setUpPagerAdapter();
      //  setupTabIcons();
    }

    private void setUiListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("Hello everyone!"));
            }
        });
    }

    private void setUpToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        btnSend = (Button) findViewById(R.id.btnSend);
    }

    private void setUpPagerAdapter() {
        pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), tabsTitles);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        tabsTitles = new ArrayList<>();
        tabsTitles.add("ONE");
        tabsTitles.add("TWO");
        tabsTitles.add("THREE");
     /*   tabsTitles.add("FOUR");
        tabsTitles.add("FIVE");
        tabsTitles.add("SIX");
        tabsTitles.add("SEVEN");
        tabsTitles.add("EIGHT");
        tabsTitles.add("NINE");
        tabsTitles.add("TEN"); */
    }

    private void setupTabIcons() {
      /*  tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]); */
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("ONE");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[0], 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("TWO");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[1], 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("THREE");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[2], 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

}
