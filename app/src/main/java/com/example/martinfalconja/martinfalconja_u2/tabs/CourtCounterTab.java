package com.example.martinfalconja.martinfalconja_u2.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.martinfalconja.martinfalconja_u2.R;
import com.example.martinfalconja.martinfalconja_u2.logic.court_counter_tab.BasketBallPlayer;
import com.example.martinfalconja.martinfalconja_u2.logic.court_counter_tab.Score;

/**
 * Created by jamarfal on 25/9/16.
 */

public class CourtCounterTab extends Fragment {
    BasketBallPlayer playerA;
    BasketBallPlayer playerB;
    TextView scoreViewPlayerA, scoreViewPlayerB;
    Button buttonFreeThrowPlayerA, buttonTwoThrowPlayerA, buttonThreeThrowPlayerA,
            buttonFreeThrowPlayerB, buttonTwoThrowPlayerB, buttonThreeThrowPlayerB,
            buttonResetPoints;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initPlayers();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_court_counter, container, false);

        initViews(view);

        initButtonListeners();

        return view;
    }

    private void initViews(View view) {
        scoreViewPlayerA = (TextView) view.findViewById(R.id.team_a_score);
        scoreViewPlayerB = (TextView) view.findViewById(R.id.team_b_score);
        buttonThreeThrowPlayerA = (Button) view.findViewById(R.id.button_three_points_player_a);
        buttonTwoThrowPlayerA = (Button) view.findViewById(R.id.button_two_points_player_a);
        buttonFreeThrowPlayerA = (Button) view.findViewById(R.id.button_one_points_player_a);
        buttonThreeThrowPlayerB = (Button) view.findViewById(R.id.button_three_points_player_b);
        buttonTwoThrowPlayerB = (Button) view.findViewById(R.id.button_two_points_player_b);
        buttonFreeThrowPlayerB = (Button) view.findViewById(R.id.button_one_points_player_b);
        buttonResetPoints = (Button) view.findViewById(R.id.reset_points_button);
    }

    private void initButtonListeners() {
        buttonThreeThrowPlayerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwThreePointsA();
            }
        });

        buttonTwoThrowPlayerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwTwoPointsA();
            }
        });

        buttonFreeThrowPlayerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwFreeThrowA();
            }
        });

        buttonThreeThrowPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwThreePointsB();
            }
        });

        buttonTwoThrowPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwTwoPointsB();
            }
        });

        buttonFreeThrowPlayerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwFreeThrowB();
            }
        });
        
        buttonResetPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScores();
            }
        });
    }


    private void initPlayers() {
        playerA = new BasketBallPlayer(new Score());
        playerB = new BasketBallPlayer(new Score());
    }

    private void displayScoreForTeamA() {
        scoreViewPlayerA.setText(String.valueOf(playerA.getPoints()));
    }

    private void displayScoreForTeamB() {
        scoreViewPlayerB.setText(String.valueOf(playerB.getPoints()));
    }

    private void throwThreePointsA() {
        playerA.throwThreePoints();
        displayScoreForTeamA();
    }

    private void throwTwoPointsA() {
        playerA.throwTwoPoints();
        displayScoreForTeamA();
    }

    private void throwFreeThrowA() {
        playerA.throwFreeThrow();
        displayScoreForTeamA();
    }

    private void throwThreePointsB() {
        playerB.throwThreePoints();
        displayScoreForTeamB();
    }

    private void throwTwoPointsB() {
        playerB.throwTwoPoints();
        displayScoreForTeamB();
    }

    private void throwFreeThrowB() {
        playerB.throwFreeThrow();
        displayScoreForTeamB();
    }

    private void resetScores() {
        playerA.resetPoints();
        playerB.resetPoints();
        displayScoreForTeamA();
        displayScoreForTeamB();
    }
}
