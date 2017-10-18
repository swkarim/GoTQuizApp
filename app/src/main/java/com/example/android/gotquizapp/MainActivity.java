package com.example.android.gotquizapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Counter that keeps track of the number of correct answers.
    int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView header = (TextView) findViewById(R.id.header);
        Typeface typeFaceGoT = Typeface.createFromAsset(getAssets(), "fonts/gameofthrones.ttf");
        header.setTypeface(typeFaceGoT);
    }

    //We check the solutions in this function
    public void checkAnswers(View view) {
        quizScore = (checkFirstQuestion() + checkSecondQuestion() + checkThirdQuestion() + checkFourthQuestion());

        Toast.makeText(this, "You got " + quizScore + "/4 questions correct!", Toast.LENGTH_LONG).show();
    }

    //Check if the correct options were selected. We want to ensure that "Lannister" and "Stark"
    //are selected but not "Gryffindor".
    public int checkFirstQuestion() {
        CheckBox lannister = (CheckBox) findViewById(R.id.lannister);
        CheckBox stark = (CheckBox) findViewById(R.id.stark);
        CheckBox gryffindor = (CheckBox) findViewById(R.id.gryffindor);

        if (lannister.isChecked() && stark.isChecked() && !gryffindor.isChecked()) {
            return 1;
        } else
            return 0;
    }

    //Here we check if the user has entered "Sam" or "sam". Anything else will be incorrect.
    public int checkSecondQuestion() {
        EditText inputSecondQuestion = (EditText) findViewById(R.id.input_question_two);
        String checkString = inputSecondQuestion.getText().toString();
        if (checkString.equals("Sam") || checkString.equals("sam"))
            return 1;
        else
            return 0;
    }

    //We find the id for the Radio Button containing "Grey Wind" and check if it is selected.
    // If this is not selected then it is incorrect.
    public int checkThirdQuestion() {
        RadioButton greyWind = (RadioButton) findViewById(R.id.grey_wind);
        if (greyWind.isChecked())
            return 1;
        else
            return 0;
    }

    //We find the id for the Radio Button containing "Three" and check if it is selected.
    // If this is not selected then it is incorrect.
    public int checkFourthQuestion() {
        RadioButton threeDragons = (RadioButton) findViewById(R.id.three_dragons);
        if (threeDragons.isChecked())
            return 1;
        else
            return 0;
    }
}
