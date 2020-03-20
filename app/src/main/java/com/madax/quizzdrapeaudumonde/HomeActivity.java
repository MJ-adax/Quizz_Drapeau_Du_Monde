package com.madax.quizzdrapeaudumonde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<Question> listQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Create List of Questions //
        listQuestions = new ArrayList<>();
        // First Question //
        ArrayList<String> answers = new ArrayList<>();
        answers.add("France");
        answers.add("Italie");
        answers.add("Argentine");
        Question q = new Question(R.drawable.flag_argentine, answers, "Argentine", "easy");
        listQuestions.add(q);
        // Second Question //
        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add("Belgique");
        answers1.add("Italie");
        answers1.add("Russie");
        Question q1 = new Question(R.drawable.flag_italie, answers1, "Italie", "easy");
        listQuestions.add(q1);
        // Third Question //
        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add("Azerbaïdjan");
        answers2.add("Mali");
        answers2.add("Iran");
        Question q2 = new Question(R.drawable.flag_iran, answers2, "Iran", "medium");
        listQuestions.add(q2);
        // Fourth Question //
        ArrayList<String> answers3 = new ArrayList<>();
        answers3.add("Bolivie");
        answers3.add("Chili");
        answers3.add("Venezuela");
        Question q3 = new Question(R.drawable.flag_chili, answers3, "Chili", "medium");
        listQuestions.add(q3);
        // Fifth Question //
        ArrayList<String> answers4 = new ArrayList<>();
        answers4.add("Irlande");
        answers4.add("Suede");
        answers4.add("Danemark");
        Question q4 = new Question(R.drawable.flag_irlande, answers4, "Irlande", "hard");
        listQuestions.add(q4);
        // Sixth Question //
        ArrayList<String> answers5 = new ArrayList<>();
        answers5.add("Turquie");
        answers5.add("Slovaquie");
        answers5.add("Grece");
        Question q5 = new Question(R.drawable.flag_grece, answers5, "Grece", "hard");
        listQuestions.add(q5);

        Collections.shuffle(listQuestions);


        Button beginButton = findViewById(R.id.beginQuizzButton);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                //TODO: Shuffle the listQuestions and the Index
                intent.putExtra("listQuestions", listQuestions);
                intent.putExtra("indexQuestion", 0);
                startActivity(intent);

                /* then need to charge a random question from my listQuestion */
            }
        });

        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

    }
}
