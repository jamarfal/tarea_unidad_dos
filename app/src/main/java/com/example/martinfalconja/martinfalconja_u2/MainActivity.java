package com.example.martinfalconja.martinfalconja_u2;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;

import com.example.martinfalconja.martinfalconja_u2.tabs.AsteroidTab;
import com.example.martinfalconja.martinfalconja_u2.tabs.CustomButtonTab;

public class MainActivity extends FragmentActivity {

    public final String ASTEROID_TAB = "asteroid_tab";
    public final String CUSTOMBUTTON_TAB = "custombutton_tab";
    private FragmentTabHost fragmentTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTabs();
    }

    private void setupTabs() {
        Resources resources = getResources();
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,
                getSupportFragmentManager(),
                android.R.id.tabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec(ASTEROID_TAB).setIndicator(resources.getString(R.string.asteroid_tab)), AsteroidTab.class, null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec(CUSTOMBUTTON_TAB).setIndicator(resources.getString(R.string.custombutton_tab)), CustomButtonTab.class, null);
    }
}
