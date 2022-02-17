package com.project.warehouse.hacktivapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatTextView;

public class ScoreActivity extends AppCompatActivity {

    private int scoreTeam1 = 0;
    private int scoreTeam2 = 0;

    // Team 1
    AppCompatTextView scoreTeam1Label;

    // Team 2
    AppCompatTextView scoreTeam2Label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Team 1
        scoreTeam1Label = findViewById(R.id.score_team1);

        // Team 2
        scoreTeam2Label = findViewById(R.id.score_team2);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("STATE_SCORE_1", scoreTeam1);
        outState.putInt("STATE_SCORE_2", scoreTeam2);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            scoreTeam1 = savedInstanceState.getInt("STATE_SCORE_1");
            scoreTeam1Label.setText(String.valueOf(scoreTeam1));

            scoreTeam2 = savedInstanceState.getInt("STATE_SCORE_2");
            scoreTeam2Label.setText(String.valueOf(scoreTeam2));
        }
    }

    public void decreasePoint(View view) {
        if (view.getId() == R.id.button_decrease_team1) {
            scoreTeam1--;
            scoreTeam1Label.setText(String.valueOf(scoreTeam1));
        } else if (view.getId() == R.id.button_decrease_team2) {
            scoreTeam2--;
            scoreTeam2Label.setText(String.valueOf(scoreTeam2));
        }
    }

    public void increasePoint(View view) {
        if (view.getId() == R.id.button_add_team1) {
            scoreTeam1++;
            scoreTeam1Label.setText(String.valueOf(scoreTeam1));
        } else if (view.getId() == R.id.button_add_team2) {
            scoreTeam2++;
            scoreTeam2Label.setText(String.valueOf(scoreTeam2));
        }
    }

    public void changeTheme(View view) {
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        recreate();
    }
}