package com.example.bendfordlaw;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    private TextView countOneView, countTwoView, countThreeView, countFourView, countFiveView;
    private TextView countSixView, countSevenView, countEightView, countNineView;
    private TextView totalView; // TextView for total
    private Button resetButton, backButton, percentageButton; // Renamed percentage button
    private SharedPreferences sharedPreferences;

    private int countOne, countTwo, countThree, countFour, countFive;
    private int countSix, countSeven, countEight, countNine;

    private boolean displayPercentages = false; // Flag to track display state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        sharedPreferences = getSharedPreferences("ClickCounterPrefs", MODE_PRIVATE);

        countOne = getIntent().getIntExtra("CountOne", 0);
        countTwo = getIntent().getIntExtra("CountTwo", 0);
        countThree = getIntent().getIntExtra("CountThree", 0);
        countFour = getIntent().getIntExtra("CountFour", 0);
        countFive = getIntent().getIntExtra("CountFive", 0);
        countSix = getIntent().getIntExtra("CountSix", 0);
        countSeven = getIntent().getIntExtra("CountSeven", 0);
        countEight = getIntent().getIntExtra("CountEight", 0);
        countNine = getIntent().getIntExtra("CountNine", 0);

        // Initialize TextViews
        countOneView = findViewById(R.id.txt_count_one);
        countTwoView = findViewById(R.id.txt_count_two);
        countThreeView = findViewById(R.id.txt_count_three);
        countFourView = findViewById(R.id.txt_count_four);
        countFiveView = findViewById(R.id.txt_count_five);
        countSixView = findViewById(R.id.txt_count_six);
        countSevenView = findViewById(R.id.txt_count_seven);
        countEightView = findViewById(R.id.txt_count_eight);
        countNineView = findViewById(R.id.txt_count_nine);

        totalView = findViewById(R.id.txt_total);

        // Calculate total
        int totalCount = countOne + countTwo + countThree + countFour + countFive +
                countSix + countSeven + countEight + countNine;
        totalView.setText(String.valueOf(totalCount));

        // Set the values in the TextViews
        updateCounts();

        percentageButton = findViewById(R.id.btn_percentage); // Initialize updated button
        resetButton = findViewById(R.id.btn_reset);
        backButton = findViewById(R.id.btn_back);

        percentageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayPercentages = !displayPercentages; // Toggle state
                updateCounts(); // Update displayed values
                percentageButton.setText(displayPercentages ? "NUMBERS" : "PERCENTAGE"); // Change button text
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCounts();
                updateCounts(); // Update display for reset
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Go back to MainActivity
            }
        });
    }

    private void updateCounts() {
        if (displayPercentages) {
            // Calculate percentages
            int totalCount = countOne + countTwo + countThree + countFour + countFive +
                    countSix + countSeven + countEight + countNine;

            countOneView.setText(String.format("%.2f%%", ((double)countOne / totalCount) * 100));
            countTwoView.setText(String.format("%.2f%%", ((double)countTwo / totalCount) * 100));
            countThreeView.setText(String.format("%.2f%%", ((double)countThree / totalCount) * 100));
            countFourView.setText(String.format("%.2f%%", ((double)countFour / totalCount) * 100));
            countFiveView.setText(String.format("%.2f%%", ((double)countFive / totalCount) * 100));
            countSixView.setText(String.format("%.2f%%", ((double)countSix / totalCount) * 100));
            countSevenView.setText(String.format("%.2f%%", ((double)countSeven / totalCount) * 100));
            countEightView.setText(String.format("%.2f%%", ((double)countEight / totalCount) * 100));
            countNineView.setText(String.format("%.2f%%", ((double)countNine / totalCount) * 100));

        } else {
            // Show raw counts again
            countOneView.setText(String.valueOf(countOne));
            countTwoView.setText(String.valueOf(countTwo));
            countThreeView.setText(String.valueOf(countThree));
            countFourView.setText(String.valueOf(countFour));
            countFiveView.setText(String.valueOf(countFive));
            countSixView.setText(String.valueOf(countSix));
            countSevenView.setText(String.valueOf(countSeven));
            countEightView.setText(String.valueOf(countEight));
            countNineView.setText(String.valueOf(countNine));
        }
    }

    private void resetCounts() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("CountOne", 0);
        editor.putInt("CountTwo", 0);
        editor.putInt("CountThree", 0);
        editor.putInt("CountFour", 0);
        editor.putInt("CountFive", 0);
        editor.putInt("CountSix", 0);
        editor.putInt("CountSeven", 0);
        editor.putInt("CountEight", 0);
        editor.putInt("CountNine", 0);
        editor.apply();

        // Reset the display to show "0"
        countOneView.setText("0");
        countTwoView.setText("0");
        countThreeView.setText("0");
        countFourView.setText("0");
        countFiveView.setText("0");
        countSixView.setText("0");
        countSevenView.setText("0");
        countEightView.setText("0");
        countNineView.setText("0");

        totalView.setText("0"); // Reset total on reset
    }
}