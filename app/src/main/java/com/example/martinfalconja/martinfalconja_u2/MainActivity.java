package com.example.martinfalconja.martinfalconja_u2;

import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.martinfalconja.martinfalconja_u2.tabs.AsteroidTab;

public class MainActivity extends AppCompatActivity {

    public final String ASTEROID_TAB = "asteroid_tab";
    private FragmentTabHost fragmentTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTabs();
    }

    private void setupTabs() {
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,
                getSupportFragmentManager(),
                android.R.id.tabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec(ASTEROID_TAB).setIndicator(""), AsteroidTab.class, null);
    }
}
