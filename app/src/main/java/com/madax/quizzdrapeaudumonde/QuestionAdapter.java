package com.madax.quizzdrapeaudumonde;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private List<Question> questions;

    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    // OnCreate only call at the beginning to instanciate
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    // When an item disappear (kind of circle buffer)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.flag.setImageResource(question.getFlagCountry());
        holder.country.setText(question.getCorrectAnswer());
        holder.answers.setText(question.getAnswers() + "");
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final ImageView flag;
        final TextView country;
        final TextView answers;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Get graphic component in itemView (itemView = mon item_question)
            flag = itemView.findViewById(R.id.flagImageView);
            country = itemView.findViewById(R.id.countryTextView);
            answers = itemView.findViewById(R.id.answersTextView);
        }
    }
}
