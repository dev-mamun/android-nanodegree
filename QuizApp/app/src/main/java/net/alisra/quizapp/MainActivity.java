package net.alisra.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int Q1_ANSWER = R.id.question_1_answer_2;
    final int Q2_ANSWER = R.id.question_2_answer_2;
    final int Q3_ANSWER = R.id.question_3_answer_2;
    final int Q4_ANSWER = R.id.question_4_answer_1;
    final String Q6_ANSWER = "30 metres";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkAnswer(View view) {
        ArrayList<String> incorrectAnswersList = new ArrayList<String>();
        int numberOfCorrectAnswer = 0;

        if (questionOne()) {
            numberOfCorrectAnswer++;
        } else {
            incorrectAnswersList.add("Question 1");
        }
        if (questionTwo()) {
            numberOfCorrectAnswer++;
        } else {
            incorrectAnswersList.add("Question 2");
        }
        if (questionThree()) {
            numberOfCorrectAnswer++;
        } else {
            incorrectAnswersList.add("Question 3");
        }
        if (questionFour()) {
            numberOfCorrectAnswer++;
        } else {
            incorrectAnswersList.add("Question 4");
        }
        if (questionFive()) {
            numberOfCorrectAnswer++;
        } else {
            incorrectAnswersList.add("Question 5");
        }
        if (questionSix()) {
            numberOfCorrectAnswer++;
        } else {
            incorrectAnswersList.add("Question 6");
        }

        StringBuilder sb = new StringBuilder();
        for (String s : incorrectAnswersList) {
            sb.append(s);
            sb.append("\n");
        }
        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfCorrectAnswer + "/6 answers right.";
        if (numberOfCorrectAnswer < 6) {
            text = text + "\n\n Check the following:\n\n" + sb.toString();
        }
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private boolean questionOne() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_1_radio_group);
        if (rg.getCheckedRadioButtonId() == Q1_ANSWER) {
            return true;
        }
        return false;
    }

    private boolean questionTwo() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_2_radio_group);
        if (rg.getCheckedRadioButtonId() == Q2_ANSWER) {
            return true;
        }
        return false;
    }

    private boolean questionThree() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_3_radio_group);
        if (rg.getCheckedRadioButtonId() == Q3_ANSWER) {
            return true;
        }
        return false;
    }

    private boolean questionFour() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4_radio_group);
        if (rg.getCheckedRadioButtonId() == Q4_ANSWER) {
            return true;
        }
        return false;
    }

    private boolean questionFive() {
        CheckBox c1 = (CheckBox) findViewById(R.id.question_5_answer_1);
        CheckBox c2 = (CheckBox) findViewById(R.id.question_5_answer_2);
        CheckBox c3 = (CheckBox) findViewById(R.id.question_5_answer_3);
        CheckBox c4 = (CheckBox) findViewById(R.id.question_5_answer_4);

        if (c2.isChecked() && c4.isChecked() && !c1.isChecked() && !c3.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean questionSix() {
        EditText et = (EditText) findViewById(R.id.question_6_answer);
        return et.getText().toString().equalsIgnoreCase(Q6_ANSWER);
    }
}
