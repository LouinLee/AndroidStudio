package com.example.application2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class QuizToDoActivity extends AppCompatActivity {

    private EditText editName;
    private RadioGroup locationGroup;
    private CheckBox checkboxSport, checkboxTraveling, checkboxFood, checkboxStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_to_do);

        initializeViews();
        setupSubmitButton();
    }

    private void initializeViews() {
        editName = findViewById(R.id.editName);
        locationGroup = findViewById(R.id.radioGroup);
        checkboxSport = findViewById(R.id.checkbox_sport);
        checkboxTraveling = findViewById(R.id.checkbox_traveling);
        checkboxFood = findViewById(R.id.checkbox_food);
        checkboxStudy = findViewById(R.id.checkbox_study);
    }

    private void setupSubmitButton() {
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(view -> handleSubmitButtonClick());
    }

    private void handleSubmitButtonClick() {
        String name = editName.getText().toString();
        if(name.trim().isEmpty()) {
            name = "Not specified";
        }
        String location = getSelectedLocation();
        String activityType = getActivityTypes();

        displayCustomToast(name, location, activityType);
    }

    private String getSelectedLocation() {
        RadioButton selectedLocation = findViewById(locationGroup.getCheckedRadioButtonId());
        return selectedLocation != null ? selectedLocation.getText().toString() : "Not specified";
    }

    private String getActivityTypes() {
        List<String> activityTypes = new ArrayList<>();
        if (checkboxSport.isChecked()) activityTypes.add("Sports");
        if (checkboxTraveling.isChecked()) activityTypes.add("Traveling");
        if (checkboxFood.isChecked()) activityTypes.add("Food");
        if (checkboxStudy.isChecked()) activityTypes.add("Study");

        if (activityTypes.isEmpty()) {
            return "Not specified";
        } else {
            return TextUtils.join(", ", activityTypes);
        }
    }

    private void displayCustomToast(String name, String location, String activityType) {
        String toastMessage = "Name: " + name + "\nLocation: " + location + "\nActivity Type: " + activityType;

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, null);

        TextView text = layout.findViewById(R.id.custom_toast_text);
        text.setText(toastMessage);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
