package com.madax.quizzdrapeaudumonde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    private int countGoodAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        // Get informations send from the MainActivity
        Intent srcIntent = getIntent();
        countGoodAnswers = srcIntent.getIntExtra("countGoodAnswers", 0);

        // Set the score of the user at the end of the quizz according to his count of good answers
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText(countGoodAnswers + " / 6 ");
        // Calcul and set the percent of the user
        TextView percentTextView = findViewById(R.id.percentTextView);
        percentTextView.setText((countGoodAnswers * 100)/6 + " %");

    }

    // If buttton Back is pressed, go back to the HomeActivity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(StatsActivity.this, HomeActivity.class));
        finish();
    }
}
