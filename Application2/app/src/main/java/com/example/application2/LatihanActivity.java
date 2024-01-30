package com.example.application2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class LatihanActivity extends AppCompatActivity {

    private EditText editName;
    private RadioGroup radioGroup;
    private CheckBox checkBoxCoding, checkBoxReading, checkBoxTraveling;
    private ImageButton resetButton, tickButton;
    private static final String radioTag = "Radio Button Log";
    private static final String checkBoxTag = "Checkbox Button Log";
    private static final String tickButtonTag = "Tick Button Log";
    private static final String resetButtonTag = "Reset Button Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_activity);

        // Initialize views
        editName = findViewById(R.id.editName);
        radioGroup = findViewById(R.id.radioGroup);
        checkBoxCoding = findViewById(R.id.checkbox_coding);
        checkBoxReading = findViewById(R.id.checkbox_reading);
        checkBoxTraveling = findViewById(R.id.checkbox_traveling);
        resetButton = findViewById(R.id.resetbutton);
        tickButton = findViewById(R.id.tickbutton);

        // Set listeners
        setupListeners();

        // Set tick button listener
        tickButton.setOnClickListener(v -> collectAndSendData());

        // Set reset button listener
        resetButton.setOnClickListener(v -> resetInputs());
    }

    private void setupListeners() {
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radiobutton_male) {
                Log.d(radioTag, "Radio Selected: Male");
            } else if (checkedId == R.id.radiobutton_female) {
                Log.d(radioTag, "Radio Selected: Female");
            }
        });

        checkBoxCoding.setOnCheckedChangeListener((buttonView, isChecked) ->
                Log.d(checkBoxTag, "Coding: " + (isChecked ? "Checked" : "Not Checked")));

        checkBoxReading.setOnCheckedChangeListener((buttonView, isChecked) ->
                Log.d(checkBoxTag, "Reading: " + (isChecked ? "Checked" : "Not Checked")));

        checkBoxTraveling.setOnCheckedChangeListener((buttonView, isChecked) ->
                Log.d(checkBoxTag, "Traveling: " + (isChecked ? "Checked" : "Not Checked")));
    }

    private void resetInputs() {
        editName.setText("");

        radioGroup.clearCheck();

        checkBoxCoding.setChecked(false);
        checkBoxReading.setChecked(false);
        checkBoxTraveling.setChecked(false);

        Log.d(resetButtonTag, "Reset Everything");
    }

    private String getSelectedGender() {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.radiobutton_male) return "Male";
        else if (selectedId == R.id.radiobutton_female) return "Female";
        return "";
    }

    private String getHobbiesString() {
        List<String> selectedHobbies = new ArrayList<>();

        if (checkBoxCoding.isChecked()) selectedHobbies.add("Coding");
        if (checkBoxReading.isChecked()) selectedHobbies.add("Reading");
        if (checkBoxTraveling.isChecked()) selectedHobbies.add("Traveling");

        return TextUtils.join(", ", selectedHobbies);

//        Or this one for bullet list, delimiter /n
//        if (checkBoxCoding.isChecked()) {
//            selectedHobbies.add(number++ + ". Coding");
//        }
//        if (checkBoxReading.isChecked()) {
//            selectedHobbies.add(number++ + ". Reading");
//        }
//        if (checkBoxTraveling.isChecked()) {
//            selectedHobbies.add(number++ + ". Traveling");
//        }
    }

    private void collectAndSendData() {
        String name = editName.getText().toString();
        String gender = getSelectedGender();
        String hobbies = getHobbiesString();

        // Create an Intent to start the ResultActivity
        Intent intent = new Intent(this, ResultActivity.class);

        // Pass data to ResultActivity using intent extras
        // 'NAME', 'GENDER', and 'HOBBIES' are keys used to retrieve the data in ResultActivity
        intent.putExtra("NAME", name); // Pass the name
        intent.putExtra("GENDER", gender); // Pass the gender
        intent.putExtra("HOBBIES", hobbies); // Pass the hobbies

        // Start the ResultActivity
        startActivity(intent);

        Log.d(tickButtonTag, "Name: " + name);
        Log.d(tickButtonTag, "Gender: " + gender);
        Log.d(tickButtonTag, "Hobbies: " + hobbies);
    }

// More basic implementation
//
//    private void collectAndSendData() {
//        String name = editName.getText().toString();
//
//        int selectedId = radioGroup.getCheckedRadioButtonId();
//        String gender = "";
//        if (selectedId == R.id.radiobutton_male) gender = "Male";
//        else if (selectedId == R.id.radiobutton_female) gender = "Female";
//
//        StringBuilder hobbies = new StringBuilder();
//        if (checkBoxCoding.isChecked()) hobbies.append("Coding ");
//        if (checkBoxReading.isChecked()) hobbies.append("Reading ");
//        if (checkBoxTraveling.isChecked()) hobbies.append("Traveling ");
//
//        Intent intent = new Intent(this, ResultActivity.class);
//        intent.putExtra("NAME", name);
//        intent.putExtra("GENDER", gender);
//        intent.putExtra("HOBBIES", hobbies.toString().trim());
//        startActivity(intent);
//    }
}
