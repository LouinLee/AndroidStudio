package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nameLabel;
    TextView studentLabel;
    TextView majorLabel;
    TextView hobbyLabel;
    TextView name;
    TextView student;
    TextView major;
    TextView hobby;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLabel = findViewById(R.id.nameLabel);
        studentLabel = findViewById(R.id.studentLabel);
        majorLabel = findViewById(R.id.majorLabel);
        hobbyLabel = findViewById(R.id.hobbyLabel);
        name = findViewById(R.id.name);
        student = findViewById(R.id.student);
        major = findViewById(R.id.major);
        hobby = findViewById(R.id.hobby);
        button = (Button) findViewById(R.id.button);

        nameLabel.setText("Name :");
        studentLabel.setText("Student ID :");
        majorLabel.setText("Major :");
        hobbyLabel.setText("Hobby :");
        name.setText("Louin");
        student.setText("03081220043");
        major.setText("Information Systems");
        hobby.setText("Music");
        button.setText("Okay");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}