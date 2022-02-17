package com.project.warehouse.hacktivapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;

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
}