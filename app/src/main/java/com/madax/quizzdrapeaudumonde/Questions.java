package com.madax.quizzdrapeaudumonde;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Questions implements Parcelable {
    private final int flagCountry;
    private final ArrayList<String> answers;
    private final String correctAnswer;
    private final String difficulty;


    protected Questions(Parcel in) {
        flagCountry = in.readInt();
        answers = in.createStringArrayList();
        correctAnswer = in.readString();
        difficulty = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(flagCountry);
        dest.writeStringList(answers);
        dest.writeString(correctAnswer);
        dest.writeString(difficulty);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };

    // Getter of the variables
    public int getFlagCountry() {
        return flagCountry;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    // Constructor
    public Questions(int flagCountry, ArrayList<String> answers, String correctAnswer, String difficulty) {
        this.flagCountry = flagCountry;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;
    }

    // Function toString()
    @Override
    public String toString() {
        return "Questions{" +
                "flagCountry=" + flagCountry +
                ", answers=" + answers +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
