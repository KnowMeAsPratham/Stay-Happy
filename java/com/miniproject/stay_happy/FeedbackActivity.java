package com.miniproject.stay_happy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    TextView feedback;
    RatingBar rating;

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedback = findViewById(R.id.tvfeedback);
        rating = findViewById(R.id.rbstars);
        btn = findViewById(R.id.btn_send);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (v==0)
                {
                    feedback.setText("Very Dissatisfying");
                }
                else if (v==1)
                {
                    feedback.setText("Dissatisfying");
                }
                else if (v==2 || v==3)
                {
                    feedback.setText("Ok");
                }
                else if (v==4)
                {
                    feedback.setText("Satisfying");
                }
                else
                {
                    feedback.setText("Very satisfying");
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FeedbackActivity.this, "Thanks for your Feedback", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FeedbackActivity.this,DashboardActivity.class));
            }
        });
    }
}