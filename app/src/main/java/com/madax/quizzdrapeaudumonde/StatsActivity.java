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

        Intent srcIntent = getIntent();
        countGoodAnswers = srcIntent.getIntExtra("countGoodAnswers", 0);

        TextView scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText(countGoodAnswers + " / 6 ");

        TextView percentTextView = findViewById(R.id.percentTextView);
        percentTextView.setText((countGoodAnswers * 100)/6 + " %");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(StatsActivity.this, HomeActivity.class));
        finish();
    }
}
