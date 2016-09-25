package com.example.martinfalconja.martinfalconja_u2.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.martinfalconja.martinfalconja_u2.R;

/**
 * Created by jamarfal on 25/9/16.
 */

public class AsteroidTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_asteroids, container, false);
    }
}
