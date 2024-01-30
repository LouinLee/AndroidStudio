package com.example.application2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    String name, gender, hobbies;
    TextView nameTextView, genderTextView, hobbiesTextView;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the data passed from LatihanActivity
        name = getIntent().getStringExtra("NAME");
        gender = getIntent().getStringExtra("GENDER");
        hobbies = getIntent().getStringExtra("HOBBIES");

        // Find the TextViews in your layout (you need to add these in your layout file)
        nameTextView = findViewById(R.id.nameTextView);
        genderTextView = findViewById(R.id.genderTextView);
        hobbiesTextView = findViewById(R.id.hobbiesTextView);

        // Set the text for each TextView
        nameTextView.setText(name);
        genderTextView.setText(gender);
        hobbiesTextView.setText(hobbies);

        // Find the back button in your layout
        backButton = findViewById(R.id.backbutton);

        // Set the back button listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous one
                finish();
            }
        });
    }
}
