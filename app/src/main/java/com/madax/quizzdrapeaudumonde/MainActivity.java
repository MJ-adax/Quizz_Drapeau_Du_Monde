package com.madax.quizzdrapeaudumonde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

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
        Log.v("MainActivity", String.valueOf(currentQuestion));


        //TODO : use shuffle() to randomize answers

        ImageView myImageView = findViewById(R.id.defaultImageView);
        myImageView.setImageResource(currentQuestion.getFlagCountry());

        RadioButton firstChoice = findViewById(R.id.firstRadioButton);
        firstChoice.setText(currentQuestion.getAnswers().get(0));
        RadioButton secondChoice = findViewById(R.id.secondRadioButton);
        secondChoice.setText(currentQuestion.getAnswers().get(1));
        RadioButton thirdChoice = findViewById(R.id.thirdRadioButton);
        thirdChoice.setText(currentQuestion.getAnswers().get(2));


        // TODO : verify if correct answer with an .equals()
        // TODO : setText on validation button + add counter to check if show the answer or next step

        findViewById(R.id.validationButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("listQuestions", listQuestions);
                intent.putExtra("indexQuestion", indexQuestion+1);
                startActivity(intent);


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
