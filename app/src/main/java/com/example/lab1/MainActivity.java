package com.example.lab1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static Integer score =0;
    private static Integer maxAnswers= 5;
    private static Integer countAnswered = 0;
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mTextQuiz;
    private TextView mScore;
    private Question[] mQuestionBank;

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextQuiz = findViewById(R.id.TextQuiz);
        mScore = findViewById(R.id.textView2);
        mQuestionBank = new Question[]{
                new Question(R.string.question_1, this.getResources().getString(R.string.answer_1),false),
                new Question(R.string.question_2, this.getResources().getString(R.string.answer_2),false),
                new Question(R.string.question_3, this.getResources().getString(R.string.answer_3),false),
                new Question(R.string.question_4, this.getResources().getString(R.string.answer_4),false),
                new Question(R.string.question_5, this.getResources().getString(R.string.answer_5),false),
                new Question(R.string.question_6, this.getResources().getString(R.string.answer_6),false),
                new Question(R.string.question_7, this.getResources().getString(R.string.answer_7),false),
                new Question(R.string.question_8, this.getResources().getString(R.string.answer_8),false),
                new Question(R.string.question_9, this.getResources().getString(R.string.answer_9),false),
                new Question(R.string.question_10, this.getResources().getString(R.string.answer_10),false)
        };
        updateQuestion();
        addListenerOnClickButtonTrueFalse();
    }

    public void addListenerOnClickButtonTrueFalse() {
        mTrueButton = findViewById(R.id.buttonTrue);
        mFalseButton = findViewById(R.id.buttonFalse);
        mNextButton = findViewById(R.id.buttonNext);
        mPrevButton = findViewById(R.id.buttonPrev);
        mTextQuiz = findViewById(R.id.TextQuiz);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("ПРАВДА");
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("НЕПРАВДА");
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countAnswered < maxAnswers){
                    Random random = new Random();
                    mCurrentIndex = random.nextInt(maxAnswers);
                    if(mQuestionBank[mCurrentIndex].isAnswered()){
                        mNextButton.performClick();
                    }
                    else {
                        updateQuestion();
                    }
                }
            }
        });
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countAnswered < maxAnswers) {
                    Random random = new Random();
                    mCurrentIndex = random.nextInt(maxAnswers);
                    if (mQuestionBank[mCurrentIndex].isAnswered()) {
                        mPrevButton.performClick();
                    } else {
                        updateQuestion();
                    }
                }
            }
        });
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mTextQuiz.setText(question);
        mTextQuiz.setTextColor(getResources().getColor(R.color.text));
    }

    private void checkAnswer(String userPressedTrue) {
        String  answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
        int messageResId = 0;
        mTextQuiz.setText(mQuestionBank[mCurrentIndex].ismAnswerTrue());
        mQuestionBank[mCurrentIndex].setAnswered(true);
        countAnswered++;
        if (userPressedTrue.equals(answerIsTrue)) {
            mTextQuiz.setTextColor(getResources().getColor(R.color.right));
            messageResId = R.string.toast_true;
            score++;
        } else {
            messageResId = R.string.toast_false;
            mTextQuiz.setTextColor(getResources().getColor(R.color.unright));
        }
        mScore.setText(score.toString());
        Toast toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}