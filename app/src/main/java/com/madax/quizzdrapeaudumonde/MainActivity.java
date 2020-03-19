package com.madax.quizzdrapeaudumonde;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Questions currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create List of Questions //
        ArrayList listQuestions = new ArrayList<>();
        // First Question //
        ArrayList<String> answers = new ArrayList<>();
        answers.add("France");
        answers.add("Italie");
        answers.add("Allemagne");
        Questions q = new Questions(R.drawable.flag_france, answers, "France", "easy");
        listQuestions.add(q);
        // Second Question //
        ArrayList<String> answers1 = new ArrayList<>();
        answers1.add("Belgique");
        answers1.add("Italie");
        answers1.add("Russie");
        Questions q1 = new Questions(R.drawable.flag_italie, answers1, "Italie", "easy");
        listQuestions.add(q1);
        // Third Question //
        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add("Azerbaïdjan");
        answers2.add("Mali");
        answers2.add("Iran");
        Questions q2 = new Questions(R.drawable.flag_iran, answers2, "Iran", "medium");
        listQuestions.add(q2);
        // Fourth Question //
        ArrayList<String> answers3 = new ArrayList<>();
        answers3.add("Bolivie");
        answers3.add("Chili");
        answers3.add("Venezuela");
        Questions q3 = new Questions(R.drawable.flag_chili, answers3, "Chili", "medium");
        listQuestions.add(q3);
        // Fifth Question //
        ArrayList<String> answers4 = new ArrayList<>();
        answers4.add("Irlande");
        answers4.add("Suede");
        answers4.add("Danemark");
        Questions q4 = new Questions(R.drawable.flag_irlande, answers4, "Irlande", "hard");
        listQuestions.add(q4);
        // Sixth Question //
        ArrayList<String> answers5 = new ArrayList<>();
        answers5.add("Turquie");
        answers5.add("Slovaquie");
        answers5.add("Grece");
        Questions q5 = new Questions(R.drawable.flag_grece, answers5, "Grece", "hard");
        listQuestions.add(q5);


        //TODO : Instanciate values in the view MainActivity
        currentQuestion = (Questions) listQuestions.get(0);
        Log.v("MainActivity", String.valueOf(currentQuestion));







        //TODO : use shuffle() to randomize answers ans questions




        Button validationButton = findViewById(R.id.validationButton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton firstChoice = findViewById(R.id.firstRadioButton);
                boolean firstChoiceChecked = firstChoice.isChecked();
                RadioButton secondChoice = findViewById(R.id.secondRadioButton);
                boolean secondChoiceChecked = secondChoice.isChecked();
                RadioButton thirdChoice = findViewById(R.id.thirdRadioButton);
                boolean thirdChoiceChecked = thirdChoice.isChecked();
                Log.i("MainActivity", "First Button check : " + firstChoiceChecked);
                Log.i("MainActivity", "Second Button check : " + secondChoiceChecked);
                Log.i("MainActivity", "Third Button check : " + thirdChoiceChecked);

                TextView resultTextView = findViewById(R.id.resultTextView);
                TextView goodAnswerTextView = findViewById(R.id.goodAnswerTextView);
                if (firstChoiceChecked){
                    resultTextView.setText("Bonne réponse !!!!!!");
                    goodAnswerTextView.setText("La bonne réponse est " + 1);
                }
                else {
                    resultTextView.setText("Tes nul bouuuuuuuuuuuh");
                    goodAnswerTextView.setText("La bonne réponse est " + 1);
                }


            }
        });
    }
}
