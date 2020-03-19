package com.madax.quizzdrapeaudumonde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Question currentQuestion;
    private ArrayList<Question> listQuestions;
    private int indexQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent srcIntent = getIntent();
        listQuestions = srcIntent.getParcelableArrayListExtra("listQuestions");
        indexQuestion = srcIntent.getIntExtra("indexQuestion", 0);

        currentQuestion = (Question) listQuestions.get(indexQuestion);

        //TODO : use shuffle() to randomize answers

        ImageView myImageView = findViewById(R.id.defaultImageView);
        myImageView.setImageResource(currentQuestion.getFlagCountry());

        final RadioButton firstChoice = findViewById(R.id.firstRadioButton);
        firstChoice.setText(currentQuestion.getAnswers().get(0));
        final RadioButton secondChoice = findViewById(R.id.secondRadioButton);
        secondChoice.setText(currentQuestion.getAnswers().get(1));
        final RadioButton thirdChoice = findViewById(R.id.thirdRadioButton);
        thirdChoice.setText(currentQuestion.getAnswers().get(2));

        Log.v("MainActivity", String.valueOf(currentQuestion.getAnswers().get(0)));
        Log.v("MainActivity", String.valueOf(currentQuestion.getAnswers().get(1)));
        Log.v("MainActivity", String.valueOf(currentQuestion.getAnswers().get(2)));
        Log.v("MainActivity", String.valueOf(currentQuestion.getCorrectAnswer()));



        // TODO : verify if correct answer with an .equals()
        // TODO : setText on validation button + add counter to check if show the answer or next step

        Button validationButton = findViewById(R.id.validationButton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView resultTextView = findViewById(R.id.resultTextView);
                TextView goodAnswerTextView = findViewById(R.id.goodAnswerTextView);

                RadioGroup mainRadioGroup = findViewById(R.id.mainRadioGroup);
                int selectedIDRadioButton = mainRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedIDRadioButton);

                try {
                    if (currentQuestion.getCorrectAnswer().equals(selectedRadioButton.getText())) {
                        resultTextView.setText("Bonne réponse !!!!!!");
                        goodAnswerTextView.setText("La bonne réponse est " + currentQuestion.getCorrectAnswer());
                    } else {
                        resultTextView.setText("Tes nul bouuuuuuuuuuuh");
                        goodAnswerTextView.setText("La bonne réponse est " + currentQuestion.getCorrectAnswer());
                    }

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.putExtra("listQuestions", listQuestions);
                    intent.putExtra("indexQuestion", indexQuestion+1);
                    startActivity(intent);

                } catch (NullPointerException npe) {
                    Log.e("MainActivity", "NPE -> pas de reponse selectionné");
                    Toast.makeText(MainActivity.this, "Choisis un pays ducon !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
