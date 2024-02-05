package com.example.application2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizToDoActivity extends AppCompatActivity {

    private EditText editName;
    private RadioGroup radioGroup;
    private RadioButton radioButtonOutdoor, radioButtonIndoor;
    private CheckBox checkBoxSport, checkBoxTraveling, checkBoxFood, checkBoxStudy;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_to_do);

        // Initialize views
        initViews();

        // Set submit button listener
        submitButton.setOnClickListener(v -> collectAndDisplayData());
    }

    private void initViews() {
        editName = findViewById(R.id.editName);
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonOutdoor = findViewById(R.id.radiobutton_male); // Assuming 'Outdoor'
        radioButtonIndoor = findViewById(R.id.radiobutton_female); // Assuming 'Indoor'
        checkBoxSport = findViewById(R.id.checkbox_sport);
        checkBoxTraveling = findViewById(R.id.checkbox_traveling);
        checkBoxFood = findViewById(R.id.checkbox_food);
        checkBoxStudy = findViewById(R.id.checkbox_study);
        submitButton = findViewById(R.id.submit_button);
    }

    private void collectAndDisplayData() {
        String name = editName.getText().toString().trim();
        String location = getLocation();
        String activities = getSelectedActivities();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = "Name: " + name + "\nLocation: " + location + "\nActivities: " + activities;
        Log.d("Data", message);
        Toast.makeText(QuizToDoActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private String getLocation() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.radiobutton_male) {
            return "Outdoor";
        } else if (selectedId == R.id.radiobutton_female) {
            return "Indoor";
        } else {
            return "Not selected";
        }
    }

    private String getSelectedActivities() {
        StringBuilder selectedActivities = new StringBuilder();
        if (checkBoxSport.isChecked()) selectedActivities.append("Sports, ");
        if (checkBoxTraveling.isChecked()) selectedActivities.append("Traveling, ");
        if (checkBoxFood.isChecked()) selectedActivities.append("Food, ");
        if (checkBoxStudy.isChecked()) selectedActivities.append("Study, ");

        // Remove the last comma and space if there are selected activities
        if (selectedActivities.length() > 0) {
            selectedActivities.delete(selectedActivities.length() - 2, selectedActivities.length());
        }

        return selectedActivities.toString();
    }
}
