package com.madax.quizzdrapeaudumonde;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class QuestionListActivity extends AppCompatActivity {

    private ArrayList<Question> questions;
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_list);

        // Get the informations send from the HomeActivity
        Intent srcIntent = getIntent();
        questions = srcIntent.getParcelableArrayListExtra("listQuestions");
        // Configure the adpater with the list of questions
        adapter = new QuestionAdapter(questions);

        RecyclerView recyclerView = findViewById(R.id.recylerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // If button back is pressed, go back to the HomeActivity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuestionListActivity.this, HomeActivity.class));
        finish();
    }
}
