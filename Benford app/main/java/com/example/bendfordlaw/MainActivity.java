package com.example.bendfordlaw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button historyButton;
    private TextView clickCounterTextView;

    private SharedPreferences sharedPreferences;
    private int countOne = 0, countTwo = 0, countThree = 0, countFour = 0, countFive = 0;
    private int countSix = 0, countSeven = 0, countEight = 0, countNine = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("ClickCounterPrefs", MODE_PRIVATE);
        loadCounts();

        btnOne = findViewById(R.id.one);
        btnTwo = findViewById(R.id.two);
        btnThree = findViewById(R.id.three);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnSix = findViewById(R.id.six);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);
        historyButton = findViewById(R.id.btn_history);
        clickCounterTextView = findViewById(R.id.txt_click_count);

        updateCounterText();

        // Set click listeners for each button
        setupButtonClick(btnOne, "one");
        setupButtonClick(btnTwo, "two");
        setupButtonClick(btnThree, "three");
        setupButtonClick(btnFour, "four");
        setupButtonClick(btnFive, "five");
        setupButtonClick(btnSix, "six");
        setupButtonClick(btnSeven, "seven");
        setupButtonClick(btnEight, "eight");
        setupButtonClick(btnNine, "nine");

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                intent.putExtra("CountOne", countOne);
                intent.putExtra("CountTwo", countTwo);
                intent.putExtra("CountThree", countThree);
                intent.putExtra("CountFour", countFour);
                intent.putExtra("CountFive", countFive);
                intent.putExtra("CountSix", countSix);
                intent.putExtra("CountSeven", countSeven);
                intent.putExtra("CountEight", countEight);
                intent.putExtra("CountNine", countNine);
                startActivity(intent);
            }
        });
    }

    private void setupButtonClick(Button button, String buttonName) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (buttonName) {
                    case "one":
                        countOne++;
                        break;
                    case "two":
                        countTwo++;
                        break;
                    case "three":
                        countThree++;
                        break;
                    case "four":
                        countFour++;
                        break;
                    case "five":
                        countFive++;
                        break;
                    case "six":
                        countSix++;
                        break;
                    case "seven":
                        countSeven++;
                        break;
                    case "eight":
                        countEight++;
                        break;
                    case "nine":
                        countNine++;
                        break;
                }
                updateCounterText();
                saveCounts();
            }
        });
    }

    private void updateCounterText() {
        clickCounterTextView.setText("Click Counts: " +
                "\n1: " + countOne +
                "\n2: " + countTwo +
                "\n3: " + countThree +
                "\n4: " + countFour +
                "\n5: " + countFive +
                "\n6: " + countSix +
                "\n7: " + countSeven +
                "\n8: " + countEight +
                "\n9: " + countNine);
    }

    private void saveCounts() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("CountOne", countOne);
        editor.putInt("CountTwo", countTwo);
        editor.putInt("CountThree", countThree);
        editor.putInt("CountFour", countFour);
        editor.putInt("CountFive", countFive);
        editor.putInt("CountSix", countSix);
        editor.putInt("CountSeven", countSeven);
        editor.putInt("CountEight", countEight);
        editor.putInt("CountNine", countNine);
        editor.apply();
    }

    private void loadCounts() {
        countOne = sharedPreferences.getInt("CountOne", 0);
        countTwo = sharedPreferences.getInt("CountTwo", 0);
        countThree = sharedPreferences.getInt("CountThree", 0);
        countFour = sharedPreferences.getInt("CountFour", 0);
        countFive = sharedPreferences.getInt("CountFive", 0);
        countSix = sharedPreferences.getInt("CountSix", 0);
        countSeven = sharedPreferences.getInt("CountSeven", 0);
        countEight = sharedPreferences.getInt("CountEight", 0);
        countNine = sharedPreferences.getInt("CountNine", 0);
    }
}