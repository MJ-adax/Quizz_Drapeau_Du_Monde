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

        questions = new ArrayList<>();

        // First Question //
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Argentine");
        answers.add("France");
        answers.add("Italie");
        Question q = new Question(R.drawable.flag_argentine, answers, "Argentine", "easy");
        questions.add(q);
        // Second Question //
        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add("Belgique");
        answers1.add("Italie");
        answers1.add("Russie");
        Question q1 = new Question(R.drawable.flag_italie, answers1, "Italie", "easy");
        questions.add(q1);
        // Third Question //
        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add("Azerbaïdjan");
        answers2.add("Mali");
        answers2.add("Iran");
        Question q2 = new Question(R.drawable.flag_iran, answers2, "Iran", "medium");
        questions.add(q2);
        // Fourth Question //
        ArrayList<String> answers3 = new ArrayList<>();
        answers3.add("Bolivie");
        answers3.add("Chili");
        answers3.add("Venezuela");
        Question q3 = new Question(R.drawable.flag_chili, answers3, "Chili", "medium");
        questions.add(q3);
        // Fifth Question //
        ArrayList<String> answers4 = new ArrayList<>();
        answers4.add("Irlande");
        answers4.add("Suede");
        answers4.add("Danemark");
        Question q4 = new Question(R.drawable.flag_irlande, answers4, "Irlande", "hard");
        questions.add(q4);
        // Sixth Question //
        ArrayList<String> answers5 = new ArrayList<>();
        answers5.add("Turquie");
        answers5.add("Slovaquie");
        answers5.add("Grece");
        Question q5 = new Question(R.drawable.flag_grece, answers5, "Grece", "hard");
        questions.add(q5);
        // Seventh Question //
        ArrayList<String> answers6 = new ArrayList<>();
        answers6.add("France");
        answers6.add("Tunisie");
        answers6.add("Pays-Bas");
        Question q6 = new Question(R.drawable.flag_france, answers6, "France", "easy");
        questions.add(q6);
        // Eighth Question //
        ArrayList<String> answers7 = new ArrayList<>();
        answers7.add("Paraguay");
        answers7.add("Bolivie");
        answers7.add("Colombie");
        Question q7 = new Question(R.drawable.flag_bolivie, answers7, "Bolivie", "hard");
        questions.add(q7);
        // Nineth Question //
        ArrayList<String> answers8 = new ArrayList<>();
        answers8.add("Mali");
        answers8.add("Jamaique");
        answers8.add("Togo");
        Question q8 = new Question(R.drawable.flag_mali, answers8, "Mali", "hard");
        questions.add(q8);
        // Tenth Question //
        ArrayList<String> answers9 = new ArrayList<>();
        answers9.add("Tunisie");
        answers9.add("Congo");
        answers9.add("Cameroun");
        Question q9 = new Question(R.drawable.flag_cameroun, answers9, "Cameroun", "hard");
        questions.add(q9);
        // Eleventh Question //
        ArrayList<String> answers10 = new ArrayList<>();
        answers10.add("Pologne");
        answers10.add("Lituanie");
        answers10.add("Moldavie");
        Question q10 = new Question(R.drawable.flag_moldavie, answers10, "Moldavie", "hard");
        questions.add(q10);
        // Twelfth Question //
        ArrayList<String> answers11 = new ArrayList<>();
        answers11.add("Norvege");
        answers11.add("Suede");
        answers11.add("Finlande");
        Question q11 = new Question(R.drawable.flag_norvege, answers11, "Norvege", "hard");
        questions.add(q11);
        // Thirteenth Question //
        ArrayList<String> answers12 = new ArrayList<>();
        answers12.add("Paraguay");
        answers12.add("Uruguay");
        answers12.add("Perou");
        Question q12 = new Question(R.drawable.flag_paraguay, answers12, "Paraguay", "hard");
        questions.add(q12);
        // Fourteenth Question //
        ArrayList<String> answers13 = new ArrayList<>();
        answers13.add("Roumanie");
        answers13.add("Slovenie");
        answers13.add("Estonie");
        Question q13 = new Question(R.drawable.flag_roumanie, answers13, "Roumanie", "hard");
        questions.add(q13);

        adapter = new QuestionAdapter(questions);

        RecyclerView recyclerView = findViewById(R.id.recylerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(QuestionListActivity.this, HomeActivity.class));
        finish();
    }
}
