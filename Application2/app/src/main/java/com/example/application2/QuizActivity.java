package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class QuizActivity extends AppCompatActivity {

    LinearLayout button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Initialize both buttons
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // Set up click listeners
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        button1.setOnClickListener(view -> navigateTo(MainActivity.class));
        button2.setOnClickListener(view -> navigateTo(QuizToDoActivity.class));
    }

    private void navigateTo(Class<?> cls) {
        Intent intent = new Intent(QuizActivity.this, cls);
        startActivity(intent);
    }
}
