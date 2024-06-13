package com.example.hla;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopicDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_topic_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView topicMessageTextView = findViewById(R.id.topic_title_text);
        LinearLayout quesLayout = findViewById(R.id.question);
        LinearLayout imagelayout = findViewById(R.id.imageLayout);

        Intent intent = getIntent();
        Bundle receivedBundle = intent.getExtras();
        if (receivedBundle != null) {
            String receivedTopic = receivedBundle.getString("topic");

            String [] answers = receivedBundle.getStringArray("answers");
            String [] questions = receivedBundle.getStringArray("questions");
            String [] img = receivedBundle.getStringArray("images");

            topicMessageTextView.setText(receivedTopic);

            for (String imageName : img) {
                ImageView imageView = new ImageView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        500,
                        LinearLayout.LayoutParams.MATCH_PARENT // Height
                );
                layoutParams.weight = 1.0f; // Weight for equal distribution
                layoutParams.setMargins(10, 10, 10, 10); // Adjust margin values as needed (left, top, right, bottom)


                imageView.setLayoutParams(layoutParams);
                int resourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());

                if (resourceId > 0) {
                    imageView.setImageResource(resourceId);
                } else {
                    Log.e("Image Error", "Image not found: " + imageName);
                }
                imagelayout.addView(imageView);
            }

            for (int i = 0; i < questions.length; i++) {
                // Create a TextView for question
                TextView questionTextView = new TextView(this);
                questionTextView.setText(questions[i]);
                questionTextView.setTextSize(22f);
                questionTextView.setTextColor(getResources().getColor(R.color.question_text_color));
                questionTextView.setTypeface(null, Typeface.BOLD);
                questionTextView.setPadding(8, 10, 8, 10);
                TextView answerTextView = new TextView(this);
                answerTextView.setText(answers[i]);
                answerTextView.setTextSize(20f);
                answerTextView.setTextColor(getResources().getColor(R.color.answer_text_color));
                answerTextView.setPadding(8, 10, 8, 10);
                quesLayout.addView(questionTextView);
                quesLayout.addView(answerTextView);
            }



        }
    }
}